const express = require('express')
const cors = require('cors')
const morgan = require('morgan')

const app = express()
app.use(cors())
app.use(morgan('combined'))
app.use(express.json({ limit: '10mb' }))
app.use(express.urlencoded({ limit: '100mb' }))

// static routing
// http://localhost:4000/b9e9eeb7eb0dc533feadb35fa4bc5de2
// search the file in images directory
// If file exists, return the file's data
// Else search the url or path in routers collection
app.use(express.static('images'))

// adding routes
const adminRouter = require('./routes/admin')
const categoryRouter = require('./routes/category')
const brandRouter = require('./routes/brand')
const productRouter = require('./routes/product')
const customerRouter = require('./routes/customer')

app.use('/admin', adminRouter)
app.use('/category', categoryRouter)
app.use('/brand', brandRouter)
app.use('/product', productRouter)
app.use('/customer', customerRouter)

app.listen(4000, '0.0.0.0', () => {
  console.log(`server started on port 4000`)
})
