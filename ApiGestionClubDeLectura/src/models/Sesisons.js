const mongoose = require('mongoose')

const sessionsSchema = mongoose.Schema({
    date : {
        type : Date,
        required : true
    },
    book : {
        type : mongoose.Schema.Types.ObjectId,
        ref : 'Book',
        required : true
    },
    participants : [{
        type : mongoose.Schema.Types.ObjectId,
        ref : 'Reader'
    }],
    notes : {
        type : String
    }
})

const Session = mongoose.model('Session', sessionsSchema)

module.exports = Session