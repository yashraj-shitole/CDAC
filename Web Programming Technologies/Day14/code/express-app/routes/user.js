const express = require('express')
const db = require('../db')

const router = express.Router()

router.post('/signup', (request, response) => {
  const {
    firstName,
    lastName,
    email,
    phone,
    address1,
    address2,
    gender,
    city,
    state,
    birthDate,
    password,
  } = request.body

  const query = `
    INSERT INTO User(
      firstName, lastName, address1, address2, city, state, email, phone, gender, birthDate, password
    ) VALUES (
      ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
    )
  `
  db.pool.execute(
    query,
    [
      firstName,
      lastName,
      address1,
      address2,
      city,
      state,
      email,
      phone,
      gender,
      birthDate,
      password,
    ],
    (error, result) => {
      if (error) {
        response.send('error')
      } else {
        response.send('ok')
      }
    }
  )
})

router.post('/signin', (request, response) => {
  const { email, password } = request.body

  const statement = `
    SELECT id, firstName, lastName 
    FROM User
    WHERE email = ? and password = ?
  `

  db.pool.query(statement, [email, password], (error, users) => {
    if (error) {
      response.send('error')
    } else {
      if (users.length == 0) {
        response.send('user does not exist')
      } else {
        response.send('found')
      }
    }
  })
})

module.exports = router
