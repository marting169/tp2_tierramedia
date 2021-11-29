package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import dao.AtraccionDAO;
import dao.UsuarioDAO;

public class Iniciar {

	@SuppressWarnings("resource")
	public String reiniciar()
			throws SQLException {
		String input;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nDesea reiniciar datos para comenzar de nuevo? Ingrese S o N");
		input = sc.next();

		if (input.equals("S") || input.equals("s")) {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			usuarioDao.restaurar(10.0,8.0,1);
			usuarioDao.restaurar(100.0,5.0,2);
			usuarioDao.restaurar(36.0,8.0,3);
			usuarioDao.restaurar(120.0,6.0,4);
			usuarioDao.restaurar(50.0,10.0,5);
			usuarioDao.restaurar(15.0,7.0,6);
			usuarioDao.restaurar(40.0,10.0,7);
			AtraccionDAO atraccionDao = new AtraccionDAO();
			atraccionDao.restaurar(6,9);
			atraccionDao.restaurar(25,10);
			atraccionDao.restaurar(150,11);
			atraccionDao.restaurar(4,12);
			atraccionDao.restaurar(15,13);
			atraccionDao.restaurar(30,14);
			atraccionDao.restaurar(32,15);
			atraccionDao.restaurar(12,16);

			return "Valores reiniciados";
		} else {
			return "Valores No reiniciados";

		}
	}
}
