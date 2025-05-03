const Gardener = require('../models/Gardener')

// Mostrar todos los jardineros
exports.getAllGardener = async(req, res) => {
    try {
        const gardener = await Gardener.find().populate('vegetables')
        return res.status(200).json(gardener)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Mostrar jardinero por id
exports.getGardenerById = async(req, res) => {
    try {
        const gardener = await Gardener.findById(req.params.id).populate('vegetables')
        if(!gardener){
            return res.status(404).json({msg : 'No se encontro el jardinero'})
        }
        return res.status(200).json(gardener)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Crear jardinero
exports.createGardener = async(req, res) => {
    try {
        const newGardener = new Gardener(req.body)
        await newGardener.save()
        return res.status(201).json(newGardener)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Editar jardinero
exports.updateGardener = async(req, res) => {
    try {
        const updatedGardener = await Gardener.findByIdAndUpdate(req.params.id, req.body, {new : true}).populate('vegetables')
        if (!updatedGardener){
            return res.status(404).json({msg : 'No se encontro el jardinero'})
        }
        return res.status(200).json(updatedGardener)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Eliminar jardinero
exports.deleteGardener = async(req, res) => {
    try {
        const deletedGardener = await Gardener.findByIdAndDelete(req.params.id)
        if (!deletedGardener){
            return res.status(404).json({msg : 'No se encontro el jardinero'})
        }
        return res.status(200).json({msg : 'Jardinero eliminado'})
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}