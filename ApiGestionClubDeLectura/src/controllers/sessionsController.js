const Session = require('../models/Sesisons')

// Mostrar todas las sesiones
exports.getAllSessions = async(req, res) => {
    try {
        const sessions = await Session.find().populate('participants').populate('book')
        return res.status(200).json(sessions)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Mostrar sesion por id
exports.getSessionById = async(req, res) => {
    try {
        const session = await Session.findById(req.params.id).populate('participants').populate('book')
        if (!session){
            return res.status(404).json({msg : 'Recurso no encontrado'})
        }
        return res.status(200).json(session)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Crear sesion
exports.createSession = async(req, res) => {
    try {
        const newSession = new Session(req.body)
        await newSession.save()
        return res.status(201).json(newSession)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Editar Sesion 
exports.updatedSession = async(req, res) => {
    try {
        const updatedSession = await Session.findByIdAndUpdate(req.params.id, req.body, {new : true}).populate('participants').populate('book')
        if (!updatedSession){
            return res.status(404).json({msg : 'Recurso no encontrado'})
        }
        return res.status(200).json(updatedSession)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Eliminar Sesion
exports.deleteSession = async(req, res) => {
    try {
        const deletedSession = await Session.findByIdAndDelete(req.params.id)
        if (!deletedSession){
            return res.status(404).json({msg : 'Recurso no encontrado'})
        }
        return res.status(200).json({msg : 'Sesion eliminada'})
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}