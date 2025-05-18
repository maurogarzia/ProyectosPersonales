const express = require('express')
const route = express.Router()
const sessionsController = require('../controllers/sessionsController')


// getAll
route.get('/', sessionsController.getAllSessions)
// getById
route.get('/:id', sessionsController.getSessionById)
// post
route.post('/', sessionsController.createSession)
// put
route.put('/:id', sessionsController.updatedSession)
//delete
route.delete('/:id', sessionsController.deleteSession)

module.exports = route