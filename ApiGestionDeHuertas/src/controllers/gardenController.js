const Garden = require('../models/Garden')
const Gardener = require('../models/Gardener')
const Vegetable = require('../models/Vegetable')

// MOstrar todas las huertas
exports.getAllGardens = async(req, res) => {
    try {
        const garden = await Garden.find().populate('vegetables').populate('gardeners')
        return res.status(200).json(garden)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
//  MOstrar huerta por Id
exports.getGardensById = async(req, res) => {
    try {
        const garden = await Garden.findById(req.params.id).populate('vegetables').populate('gardeners')
        if(!garden){
            return res.status(404).json({msg : 'No se encontro la huerta'})
        }
        return res.status(200).json(garden)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Crear una huerta
exports.createGardens = async(req, res) => {
    try {
        const newGarden = new Garden(req.body)
        await newGarden.save()
        return res.status(201).json(newGarden)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Editar una huerta
exports.updateGardens = async(req, res) => {
    try {
        const updatedGarden = await Garden.findByIdAndUpdate(req.params.id, req.body, {new : true}).populate('vegetables').populate('gardeners')
        if (!updatedGarden){
            return res.status(404).json({msg : 'No se encontro la huerta'})
        }
        return res.status(200).json(updatedGarden)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Eliminar una huerta
exports.deleteGardens = async(req, res) => {
    try {
        const deletedGarden = await Garden.findByIdAndDelete(req.params.id)
        if (!deletedGarden){
            return res.status(404).json({msg : 'No se encontro la huerta'})
        }
        return res.status(200).json({msg : 'Se elimino la huerta'})
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Asignar una hortaliza a una huerta
exports.assingVegetableToGarden = async(req, res) => {
    try {
        const garden = await Garden.findById(req.params.id).populate('vegetables').populate('gardeners')
        const vegetable = await Vegetable.findById(req.params.vegetableId).populate('garden')
        if(!vegetable || !garden){
            return res.status(404).json({msg : 'No se encontro el recurso'})
        }
        if(!garden.vegetables.includes(vegetable._id)){
            garden.vegetables.push(vegetable)
            vegetable.garden = garden._id
            await garden.save()
            await vegetable.save()
        }
        return res.status(200).json(garden)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Asignar un encargado a una huerta
exports.assingGardenerToGarden = async(req, res) => {
    try {
        const garden = await Garden.findById(req.params.id).populate('vegetables').populate('gardeners')
        const gardener = await Gardener.findById(req.params.gardenerId).populate('vegetables')
        if (!garden || !gardener){
            return res.status(404).json({msg : 'No se encontro el recurso'})
        }
        if (!garden.gardeners.includes(gardener)){
            garden.gardeners.push(gardener)
            await garden.save()
        }
        return res.status(200).json(garden)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
