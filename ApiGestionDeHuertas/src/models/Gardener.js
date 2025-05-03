const mongoose = require('mongoose')

const gardenerSchema = mongoose.Schema({
    name : {
        type : String,
        required : true
    },
    phone : {
        type : String
    },
    email : {
        type : String,
        required : true,
        unique : true
    },
    vegetables : {
        type : mongoose.Types.ObjectId,
        ref : 'Vegetables'
    }
})

const gardenerModel = mongoose.model('Gardener', gardenerSchema)

module.exports = gardenerModel