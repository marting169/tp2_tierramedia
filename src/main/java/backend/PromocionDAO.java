package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import logica.Atraccion;
import logica.Promocion;
import logica.PromocionAbsoluta;
import logica.PromocionPorcentual;
import logica.PromocionAXB;

public class PromocionDAO {
	public ArrayList<Promocion> findAll(ArrayList<Atraccion> atraccionesDisponibles) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "select * FROM promocion";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		ArrayList<Promocion> todos = new ArrayList<Promocion>();
		while (result.next()) {
			todos.add(toPromocion(result,atraccionesDisponibles));
		}
		return todos;
	}

	private Promocion toPromocion(ResultSet result,ArrayList<Atraccion> atraccionesDisponibles) throws SQLException {
		double costo = 0;
		double tiempo = 0;
		Integer [] ides  = findIdAtraccionByIdPromocion(result.getInt("id"));
		for (Atraccion atraccion : atraccionesDisponibles) {
			costo += atraccion.getCosto();
			tiempo += atraccion.getTiempo();
		}
		if (result.getString("tipo") == "ABSOLUTO") {
			return new PromocionAbsoluta(result.getString("nombre"), costo, tiempo, atraccionesEnPromocion,
					result.getDouble("descuento"));
		} else if (result.getString("tipo") == "PORCENTUAL") {
			return new PromocionPorcentual(result.getString("nombre"), costo, tiempo, atraccionesEnPromocion,
					result.getDouble("descuento"));
		} else {
			return new PromocionAXB(result.getString("nombre"), costo, tiempo,
					atraccionesEnPromocion);
		}
	}

	public List<Promocion> findByNombre(String nom) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "select * FROM promocion WHERE nombre=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nom);

		ResultSet result = statement.executeQuery();
		List<Promocion> todos = new LinkedList<Promocion>();
		while (result.next()) {
			todos.add(toPromocion(result));
		}
		return todos;
	}

	public int delete(Promocion promocion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "DELETE FROM promocion WHERE nombre=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, promocion.getNombrePromocion());

		int rows = statement.executeUpdate();
		return rows;
	}

	public int insert(Promocion promocion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO promocion (nombre,dinero, tiempo) VALUES (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setDouble(2, promocion.getPresupuesto());
		statement.setDouble(3, promocion.getTiempo_disponible());

		int rows = statement.executeUpdate();
		return rows;
	}

	public int update(Promocion promocion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE promocion SET nombre=?,dinero=?, tiempo=? WHERE nombre=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setDouble(2, promocion.getPresupuesto());
		statement.setDouble(3, promocion.getTiempo_disponible());
		statement.setString(4, promocion.getNombre());

		int rows = statement.executeUpdate();
		return rows;
	}

	public ArrayList<Atraccion> findIdAtraccionByIdPromocion(int i) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT DISTINCT atraccion.* FROM promocion_atraccion JOIN atraccion ON promocion_atraccion.id_atraccion=atraccion.id WHERE ?=promocion_atraccion.id_promocion ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, i);

		ResultSet result = statement.executeQuery();
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		while (result.next()) {
			atracciones.add(toAtraccion(result));
		}
		return atracciones;
	}

	private Atraccion toAtraccion(ResultSet result) throws SQLException {
		return new Atraccion(result.getInt("id"), result.getString("nombre"), result.getDouble("costo"),
				result.getDouble("tiempo"), result.getInt("cupo"));
	}

}
