const dotenv = require('dotenv')
const express = require('express')
const mongoose = require('mongoose')
const authorRoutes = require('./src/routes/authorRoute')
const bookRoutes = require('./src/routes/bookRoute')

dotenv.config()
const app = express()
app.use(express.json())

mongoose.connect(process.env.MONGO_URL , {
    useNewUrlParser : true,
    useUnifiedTopology : true
})
.then(() =>{
    console.log('Conectado');
})
.catch((error) => {
    console.log('Ocurrio un error', error);
    
})

app.use('/authors', authorRoutes)
app.use('/books', bookRoutes)

const port = process.env.PORT || 3000
app.listen(port, () => {
    console.log(`Servidor Corriendo en el puerto ${port}`);
})
