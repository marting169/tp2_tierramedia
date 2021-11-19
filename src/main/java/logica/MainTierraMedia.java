package logica;

import java.sql.SQLException;
import java.util.ArrayList;

import backend.AtraccionDAO;
import backend.ConnectionProvider;
import backend.ItinerarioAtraccionDAO;
import backend.ItinerarioPromocionDAO;
import backend.PromocionDAO;
import backend.UsuarioDAO;

public class MainTierraMedia {

	public static void main(String[] args) throws SQLException {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		ArrayList<Usuario> listaDeUsuarios = usuarioDao.findAll();
		System.out.println(listaDeUsuarios);

		/*ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		LeerUsuarios listaDeUsuarios=new LeerUsuarios("archivos/usuarios.csv",usuarios);
		listaDeUsuarios.leerArchivoUsuarios();
		listaDeUsuarios.listarUsuarios();*/
		
		AtraccionDAO atraccionDao = new AtraccionDAO();
		ArrayList<Atraccion> listaDeAtracciones = atraccionDao.findAll();
		System.out.println(listaDeAtracciones);
		
		/*ArrayList<Atraccion> atraccionesDisponibles=new ArrayList<Atraccion>();
		LeerAtracciones listaDeAtracciones=new LeerAtracciones("archivos/atracciones.csv",atraccionesDisponibles);
		listaDeAtracciones.leerArchivoAtracciones();
		//listaDeAtracciones.listarAtracciones();*/
		
		PromocionDAO promocionDao = new PromocionDAO();
		ArrayList<Promocion> listaDePromociones = promocionDao.findAll(listaDeAtracciones);
		System.out.println(listaDePromociones);
		
		/*ArrayList<Promocion>promocionesDisponibles=new ArrayList<Promocion>();
		LeerPromociones listaDePromociones=new LeerPromociones("archivos/promociones.csv",promocionesDisponibles);
		listaDePromociones.leerArchivoPromociones(atraccionesDisponibles);
		//listaDePromociones.listarPromociones();*/
		
		ItinerarioPromocionDAO itinerarioPromocionDao=new ItinerarioPromocionDAO();
		ItinerarioAtraccionDAO itinerarioAtraccionDao=new ItinerarioAtraccionDAO();
		Ofertador ofertas=new Ofertador();
		ofertas.generarOferta(listaDeAtracciones, listaDePromociones, listaDeUsuarios,itinerarioPromocionDao,itinerarioAtraccionDao);
		System.out.println(listaDeUsuarios);
		
		//listaDeAtracciones.listarAtracciones();
		//listaDePromociones.listarPromociones();
		
		/*ArchivoSalida salida = new ArchivoSalida();		
		salida.guardarEnArchivo(usuarios, "archivos/");
		*/
		ConnectionProvider.close();
	}

}
