package backend;

import java.sql.SQLException;
import java.util.List;

import logica.Usuario;

public class App {

	public static void main(String[] args) throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> xx = dao.findAll();
		System.out.println(xx);

		// INSERT
		/*Usuario martin = new Usuario("martin", 99, 19);
		dao.insert(martin);

		// BUSCAR
		Usuario martins = dao.findByNombre("martin").get(0);
		System.out.println(martins);
		martins.setPresupuesto(120);
		// ACTUALIZAR
		dao.update(martins);*/

		// BUSCAR
		List<Usuario> martines = dao.findByNombre("martin");
		System.out.println(martines);

		// BORRAR
		dao.delete(martines.get(0));

		List<Usuario> xZ = dao.findAll();
		System.out.println(xZ);

		ConnectionProvider.close();
	}
}
