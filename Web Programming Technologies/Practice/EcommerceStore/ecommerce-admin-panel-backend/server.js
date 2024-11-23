const express = require('express')
const cors = require('cors')
const morgan = require('morgan')

const app = express()
app.use(cors())
app.use(morgan('combined'))
app.use(express.json({ limit: '10mb' }))
app.use(express.urlencoded({ limit: '100mb' }))


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
