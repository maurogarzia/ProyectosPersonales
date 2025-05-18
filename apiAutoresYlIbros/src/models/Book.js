const mongoose = require('mongoose')

const schemaBook = mongoose.Schema({
    titulo : {
        type : String,
        required : true
    },
    resumen :{
        type : String,
    },
    genero : {
        type : ['novela' | 'poesia' | 'ensayo'],
        required : true
    },
    publicacion : {
        type : Date,
        required : true
    },
    disponible : {
        type : Boolean,
        required : true
    }
})

const Book = mongoose.model('Book', schemaBook)

module.exports = Book