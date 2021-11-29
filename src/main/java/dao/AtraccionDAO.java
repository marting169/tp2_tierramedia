package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionProvider;
import model.Atraccion;

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
	
	
	public int update(Atraccion atraccion) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE atraccion SET costo=?, tiempo=?, cupo=? WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, atraccion.getCosto());
		statement.setDouble(2, atraccion.getTiempo());
		statement.setDouble(3, atraccion.getCupo());
		statement.setInt(4, atraccion.getId());
		
		int rows = statement.executeUpdate();
		return rows;
	}
	
	public int restaurar(int cupo,int id) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE atraccion SET cupo=? WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, cupo);
		statement.setDouble(2, id);
		int rows = statement.executeUpdate();
		return rows;
	}
}
