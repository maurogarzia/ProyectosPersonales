const express = require('express')
const route = express.Router()
const bookController = require('../controllers/booksController')

// getAll
route.get('/', bookController.getAllBooks)
// getById
route.get('/:id', bookController.getBookById)
// post
route.post('/', bookController.createBook)
// put
route.put('/:id', bookController.updateBook)
//delete
route.delete('/:id', bookController.deleteBook)
// put assign reader
route.put('/:id/add-reader/:readerId', bookController.AssignReaderToBook)

module.exports = route
