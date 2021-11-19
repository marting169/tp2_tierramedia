package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logica.Atraccion;
import logica.Producto;
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
	
	/*public List<Promocion> findByNombre(String nom) throws SQLException {
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
	}*/

	/*public int delete(Promocion promocion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "DELETE FROM promocion WHERE nombre=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, promocion.getNombrePromocion());

		int rows = statement.executeUpdate();
		return rows;
	}*/

	/*public int insert(Promocion promocion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO promocion (nombre,dinero, tiempo) VALUES (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, promocion.getNombre());
		statement.setDouble(2, promocion.getPresupuesto());
		statement.setDouble(3, promocion.getTiempo_disponible());

		int rows = statement.executeUpdate();
		return rows;
	}*/

	public int update(Producto promocion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE promocion SET nombre=?,dinero=?, tiempo=? WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, promocion.getNombreAtraccion());
		statement.setDouble(2, promocion.getPresupuesto());
		statement.setDouble(3, promocion.getTiempo_disponible());
		statement.setInt(4, promocion.getId());

		int rows = statement.executeUpdate();
		return rows;
	}

	

}
