const mongoose = require('mongoose')

// Esquema
const gardenSchema = mongoose.Schema({
    name : {
        type : String,
        required : true
    },
    location : {
        type : String,
        required : true
    },
    initialDate : {
        type : Date,
        required : true
    },
    vegetables : [{
        type : mongoose.Types.ObjectId,
        ref : 'Vegetable'
    }],
    gardeners : [{
        type : mongoose.Types.ObjectId,
        ref : 'Gardener'
    }]
})

// Modelo
const gardenModel = mongoose.model('Garden', gardenSchema)

module.exports = gardenModel