const express = require('express')
const db = require('../db')
const utils = require('../utils')
const multer = require('multer')
const upload = multer({ dest: 'images' })

const router = express.Router()

router.get('/', (request, response) => {
  const statement = `
        SELECT id, title, price, image
        FROM Product
        WHERE isActive = 1
    `
  db.pool.query(statement, (error, products) => {
    response.send(utils.createResult(error, products))
  })
})

router.get('/details/:id', (request, response) => {
  const { id } = request.params
  const statement = `
        SELECT p.id, p.title, p.price, p.image, p.details, p.tags, c.title as categoryTitle, b.title as brandTitle
        FROM Product p, Category c, ProductBrand b
        WHERE p.isActive = 1 AND p.categoryId = c.id AND p.brandId = b.id AND p.id = ?
    `
  db.pool.query(statement, [id], (error, products) => {
    response.send(utils.createResult(error, products))
  })
})

module.exports = router
