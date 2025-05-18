const express = require('express')
const dotenv = require('dotenv')
const mongoose = require('mongoose')

// Configura variables de entorno
dotenv.config()
const app = express()

// Middelware
app.use(express.json())

// Conexion a mongo
mongoose.connect((process.env.MONGO_URL), { 
    useNewUrlParser : true,
    useUnifiedTopology : true
})
.then(() => {
    console.log('Conectado');
})
.catch((error) => {
    console.log('Ocurrio un error al conectar', error);
})

// Importo rutas
const bookRoutes = require('./src/routes/booksRoutes')
const readerRoutes = require('./src/routes/readerRoutes')
const sessionsRoutes = require('./src/routes/sessionsRoutes')

app.use('/books', bookRoutes)
app.use('/readers', readerRoutes)
app.use('/sessions', sessionsRoutes)

const port = process.env.PORT || 3000
app.listen(port, () => {
    console.log(`Servidor corriendo en el puerto ${port}`);
})