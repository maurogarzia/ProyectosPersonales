const mongoose = require('mongoose')

const readerSchema = mongoose.Schema({
    name : {
        type : String,
        required : true
    },
    email : {
        type : String,
        required : true,
        unique : true
    },
    favoriteGenre : {
        type : String
    },
    booksRead : [{
        type : mongoose.Schema.Types.ObjectId,
        ref : 'Book'
    }]
        
    
})

const Reader = mongoose.model('Reader', readerSchema)

module.exports = Reader