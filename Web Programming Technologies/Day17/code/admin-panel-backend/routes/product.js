const express = require('express')
const db = require('../db')
const utils = require('../utils')
const multer = require('multer')
const upload = multer({ dest: 'images' })

const router = express.Router()

router.get('/', (request, response) => {
  const statement = `
        SELECT id, title, price, details, image, tags
        FROM Product
        WHERE isActive = 1
    `
  db.pool.query(statement, (error, products) => {
    response.send(utils.createResult(error, products))
  })
})

router.post('/', upload.single('image'), (request, response) => {
  const { title, details, categoryId, brandId, price, tags } = request.body
  const statement = `
    INSERT INTO Product(
        title, details, categoryId, brandId, price, tags, image
    ) VALUES (?, ?, ?, ?, ?, ?, ?)
  `

  // get the file name of uploaded image
  const image = request.file.filename
  db.pool.execute(
    statement,
    [title, details, categoryId, brandId, price, tags, image],
    (error, result) => {
      response.send(utils.createResult(error, result))
    }
  )
})

router.delete('/:id', (request, response) => {
  const { id } = request.params

  const statement = `
        DELETE FROM Product
        WHERE id = ?
    `
  db.pool.execute(statement, [id], (error, result) => {
    response.send(utils.createResult(error, result))
  })
})

module.exports = router
