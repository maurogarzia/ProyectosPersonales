const Vegetable = require('../models/Vegetable')

// Mostrar todas las hortalizas
exports.getAllVegtables = async(req, res) => {
    try {
        const vegetable = await Vegetable.find().populate('garden')
        return res.status(200).json(vegetable)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Mostrar hortaliza por id
exports.getVegtableById = async(req, res) => {
    try {
        const vegetable = Vegetable.findById(req.params.id).populate('garden')
        if (!vegetable){
            return res.status(400).json({msg : 'No se encontro la hortaliza'})
        }
        return res.status(200).json(vegetable)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Crear una hortaliza
exports.createVegtable = async(req, res) => {
    try {
        const newVegetable = new Vegetable(req.body)
        await newVegetable.save()
        return res.status(201).json(newVegetable)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// editar una hortaliza
exports.updateVegtable = async(req, res) => {
    try {
        const updatedVegetable = await Vegetable.findByIdAndUpdate(req.params.id, req.body, {new : true}).populate('garden')
        if(!updatedVegetable){
            return res.status(404).json({msg : 'No se encontro la hortaliza'})
        }
        return res.status(200).json(updatedVegetable)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// eliminar una hortaliza
exports.deleteVegtable = async(req, res) => {
    try {
        const deletedVegetable = await Vegetable.findByIdAndDelete(req.params.id)
        if(!deletedVegetable){
            return res.status(404).json({msg : 'No se encontro la hortaliza'})
        }
        return res.status(200).json({msg : 'La hortaliza fue eliminada'})
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
