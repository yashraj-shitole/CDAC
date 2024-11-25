const express = require('express')
const db = require('../db')
const utils = require('../utils')
const mysql = require('mysql2/promise')

const router = express.Router()

router.get('/', async (request, response) => {
  // create connection
  const connection = await mysql.createConnection({
    host: 'localhost',
    pool: 3306,
    user: 'root',
    password: 'root',
    database: 'my_store_db',
  })

  const allOrders = []

  // get all the orders
  const [orders] = await connection.execute(
    `SELECT id, totalAmount, createdDateTime, status FROM CustomerOrder`
  )

  // for every order get the product details
  for (const order of orders) {
    const [details] = await connection.execute(
      `SELECT o.id, p.title, p.image, o.quantity, o.price FROM OrderDetails o, Product p WHERE o.productId = p.id AND orderId = ?`,
      [order['id']]
    )
    allOrders.push({ order, details })
  }

  // close the connection
  connection.end()

  response.send(utils.createSuccess(allOrders))
})

router.post('/', async (request, response) => {
  const { totalAmount } = request.body

  // create connection
  const connection = await mysql.createConnection({
    host: 'localhost',
    pool: 3306,
    user: 'root',
    password: 'root',
    database: 'my_store_db',
  })

  // get all items from cart
  const [items] = await connection.execute(
    `SELECT * FROM Cart WHERE customerId = ?`,
    [request.user.id]
  )

  if (items.length == 0) {
    // there are not cart items
    response.send(utils.createError('not items in the cart'))
    return
  }

  // insert a row in order table
  const [result] = await connection.execute(
    `INSERT INTO CustomerOrder (customerId, totalAmount) VALUES (?, ?)`,
    [request.user.id, totalAmount]
  )

  // extract order id from result
  const orderId = result['insertId']

  // for evert cart item create a new row in order details table
  for (const item of items) {
    await connection.execute(
      `
        INSERT INTO OrderDetails (orderId, productId, price, quantity)
        VALUES (?, ?, ?, ?)
    `,
      [orderId, item['productId'], item['price'], item['quantity']]
    )
  }

  // delete all items from cart
  await connection.execute(`DELETE FROM Cart WHERE customerId = ?`, [
    request.user.id,
  ])

  // close the connection
  connection.end()

  response.send(utils.createSuccess('done'))
})

router.delete('/:orderId', (request, response) => {
  const { orderId } = request.params
  const statement = `
    DELETE FROM CustomerOrder 
    WHERE id = ?
  `
  db.pool.query(statement, [orderId], (error, products) => {
    response.send(utils.createResult(error, products))
  })
})

module.exports = router
