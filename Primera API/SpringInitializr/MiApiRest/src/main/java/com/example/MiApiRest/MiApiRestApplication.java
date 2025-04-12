package com.example.MiApiRest;

import com.example.MiApiRest.entities.*;
import com.example.MiApiRest.entities.enums.*;
import com.example.MiApiRest.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
class MiApiRestApplication {

	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;
	@Autowired
	private CategoriaRespository categoriaRespository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	@Autowired
	private DomicilioRepository domicilioRepository;
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private ImagenArticuloRepository imagenArticuloRepository;
	@Autowired
	private ImagenClienteRepository imagenClienteRepository;
	@Autowired
	private ImagenEmpleadoRepository imagenEmpleadoRepository;
	@Autowired
	private ImagenPromocionRepository imagenPromocionRepository;
	@Autowired
	private LocalidadRepository localidadRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PromocionRepository promocionRepository;
	@Autowired
	private PromocionDetalleRepository promocionDetalleRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private SucursalRepository sucursalRepository;
	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	private UsuarioClienteRepository usuarioClienteRepository;
	@Autowired
	private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MiApiRestApplication.class, args);
		System.out.println("Servidor iniciado.");

	}


	@Bean
	@Transactional
	CommandLineRunner init(ArticuloInsumoRepository articuloInsumoRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository,
						   ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository,
						   CategoriaRespository categoriaRespository, ClienteRepository clienteRepository, DetallePedidoRepository detallePedidoRepository,
						   DomicilioRepository domicilioRepository,EmpleadoRepository empleadoRepository, EmpresaRepository empresaRepository,
						   FacturaRepository facturaRepository, ImagenArticuloRepository imagenArticuloRepository, ImagenClienteRepository imagenClienteRepository,
						   ImagenEmpleadoRepository imagenEmpleadoRepository, ImagenPromocionRepository imagenPromocionRepository,
						   LocalidadRepository localidadRepository, PaisRepository paisRepository, PedidoRepository pedidoRepository,
						   PromocionRepository promocionRepository, PromocionDetalleRepository promocionDetalleRepository, ProvinciaRepository provinciaRepository,
						   SucursalRepository sucursalRepository, UnidadMedidaRepository unidadMedidaRepository, UsuarioClienteRepository usuarioClienteRepository,
						   UsuarioEmpleadoRepository usuarioEmpleadoRepository){
		return args ->{
			//PAIS
			Pais pais = Pais.builder().nombre("Argentina").build();
			paisRepository.save(pais);

			//PROVINCIA
			Provincia provincia = Provincia.builder().nombre("Mendoza").pais(pais).build();
			provinciaRepository.save(provincia);

			//LOCALIDAD
			Localidad localidad1 = Localidad.builder().nombre("Maipu").provincia(provincia).build();
			localidadRepository.save(localidad1);

			Localidad localidad2 = Localidad.builder().nombre("Godoy Cruz").provincia(provincia).build();
			localidadRepository.save(localidad2);

			//DOMICILIO
			Domicilio domicilio1 = Domicilio.builder().localidad(localidad1).calle("Ozamis Sur").cp(5515).numero(290).build();
			Domicilio domicilio2 = Domicilio.builder().localidad(localidad2).calle("San Martin Sur").cp(5501).numero(308).build();
			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);

			//EMPRESA
			Empresa empresa = Empresa.builder().nombre("GUSTEAU'S").razonSocial("Restaurante").
					cuil(27-12345678-9).build();
			empresaRepository.save(empresa);


			//UNIDAD MEDIDA

			UnidadMedida uM1 = UnidadMedida.builder().denominacion("Litros").build();
			UnidadMedida uM2 = UnidadMedida.builder().denominacion("Centimetros").build();
			UnidadMedida uM3 = UnidadMedida.builder().denominacion("Kilos").build();
			unidadMedidaRepository.save(uM1);
			unidadMedidaRepository.save(uM2);
			unidadMedidaRepository.save(uM3);


			//CATEGORIA


			Categoria categoria2 = Categoria.builder()
					.denominacion("comidas")
					.build();

			Categoria categoria1 = Categoria.builder()
					.denominacion("Tuberculos")
					.categoriaPadre(categoria2)
					.build();

			categoria2.getSubcategorias().add(categoria1);
			categoria1.setCategoriaPadre(categoria1);
			categoriaRespository.save(categoria2);
			categoriaRespository.save(categoria1);


			//PROMOCION

			Promocion promocion1 = Promocion.builder()
					.denominacion("Ensalada loca")
					.descripcionDescuento("Ensalada Rusa con vino tinto Toro")
					.fechaDesde(LocalDate.of(2024,6,15))
					.fechaHasta(LocalDate.of(2024, 6, 30))
					.horaDesde(LocalTime.of(8,0))
					.horaHasta(LocalTime.of(11,0))
					.precioPromocional(10000.0)
					.tipoPromocion(TipoPromocion.promocion).build();
			promocionRepository.save(promocion1);

			Promocion promocion2 = Promocion.builder()
					.denominacion("Reto Picante")
					.descripcionDescuento("Nachos con salsa picante y lomo salteado con aji")
					.fechaDesde(LocalDate.of(2024, 6, 24))
					.fechaHasta(LocalDate.of(2024,7,15))
					.horaDesde(LocalTime.of(8,0))
					.horaHasta(LocalTime.of(11,0))
					.precioPromocional(15000.0)
					.tipoPromocion(TipoPromocion.promocion).build();
			promocionRepository.save(promocion2);


			//IMAGEN ARTICULO
			ImagenArticulo imagenArticulo1 = ImagenArticulo.builder().denominacion("Ensalada Rusa").build();
			ImagenArticulo imagenArticulo2 = ImagenArticulo.builder().denominacion("Vino Tinto Toro").build();
			ImagenArticulo imagenArticulo3 = ImagenArticulo.builder().denominacion("Papas sin pelar").build();
			imagenArticuloRepository.save(imagenArticulo1);
			imagenArticuloRepository.save(imagenArticulo2);
			imagenArticuloRepository.save(imagenArticulo3);

			//ARTICULO INSUMO

			ArticuloInsumo articuloInsumo = ArticuloInsumo.builder().
					stockActual(500)
					.precioCompra(15000.0)
					.precioVenta(0.0)
					.paraElaborar(true)
					.denominacion("Papa")
					.stockMaximo(1000)
					.unidadMedida(uM3)
					.build();
			articuloInsumo.getImagenArticulo().add(imagenArticulo3);
			articuloInsumo.setCategoria(categoria1);
			articuloInsumoRepository.save(articuloInsumo);

			//ARTICULO MANUFACTURADO
			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder()
					.tiempoEstimadoMinutos(120)
					.preparacion("Hervir carne nerviosa a 90 grados, ponerle vino tinto y mucho ajo")
					.precioVenta(15000.0)
					.unidadMedida(uM3)
					.denominacion("carne a la olla")
					.descripcion("Carne a la olla con papa y ajo")
					.build();
			articuloManufacturado.setCategoria(categoria2);
			articuloManufacturadoRepository.save(articuloManufacturado);

			//ARTICULO MANUFACTURADO DETALLE
			ArticuloManufacturadoDetalle articuloManufacturadoDetalle = ArticuloManufacturadoDetalle.builder()
					.cantidad(7)
					.articuloManufacturado(articuloManufacturado)
					.articuloInsumo(articuloInsumo)
					.build();
			articuloManufacturadoDetalleRepository.save(articuloManufacturadoDetalle);

			//IMAGEN PROMOCION
			ImagenPromocion imagenPromocion1 = ImagenPromocion.builder().denominacion("imagen de promocion").build();
			imagenPromocionRepository.save(imagenPromocion1);

			//PROMOCION DETALLE
			PromocionDetalle promocionDetalle = PromocionDetalle.builder().promocion(promocion1).
					cantidad(25)
					.articulo(articuloManufacturado)
					.build();
			promocionDetalleRepository.save(promocionDetalle);


			//SUCURSAL
			Sucursal sucursal1 = Sucursal.builder()
					.nombre("GUSTEAUS'S Maipu").
					domicilio(domicilio1)
					.casaMatriz(false)
					.empresa(empresa)
					.horarioApertura(LocalTime.of(8,0))
					.horarioCierre(LocalTime.of(11,0))
					.build();
			sucursal1.getCategorias().add(categoria2);
			sucursal1.getPromociones().add(promocion1);
			sucursal1.getPromociones().add(promocion2);
			sucursalRepository.save(sucursal1);


			//IMAGEN EMPLEADO
			ImagenEmpleado imagenEmpleado = ImagenEmpleado.builder()
					.denominacion("Imagen del empleado Nazareno Fioretti")
					.build();
			imagenEmpleadoRepository.save(imagenEmpleado);

		//No escuche bien

			//IMAGEN CLIENTE
			ImagenCliente imagenCliente = ImagenCliente.builder()
					.denominacion("Imagen del cliente")
					.build();
			imagenClienteRepository.save(imagenCliente);



			//EMPLEADO

			Empleado empleado = Empleado.builder()
					.sucursal(sucursal1)
					.imagenEmpleado(imagenEmpleado)
					.build();
			empleado.setNombre("Nazareno");
			empleado.setApellido("Fioretti");
			empleado.setTelefono("2613659870");
			empleado.setEmail("naza@gmail.com");
			empleado.setFechaNacimiento(LocalDate.of(2005, 12, 3));
			empleado.setTipoEmpleado(Rol.cajero);
			empleadoRepository.save(empleado);

			//USUARIO EMPLEADO
			UsuarioEmpleado usuarioEmpleado = UsuarioEmpleado.builder()
					.auth0Id("Las")
					.username("Naza.com")
					.empleado(empleado)
					.build();
			usuarioEmpleadoRepository.save(usuarioEmpleado);



			//CLIENTE
			Cliente cliente = Cliente.builder()
					.imagenCliente(imagenCliente)
					.build();
			cliente.setNombre("Rodrigo");
			cliente.setApellido("Zapata");
			cliente.setTelefono("2616926733");
			cliente.setEmail("RodriChiD@gmail.com");
			cliente.setFechaNacimiento(LocalDate.of(2004, 6, 25 ));
			cliente.setRolCliente(Rol.cliente);
			cliente.setDomicilio(domicilio1);
			clienteRepository.save(cliente);


//USUARIO CLIENTE
			UsuarioCliente usuarioCliente = UsuarioCliente.builder()
					.auth0Id("Las")
					.username("GambitoMendocino")
					.cliente(cliente)
					.build();
			usuarioClienteRepository.save(usuarioCliente);

			//FACTURA
			Factura factura = Factura.builder()
					.fachaFacturacion(LocalDate.of(2024, 3, 28))
					.formaPago(FormaPago.efectivo)
					.mpMerchantOrderId(1000002354)
					.mpPaymentId(123465)
					.mpPaymentType("En efectivo")
					.mpPreferenceId("No sé")
					.totalVenta(50000.0)
					.build();
			facturaRepository.save(factura);

			//PEDIDO
			Pedido pedido = Pedido.builder()
					.fechaPedido(LocalDate.of(2024, 4, 6))
					.estado(Estado.pendiente)
					.horaEstimadaFinalizacion(LocalTime.of(15,0))
					.total(11000.0)
					.totalCosto(12000.0)
					.tipoEnvio(TipoEnvio.delivery)
					.formaPago(FormaPago.efectivo)
					.domicilio(domicilio2)
					.sucursal(sucursal1)
					.empleado(empleado)
					.cliente(cliente)
					.factura(factura)
					.build();
			pedidoRepository.save(pedido);


			//Igual con cliente pasa lo mismo, ahora ejecu todo todo?
			//DETALLE PEDIDO

			DetallePedido detallePedido = DetallePedido.builder()
					.pedido(pedido)
					.cantidad(42)
					.subTotal(50000.0)
					.articulo(articuloInsumo)
					.build();
			detallePedidoRepository.save(detallePedido);


		};
	}


}
