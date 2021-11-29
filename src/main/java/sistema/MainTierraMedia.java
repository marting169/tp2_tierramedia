package sistema;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import dao.AtraccionDAO;
import dao.ItinerarioAtraccionDAO;
import dao.ItinerarioPromocionDAO;
import dao.PromocionDAO;
import dao.UsuarioDAO;
import jdbc.ConnectionProvider;
import jdbc.Iniciar;
import logica.Ofertador;
import logica.OrdenadorAtraccionXPrecio;
import logica.OrdenadorPromocionXPrecio;
import model.Atraccion;
import model.Promocion;
import model.Usuario;

public class MainTierraMedia {

	public static void main(String[] args) throws SQLException {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		ArrayList<Usuario> listaDeUsuarios = usuarioDao.findAll();
		//System.out.println(listaDeUsuarios);

		AtraccionDAO atraccionDao = new AtraccionDAO();
		ArrayList<Atraccion> listaDeAtracciones = atraccionDao.findAll();
		Collections.sort(listaDeAtracciones, Collections.reverseOrder(new OrdenadorAtraccionXPrecio()));
		//System.out.println(listaDeAtracciones);

		PromocionDAO promocionDao = new PromocionDAO();
		ArrayList<Promocion> listaDePromociones = promocionDao.findAll(listaDeAtracciones);
		Collections.sort(listaDePromociones, Collections.reverseOrder(new OrdenadorPromocionXPrecio()));
		//System.out.println(listaDePromociones);
		
		

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
