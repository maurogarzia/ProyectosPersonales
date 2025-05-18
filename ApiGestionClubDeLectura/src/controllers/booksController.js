const Book = require('../models/Book')
const Reader = require('../models/Reader')

// Ver todos los libros
exports.getAllBooks = async(req, res) => {
    try {
        const books = await Book.find().populate('readers')
        return res.status(200).json(books)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Ver libro por Id
exports.getBookById = async(req, res) => {
    try {
        const book = await Book.findById(req.params.id).populate('readers')
        if (!book){
            return res.status(404).json({msg : 'No se encontro el recurso'})
        }
        return res.status(200).json(book)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Crear un libro
exports.createBook = async(req, res) => {
    try {
        const newBook = new Book(req.body)
        await newBook.save()
        return res.status(201).json(newBook)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Editar un libro
exports.updateBook = async(req, res) => {
    try {
        const updatedBook = await Book.findByIdAndUpdate(req.params.id, req.body, {new : true}).populate('readers')
        if (!updatedBook){
            return res.status(404).json({msg : 'Recurso no encontrado'})
        }
        return res.status(200).json(updatedBook)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Eliminar un libro
exports.deleteBook = async(req, res) => {
    try {
        const deletedBook = await Book.findByIdAndDelete(req.params.id)
        if (!deletedBook){
            return res.status(404).json({msg : 'Recurso no encontrado'})
        }
        return res.status(200).json({msg : 'Se elimino el libro'})
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}
// Asignar un lector a un libro
exports.AssignReaderToBook = async(req, res) => {
    try {
        const book = await Book.findById(req.params.id).populate('readers') // Busco el libro
        const reader = await Reader.findById(req.params.readerId).populate('favoriteGenre').populate('booksRead')
        if (!book || !reader){
            return res.status(404).json({msg : 'Recurso no encontrado'})
        }
        if (!book.readers.includes(reader._id)) {
            book.readers.push(reader._id)
        
            if (!Array.isArray(reader.booksRead)) {
                reader.booksRead = []
            }
        
            if (reader.booksRead === undefined) {
                reader.booksRead = []
            }
            reader.booksRead.push(book._id)
        
            await book.save()
            await reader.save()
        }
        return res.status(200).json(book)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}