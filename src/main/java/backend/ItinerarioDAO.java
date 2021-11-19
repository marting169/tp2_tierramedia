package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ItinerarioDAO {
		/*public List<Itinerario> findAll() throws SQLException {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "select * FROM atraccion";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			List<Itinerario> todos=new LinkedList<Itinerario>();
			while (result.next()) {
				todos.add(toAtraccion(result));
			}
			return todos;
		}*/

		/*private Itinerario toAtraccion(ResultSet result) throws SQLException {
			return new Itinerario(result.getString("nombre"),result.getDouble("costo"),result.getDouble("tiempo"),result.getInt("cupo"));
		}*/
		
		/*public List<Itinerario> findByNombre(String nom) throws SQLException {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "select * FROM atraccion WHERE nombre=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nom);
			
			ResultSet result = statement.executeQuery();
			List<Itinerario> todos=new LinkedList<Itinerario>();
			while (result.next()) {
				todos.add(toAtraccion(result));
			}
			return todos;
		}*/
		
		/*public int delete(Itinerario atraccion) throws SQLException {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "DELETE FROM atraccion WHERE nombre=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			
			int rows = statement.executeUpdate();
			return rows;
		}*/
		
		/*public int insert(Itinerario atraccion) throws SQLException {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "INSERT INTO atraccion (nombre,dinero, tiempo) VALUES (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setDouble(2, atraccion.getPresupuesto());
			statement.setDouble(3, atraccion.getTiempo_disponible());
			
			int rows = statement.executeUpdate();
			return rows;
		}*/
		
		/*public int update(Itinerario atraccion) throws SQLException {
			Connection connection = ConnectionProvider.getConnection();
			String sql = "UPDATE usuario SET nombre=?,dinero=?, tiempo=? WHERE nombre=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, atraccion.getNombre());
			statement.setDouble(2, atraccion.getPresupuesto());
			statement.setDouble(3, atraccion.getTiempo_disponible());
			statement.setString(4, atraccion.getNombre());
			
			int rows = statement.executeUpdate();
			return rows;
		}
		*/

}
