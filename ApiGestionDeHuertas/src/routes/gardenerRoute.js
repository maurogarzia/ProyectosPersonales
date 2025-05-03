const express = require('express')
const route = express.Router
const gardenerController = require('../controllers/gardenerController')

// getAll
route.get('/', gardenerController.getAllGardener)
//getById
route.get('/:id', gardenerController.getGardenerById)
//Post
route.post('/', gardenerController.createGardener)
// update
route.put('/:id', gardenerController.updateGardener)
// delete
route.delete('/:id', gardenerController.deleteGardener)