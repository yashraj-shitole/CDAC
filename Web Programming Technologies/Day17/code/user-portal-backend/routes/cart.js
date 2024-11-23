const express = require('express')
const db = require('../db')
const utils = require('../utils')

const router = express.Router()

router.get('/', (request, response) => {
  const statement = `
        SELECT c.id, c.productId, c.quantity, c.createdDateTime, p.price, p.title, p.image
        FROM Cart c, Product p
        WHERE c.productId = p.id AND customerId = ? 
    `
  db.pool.query(statement, [request.user.id], (error, products) => {
    response.send(utils.createResult(error, products))
  })
})

router.post('/', (request, response) => {
  const { productId, price, quantity } = request.body

  // make sure the same product is not present in the cart
  db.pool.query(
    `SELECT id FROM Cart WHERE customerId = ? and productId = ?`,
    [request.user.id, productId],
    (error, items) => {
      if (error) {
        response.send(utils.createError(error))
      } else {
        // there is not such item present in the cart table
        if (items.length == 0) {
          const statement = `
                INSERT INTO Cart (
                    productId, price, quantity, customerId
                ) VALUES (?, ?, ?,?)
            `
          db.pool.query(
            statement,
            [productId, price, quantity, request.user.id],
            (error, products) => {
              response.send(utils.createResult(error, products))
            }
          )
        } else {
          // if you want to can write the code to update the quantity

          // the product is already added to the cart
          response.send(utils.createError('product already exists in the cart'))
        }
      }
    }
  )
})

router.patch('/:cartId/:quantity', (request, response) => {
  const { cartId, quantity } = request.params
  const statement = `
    UPDATE Cart 
    SET quantity = ?
    WHERE id = ?
  `
  db.pool.query(statement, [quantity, cartId], (error, products) => {
    response.send(utils.createResult(error, products))
  })
})

router.delete('/:cartId', (request, response) => {
  const { cartId } = request.params
  const statement = `
    DELETE FROM Cart 
    WHERE id = ?
  `
  db.pool.query(statement, [cartId], (error, products) => {
    response.send(utils.createResult(error, products))
  })
})

module.exports = router
