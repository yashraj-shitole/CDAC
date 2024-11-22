const express = require('express')
const db = require('../db')
const utils = require('../utils')

const router = express.Router()

router.get('/', (request, response) => {
  db.pool.query(
    `SELECT id, firstName, lastName, email, phone, isActive FROM Customer`,
    (error, customers) => {
      response.send(utils.createResult(error, customers))
    }
  )
})

router.patch('/:userId/:status', (request, response) => {
  const { userId, status } = request.params
  db.pool.execute(
    `UPDATE Customer SET isActive = ? WHERE id = ?`,
    [status, userId],
    (error, customers) => {
      response.send(utils.createResult(error, customers))
    }
  )
})
module.exports = router
