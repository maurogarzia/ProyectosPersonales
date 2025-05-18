const Reader = require('../models/Reader')

// Ver todos lso lectores
exports.getAllReaders = async(req, res) => {
    try {
        const readers = await Reader.find().populate('booksRead')
        return res.status(200).json(readers)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Ver lector por id
exports.getReaderById = async(req, res) => {
    try {
        const reader = await Reader.findById(req.params.id).populate('booksRead')
        if (!reader){
            return res.status(404).json({msg : 'Recurso no encontrado'})
        }
        return res.status(200).json(reader)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Crear un lector
exports.createReader = async(req, res) => {
    try {
        const newReader = new Reader(req.body)
        await newReader.save()
        return res.status(201).json(newReader)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Editar un lector
exports.updateReader = async(req, res) => {
    try {
        const updatedReader = await Reader.findByIdAndUpdate(req.params.id, req.body, {new : true}).populate('booksRead')
        if (!updatedReader){
            return res.status(404).json({msg : 'Recurso no encontrado'})
        }
        return res.status(200).json(updatedReader)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Eliminar un lector
exports.deleteReader = async(req, res) => {
    try {
        const deletedReader = await Reader.findByIdAndDelete(req.params.id)
        if(!deletedReader){
            return res.status(400).json({msg : 'Recurso no encontrado'})
        }
        return res.json(200).json({msg : 'Se elimino el lector'})
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
