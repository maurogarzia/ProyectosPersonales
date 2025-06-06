const fs = require('fs');
const pdf = require('pdf-parse');
const {
  Document,
  Packer,
  Paragraph,
  TextRun,
  Table,
  TableRow,
  TableCell,
  WidthType
} = require('docx');

const buffer = fs.readFileSync('./listaprecios/martin tools 24 de abril de 2024 algunas bajas de precio, otro.pdf');

pdf(buffer).then(async data => {
  const lineas = data.text.split('\n');
  const tablaFilas = [];

  for (const linea of lineas) {
    const partes = linea.trim().split(/\s+/);

    if (partes.length < 4 || linea.toUpperCase().startsWith("LISTA")) continue;

    const posiblePrecio = partes[partes.length - 1];

    if (/^\d+(,\d{1,2})?$/.test(posiblePrecio)) {
      const numero = parseFloat(posiblePrecio.replace(',', '.'));
      const nuevoPrecio = (numero * 1.3).toFixed(2).replace('.', ',');

      const codigo = partes[0];
      const precioFinal = `$${nuevoPrecio}`;

      // Marca: penúltima palabra (última de la descripción)
      const marca = partes[partes.length - 2];

      // Descripción: todo menos código, marca y precio
      const descripcion = partes.slice(1, -2).join(' ');

      tablaFilas.push(
        new TableRow({
          children: [
            new TableCell({
              width: { size: 15, type: WidthType.PERCENTAGE },
              children: [new Paragraph(codigo)]
            }),
            new TableCell({
              width: { size: 50, type: WidthType.PERCENTAGE },
              children: [new Paragraph(descripcion)]
            }),
            new TableCell({
              width: { size: 20, type: WidthType.PERCENTAGE },
              children: [new Paragraph(marca)]
            }),
            new TableCell({
              width: { size: 15, type: WidthType.PERCENTAGE },
              children: [new Paragraph(precioFinal)]
            }),
          ],
        })
      );
    }
  }

  const doc = new Document({
    sections: [{
      children: [
        new Paragraph({
          children: [new TextRun({ text: 'Lista de precios actualizada (30%)', bold: true })],
        }),
        new Table({
          rows: [
            new TableRow({
              children: [
                new TableCell({ children: [new Paragraph('Código')] }),
                new TableCell({ children: [new Paragraph('Descripción')] }),
                new TableCell({ children: [new Paragraph('Marca')] }),
                new TableCell({ children: [new Paragraph('Precio')] }),
              ],
            }),
            ...tablaFilas
          ],
        }),
      ],
    }],
  });

  const bufferDoc = await Packer.toBuffer(doc);
  fs.writeFileSync('./listaprecios/lista_actualizada.docx', bufferDoc);
  console.log('✔ Word generado con precios actualizados.');
});
