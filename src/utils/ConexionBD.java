package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public static Connection conectar() {

		// Definimos la conexion
		Connection con = null;

		// Parametros de conexion
		String url = "jdbc:mysql://localhost/bar10montaditos";
		String user = "root";
		String passwd = "toor";

		try {
			// Comprobamos que el proyecto tiene el conector
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Conectamos con la base de datos
			con = DriverManager.getConnection(url, user, passwd);

		} catch (ClassNotFoundException nfe) {
			System.out.println("No se encontro la clase");
			nfe.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error al conectar con la BD");
			e.printStackTrace();

		}

		// Devolvemos la conexion
		return con;

	}

}
