const mongoose = require('mongoose')

const schemaAuthor = mongoose.Schema({
    nombre : {
        type : String,
        required : true
    },
    bio : {
        type : String
    },
    fechaNacimiento : {
        type : Date,
        required : true
    },
    nacionalidad : {
        type : String,
        required : true
    },
    libros : [{
        type : mongoose.Schema.Types.ObjectId,
        ref : 'Book'
    }]
})

const Autor = mongoose.model('autors', schemaAuthor)

module.exports = Autor