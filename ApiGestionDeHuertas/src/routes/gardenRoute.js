const express = require('express')
const route = express.Router
const gardenController = require('../controllers/gardenController')

//getAll
route('/', gardenController.getAllGardens)
//getById
route('/:id', gardenController.getGardensById)
//post
route('/', gardenController.createGardens)
//put
route('/:id', gardenController.updateGardens)
//put asignar hortaliza a la huerta
route('/:id/add-vegetable/:vegetableId', gardenController.assingVegetableToGarden)
//put asignar encargado a la huerta
route('/:id/add-gardener/:gardenerId', gardenController.assingGardenerToGarden)
//delete
route('/:id', gardenController.deleteGardens)