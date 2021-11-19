package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logica.Atraccion;

public class AtraccionDAO {
	public ArrayList<Atraccion> findAll() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "select * FROM atraccion";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		ArrayList<Atraccion> todos=new ArrayList<Atraccion>();
		while (result.next()) {
			todos.add(toAtraccion(result));
		}
		return todos;
	}

	private Atraccion toAtraccion(ResultSet result) throws SQLException {
		return new Atraccion(result.getInt("id"), result.getString("nombre"),result.getDouble("costo"),result.getDouble("tiempo"),result.getInt("cupo"));
	}
	
	public ArrayList<Atraccion> findByIdPromocion(String id_prom) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT DISTINCT atraccion.* FROM promocion_atraccion JOIN atraccion ON promocion_atraccion.id_atraccion=atraccion.id WHERE ?=promocion_atraccion.id_promocion ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id_prom);
		
		ResultSet result = statement.executeQuery();
		ArrayList<Atraccion> todos=new ArrayList<Atraccion>();
		while (result.next()) {
			todos.add(toAtraccion(result));
		}
		return todos;
	}
	
	public int delete(Atraccion atraccion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "DELETE FROM atraccion WHERE nombre=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, atraccion.getNombreAtraccion());
		
		int rows = statement.executeUpdate();
		return rows;
	}
	
	public int insert(Atraccion atraccion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO atraccion (nombre,costo, tiempo, cupo) VALUES (?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, atraccion.getNombreAtraccion());
		statement.setDouble(2, atraccion.getCosto());
		statement.setDouble(3, atraccion.getTiempo());
		statement.setDouble(4, atraccion.getCupo());
		
		int rows = statement.executeUpdate();
		return rows;
	}
	
	public int update(Atraccion atraccion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE atraccion SET nombre=?,costo=?, tiempo=?, cupo=? WHERE nombre=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, atraccion.getNombreAtraccion());
		statement.setDouble(2, atraccion.getCosto());
		statement.setDouble(3, atraccion.getTiempo());
		statement.setDouble(4, atraccion.getCupo());
		statement.setString(5, atraccion.getNombreAtraccion());
		
		int rows = statement.executeUpdate();
		return rows;
	}
}