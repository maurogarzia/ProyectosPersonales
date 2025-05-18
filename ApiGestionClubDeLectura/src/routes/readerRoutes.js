const express = require('express')
const route = express.Router()
const readerController = require('../controllers/readerController')


// getAll
route.get('/', readerController.getAllReaders)
// getById
route.get('/:id', readerController.getReaderById)
// post
route.post('/', readerController.createReader)
// put
route.put('/:id', readerController.updateReader)
//delete
route.delete('/:id', readerController.deleteReader)

module.exports = route