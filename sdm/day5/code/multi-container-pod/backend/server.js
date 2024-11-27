const express = require('express')
const app = express()

app.get('/', (request, response) => {
  response.send('v1')
})
app.listen(3000, '0.0.0.0', () => {
  console.log(`server started on port 3000`)
})
