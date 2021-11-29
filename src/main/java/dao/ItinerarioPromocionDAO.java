package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConnectionProvider;

public class ItinerarioPromocionDAO {
	public int insert(int id_promocion, int id_usuario) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO itinerario_promocion (id_promocion,id_usuario) VALUES (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_promocion);
		statement.setInt(2, id_usuario);

		int rows = statement.executeUpdate();
		return rows;
	}

}
