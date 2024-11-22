const express = require('express')
const db = require('../db')

const router = express.Router()

router.post('/signup', (request, response) => {
  const {
    firstName,
    lastName,
    email,
    phone,
    password,
  } = request.body

  const query = `
    INSERT INTO User(
      firstName, lastName, email, phone,password
    ) VALUES (
      ?, ?, ?, ?, ?
    )
  `
  db.pool.execute(
    query,
    [
      firstName,
      lastName,
      email,
      phone,
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

router.get('/getusers',(req,res)=>{

  const query=`SELECT * from User`
  db.pool.query(query,(err,result)=>{
      if (err) {
          return res.status(500).json({ status: "error", message: error.message });
      }

      res.status(200).json({
          status: "success",
          data: result
      });
      console.log("bookings fetched successfully.");
  })
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
