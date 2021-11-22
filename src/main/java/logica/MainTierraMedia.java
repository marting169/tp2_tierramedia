package logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

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

		AtraccionDAO atraccionDao = new AtraccionDAO();
		ArrayList<Atraccion> listaDeAtracciones = atraccionDao.findAll();
		Collections.sort(listaDeAtracciones, Collections.reverseOrder(new OrdenadorAtraccionXPrecio()));
		System.out.println(listaDeAtracciones);

		PromocionDAO promocionDao = new PromocionDAO();
		ArrayList<Promocion> listaDePromociones = promocionDao.findAll(listaDeAtracciones);
		Collections.sort(listaDePromociones, Collections.reverseOrder(new OrdenadorPromocionXPrecio()));
		System.out.println(listaDePromociones);
		
		

		ItinerarioPromocionDAO itinerarioPromocionDao = new ItinerarioPromocionDAO();
		ItinerarioAtraccionDAO itinerarioAtraccionDao = new ItinerarioAtraccionDAO();
		Ofertador ofertas = new Ofertador();
		ofertas.generarOferta(listaDeAtracciones, listaDePromociones, listaDeUsuarios, itinerarioPromocionDao,
				itinerarioAtraccionDao);
		System.out.println(listaDeUsuarios);

		Iniciar iniciar=new Iniciar();
		System.out.println(iniciar.reiniciar());
		
		
		ConnectionProvider.close();
	}

}
