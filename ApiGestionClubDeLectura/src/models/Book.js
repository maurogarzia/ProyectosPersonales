const mongoose = require('mongoose')

const bookSchema = mongoose.Schema({
    title : {
        type : String,
        required : true
    },
    author : {
        type : String,
        required : true
    },
    publishedYear : {
        type : Number
    },
    genre : {
        type : String
    },
    readers : [{
        type : mongoose.Schema.Types.ObjectId,
        ref : 'Reader'
    }]
    
})

const Book = mongoose.model('Book', bookSchema)

module.exports = Book