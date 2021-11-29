package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Promocion;
import model.PromocionAXB;
import model.PromocionAbsoluta;
import model.PromocionPorcentual;

public class PromocionDAO {
	public ArrayList<Promocion> findAll(ArrayList<Atraccion> atraccionesDisponibles) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "select * FROM promocion";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		ArrayList<Promocion> todos = new ArrayList<Promocion>();
		while (result.next()) {
			todos.add(toPromocion(result, atraccionesDisponibles));
		}
		return todos;
	}

	private Promocion toPromocion(ResultSet result, ArrayList<Atraccion> atraccionesDisponibles) throws SQLException {
		double costo = 0;
		double tiempo = 0;
		ArrayList<Atraccion> atraccionesEnPromocion = new ArrayList<Atraccion>();
		List<Integer> ides = findIdAtraccionByIdPromocion(result.getInt("id"));
		for (int i = 0; i < ides.size(); i++) {
			for (Atraccion atraccion : atraccionesDisponibles) {
				if(atraccion.getId()==ides.get(i)) {
					atraccionesEnPromocion.add(atraccion);
					costo += atraccion.getCosto();
					tiempo += atraccion.getTiempo();
					break;
				}
			}
		}
		if (result.getString("tipo").equals("ABSOLUTO")) {
			return new PromocionAbsoluta(result.getInt("id") ,result.getString("nombre"), costo, tiempo, atraccionesEnPromocion,
					result.getDouble("descuento"));
		} else if (result.getString("tipo").equals("PORCENTUAL")) {
			return new PromocionPorcentual(result.getInt("id") ,result.getString("nombre"), costo, tiempo, atraccionesEnPromocion,
					result.getDouble("descuento"));
		} else {
			return new PromocionAXB(result.getInt("id") ,result.getString("nombre"), costo, tiempo, atraccionesEnPromocion);
		}
	}

	public List<Integer> findIdAtraccionByIdPromocion(int i) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT id_atraccion FROM promocion_atraccion WHERE ?=promocion_atraccion.id_promocion ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, i);
		ResultSet result = statement.executeQuery();
		List<Integer> atracciones = new ArrayList<Integer>();
		while (result.next()) {
			atracciones.add(result.getInt("id_atraccion"));
		}
		return atracciones;
	}
	


}
