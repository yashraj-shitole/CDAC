const express = require('express')
const cors = require('cors')
const morgan = require('morgan')
const utils = require('./utils')
const jwt = require('jsonwebtoken')
const config = require('./config')

const app = express()
app.use(cors())
app.use(morgan('combined'))
app.use(express.json({ limit: '10mb' }))
app.use(express.urlencoded({ limit: '100mb' }))

// static routing
app.use(express.static('images'))

// user authorization
app.use((request, response, next) => {
  // is token really needed
  if (request.url == '/customer/signup' || request.url == '/customer/signin') {
    // token is not needed here
    next()
  } else {
    // token is required here
    const token = request.headers['token']

    // user has not passed any token
    if (!token || token.length == 0) {
      response.send(utils.createError('missing token'))
      return
    }

    // token is sent by user
    // validate it
    try {
      const payload = jwt.verify(token, config.secret)

      // add the user details in the request
      // since the next() will pass the same request object to the
      // required route, you will be able to access these details
      // in any of the routes
      request.user = payload

      // since the token is valid, continue further calling the required route
      next()
    } catch (ex) {
      response.send(utils.createError('invalid token'))
    }
  }
})

// add routers
const userRouter = require('./routes/customer')
const productRouter = require('./routes/product')
const cartRouter = require('./routes/cart')
const orderRouter = require('./routes/order')

app.use('/customer', userRouter)
app.use('/product', productRouter)
app.use('/cart', cartRouter)
app.use('/order', orderRouter)

app.listen(4100, '0.0.0.0', () => {
  console.log(`server started on port 4100`)
})
