package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Usuario;

public class UsuarioDAO {

	public ArrayList<Usuario> findAll() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "select * FROM usuario";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		ArrayList<Usuario> todos = new ArrayList<Usuario>();
		while (result.next()) {
			todos.add(toUsuario(result));
		}
		return todos;
	}

	private Usuario toUsuario(ResultSet result) throws SQLException {
		return new Usuario(result.getInt("id"), result.getString("nombre"), result.getDouble("dinero"),
				result.getDouble("tiempo"));
	}

	public List<Usuario> findById(int id) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "select * FROM usuario WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet result = statement.executeQuery();
		List<Usuario> todos = new LinkedList<Usuario>();
		while (result.next()) {
			todos.add(toUsuario(result));
		}
		return todos;
	}

	public int delete(Usuario usuario) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "DELETE FROM usuario WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, usuario.getId());

		int rows = statement.executeUpdate();
		return rows;
	}

	public int insert(Usuario usuario) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO usuario (nombre,dinero, tiempo) VALUES (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, usuario.getNombre());
		statement.setDouble(2, usuario.getPresupuesto());
		statement.setDouble(3, usuario.getTiempo_disponible());

		int rows = statement.executeUpdate();
		return rows;
	}

	public int update(Usuario usuario) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE usuario SET nombre=?,dinero=?, tiempo=? WHERE id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, usuario.getNombre());
		statement.setDouble(2, usuario.getPresupuesto());
		statement.setDouble(3, usuario.getTiempo_disponible());
		statement.setInt(4, usuario.getId());

		int rows = statement.executeUpdate();
		return rows;
	}

	public int restaurar(Double dinero,Double tiempo,int id) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE usuario SET dinero=?, tiempo=? WHERE id=?;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, dinero);
		statement.setDouble(2, tiempo);
		statement.setInt(3,id);
		int rows = statement.executeUpdate();
		return rows;
	}

}
