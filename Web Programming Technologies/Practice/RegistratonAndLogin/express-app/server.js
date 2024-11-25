const express = require('express')
const morgan = require('morgan')
const cors = require('cors')

const app = express()
app.use(cors())
app.use(express.json())
app.use(morgan('combined'))

// load all the routes
const userRouter = require('./routes/user')
app.use('/user', userRouter)

app.listen(4000, '0.0.0.0', () => {
  console.log('server started on port 4000')
})
