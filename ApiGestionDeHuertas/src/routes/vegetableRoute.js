const express = require('express')
const vegetableController = require('../controllers/vegetableController')
const route = express.Router

// getAll
route.get('/', vegetableController.getAllVegtables)
// getByID
route.get('/:id', vegetableController.getVegtableById)
// post
route.post('/', vegetableController.createVegtable)
// put
route.put('/:id', vegetableController.updateVegtable)
// delete
route.delete('/:id', vegetableController.deleteVegtable)