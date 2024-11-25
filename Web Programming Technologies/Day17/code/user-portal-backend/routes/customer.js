const express = require('express')
const db = require('../db')
const utils = require('../utils')
const cryptoJs = require('crypto-js')
const jwt = require('jsonwebtoken')
const config = require('../config')
const mailer = require('../mailer')

const router = express.Router()

router.post('/signup', (request, response) => {
  const { firstName, lastName, email, password, phone } = request.body

  const statement = `
        INSERT INTO Customer (
            firstName, lastName, email, password, phone
        ) VALUES (?, ?, ?, ?, ?);
    `

  // encrypt the password
  const encryptedPassword = String(cryptoJs.MD5(password))

  db.pool.execute(
    statement,
    [firstName, lastName, email, encryptedPassword, phone],
    (error, result) => {
      if (error) {
        response.send(utils.createError(error))
        return
      }

      // send en email to the customer
      const body = `
        <html>
          <body>
            <h1>MyStore</h1>
            <br/>
            <p>Thank you for registering with us. .......</p>
            <br/>
            <div>Thank you,</div>
            <div>MyStore.</div>
          </body>
        </html>
      `
      mailer.sendEmail(
        email,
        'Thank for registering with us',
        body,
        (error, result) => {
          response.send(utils.createResult(error, result))
        }
      )
    }
  )
})

router.post('/signin', (request, response) => {
  const { email, password } = request.body

  // encrypt the password
  const encryptedPassword = String(cryptoJs.MD5(password))

  const statement = `
        SELECT id, firstName, lastName, isActive, phone
        FROM Customer
        WHERE email = ? and password = ?
    `

  db.pool.query(statement, [email, encryptedPassword], (error, users) => {
    if (error) {
      response.send(utils.createError(error))
    } else {
      if (users.length == 0) {
        response.send(utils.createError('user user does not exist'))
      } else {
        // get the matching user user details
        const { firstName, lastName, id, phone, isActive } = users[0]

        if (!isActive) {
          // if user is not active, do not let user login
          response.send(
            utils.createError(
              'You are blocked on the platform. Contact administrator.'
            )
          )
          return
        }

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
