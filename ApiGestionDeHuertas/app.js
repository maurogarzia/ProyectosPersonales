const express = require('express')
const mongoose = require('mongoose')
const dotenv = require('dotenv')
const vegetableRoute = require('./src/routes/vegetableRoute')
const gardenerRoute = require('./src/routes/gardenerRoute')
const gardenRoute = require('./src/routes/gardenRoute')

// Configuracion de .env
dotenv.config()

const app = express()
app.use(express.json())

app.use('/gardens', gardenRoute)
app.use('/gardeners', gardenerRoute)
app.use('/vegetables', vegetableRoute)


mongoose.connect(process.env.MONGO_URL, {
    useNewUrlParser : true,
    useUnifiedTopology : true
})
.then(()=>{
    console.log('Conectado a mongo')   
}).catch((error) => {
    console.log('Ocurrio un error', error)
})

//Conexion a mongo

const port = 3000 || process.env.PORT

app.listen(port, () => {
    console.log(`Servidor corriendo en el puerto ${port}`)
})