package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConnectionProvider;

public class ItinerarioAtraccionDAO {
	public int insert(int id_atraccion, int id_usuario) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO itinerario_atraccion (id_atraccion,id_usuario) VALUES (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_atraccion);
		statement.setInt(2, id_usuario);

		int rows = statement.executeUpdate();
		return rows;
	}


}
