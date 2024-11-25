const express = require('express')
const db = require('../db')
const utils = require('../utils')
const cryptoJs = require('crypto-js')
const jwt = require('jsonwebtoken')
const config = require('../config')

const router = express.Router()

router.post('/signup', (request, response) => {
  const { firstName, lastName, email, password, phone } = request.body

  const statement = `
        INSERT INTO Admin (
            firstName, lastName, email, password, phone
        ) VALUES (?, ?, ?, ?, ?);
    `

  // encrypt the password
  const encryptedPassword = String(cryptoJs.MD5(password))

  db.pool.execute(
    statement,
    [firstName, lastName, email, encryptedPassword, phone],
    (error, result) => {
      response.send(utils.createResult(error, result))
    }
  )
})

router.post('/signin', (request, response) => {
  const { email, password } = request.body

  // encrypt the password
  const encryptedPassword = String(cryptoJs.MD5(password))

  const statement = `
        SELECT id, firstName, lastName, isActive, phone
        FROM Admin
        WHERE email = ? and password = ?
    `

  db.pool.query(statement, [email, encryptedPassword], (error, admins) => {
    if (error) {
      response.send(utils.createError(error))
    } else {
      if (admins.length == 0) {
        response.send(utils.createError('admin user does not exist'))
      } else {
        // get the matching admin user details
        const { firstName, lastName, id, phone } = admins[0]

        // create jwt payload
        const payload = {
          id,
          firstName,
          lastName,
          email,
        }

        // create jwt token
        const token = jwt.sign(payload, config.secret)

        response.send(
          utils.createSuccess({
            token,
            firstName,
            lastName,
            phone,
          })
        )
      }
    }
  })
})

module.exports = router
