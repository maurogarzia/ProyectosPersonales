const Author = require('../models/Author')

exports.getAllAuthors = async(req, res) => {
    try {
        const authors = await Author.find().populate('libros')
        return res.status(200).json(authors)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}

exports.getAuthorById = async(req, res) => {
    try {
        const author = await Author.findById(req.params.id).populate('libros')
        if (!author) {
            return res.status(404).json({message : 'No se encontro el recurso'})
        }
        return res.status(200).json(author)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}

exports.createAuthor = async(req, res) => {
    try {
        const newAuthor = new Author(req.body)
        await newAuthor.save()
        return res.status(201).json(newAuthor)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}

exports.updateAuthor = async(req, res) => {
    try {
        const updatedAuthor = await Author.findByIdAndUpdate(req.params.id, req.body, {new : true}.populate('libros'))
        if (!updatedAuthor) {
            return res.status(404).json({message : 'No se encontro el recurso'})
        }
        return res.status(200).json(updatedAuthor)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}

exports.deleteAuthor = async(req, res) => {
    try {
        const deletedAuthor = await Author.findByIdAndDelete(req.params.id)
        if (!deletedAuthor) {
            return res.status(404).json({message : 'No se encontro el recurso'})
        }
        return res.status(200).json({message : 'Se elimino el autor'})
    } catch (error) {
        res.status(500).json({error : error.message})
    }
}

exports.addBookInAuthor = async (req, res) => {
    try {
        const author = await Author.findById(req.params.id).populate('libros')
        const book = await Book.findById(req.params.bookId)
        if (!author || !book) {
            return res.status(404).json({message : 'No se encontro el recurso'})
        }
        if (author.libros.includes(book._id)){
            return res.status(200).message(author)
        }
        author.libros.push(book._id)
        await author.save()
        return res.status(200).json(author)
    } catch (error) {
        return res.status(500).json({error : error.message})
    }
}