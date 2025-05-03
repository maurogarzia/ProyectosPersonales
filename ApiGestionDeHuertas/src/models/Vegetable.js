const mongoose = require('mongoose')

const vegetableSchema = mongoose.Schema({
    name : {
        type : String,
        required : true
    },
    type : {
        type : String,
        enum : ['hoja', 'raiz', 'fruto', 'flor'],
        required : true
    },
    sowinDate : { // Fecha de siembra
        type : Date,
        required : true
    },
    harvestDate : { // Fecha de cosecha
        type : Date,
    },
    garden : {
        type : mongoose.Types.ObjectId,
        ref : 'Garden'
    }
})

const vegetableModel = mongoose.model('Vegetable', vegetableSchema)

module.exports = vegetableModel