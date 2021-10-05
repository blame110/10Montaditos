package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ConexionBD;

public class MontaditoDAO {

	public ArrayList<IngredienteVO> cargarIngredientes(int idMontadito) {

		// Definimos el arrayList que guardara todos los ingredientes de la BD
		ArrayList<IngredienteVO> ingredientes = new ArrayList<IngredienteVO>();

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {

			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el ingrediente
			res = stmt.executeQuery(
					"SELECT ingredientes.idIngrediente,nombre,tipo  FROM ingredientes,composicion WHERE Composicion.idIngrediente=Ingredientes.idIngrediente and Composicion.idMontadito="
							+ idMontadito);

			// Cargamos todos los registros de la tabla ingredientes
			// en el arrayList, Mientras haya filas en la tabla
			// Creamos un ingrediente y lo añadimos al ArrayList
			while (res.next()) {
				// Creamos un ingrediente y lo cargamos con los datos del resulset
				IngredienteVO ingrediente = new IngredienteVO(res.getInt("idIngrediente"), res.getString("nombre"),
						res.getString("tipo"));
				// Añadimos
				ingredientes.add(ingrediente);

			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// devolvemos el array cargado con los ingredientes
		return ingredientes;

	}

	public MontaditoVO getMontaditoDB(int idMontadito) {
		// Definimos la variable que guardara los datos de la BD
		MontaditoVO montadito = null;

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {

			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el montadito
			res = stmt.executeQuery("SELECT * FROM montaditos WHERE idMontaditos =" + idMontadito);

			// Cargamos el registro
			if (res.next()) {
				montadito = new MontaditoVO(res.getInt("idMontaditos"), res.getString("nombre"), res.getInt("precio"),
						res.getString("tamanio"), res.getShort("premium"));

			} else {
				System.out.println("El id del montadito no existe");
			}

			con.close();
			res.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return montadito;
	}

	/**
	 * Actualiza en la DB los datos que no sean nulos
	 * 
	 * @param idMontadito
	 * @param nombre
	 * @param precio
	 * @param tamano
	 * @param premium
	 * @return devuelve 0 si la actualización ha sido correcta, 1 en caso contrario
	 */
	public int actualizarMontaditoDB(int idMontadito, String nombre, int precio, String tamano, short premium) {

		// Comprobamos que no hay fallos en los datos
		if (idMontadito == 0 || (nombre == null && precio == 0 && tamano == null && (premium != 0 || premium != 1))) {
			return 1;
		}

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {

			// Definimos campo previo para comprobar si hay algúnç
			// Campo no nulo antes
			boolean campoPrevio = false;

			// Creamos el Statement
			Statement stmt = con.createStatement();

			String actualizar = "UPDATE montaditos SET ";

			// Si hay un nombre lo añadimos a la sentencia
			if (nombre != null) {
				actualizar.concat("nombre='" + nombre + "'");
				campoPrevio = true;
			}

			// Si hay precio lo añadimos a la sentencia
			if (precio != 0) {
				// La , no la añadimos sólo si previamente
				// No se modifico ningun cambio
				if (campoPrevio)
					actualizar.concat(",precio=" + precio);
				else
					actualizar.concat("precio=" + precio);
				// Activamos el flag (boolean) campo previo
				campoPrevio = true;
			}

			if (tamano != null) {

				// La , no la añadimos sólo si previamente
				// No se modifico ningun cambio
				if (campoPrevio)
					actualizar.concat(",tamano='" + tamano + "'");
				else
					actualizar.concat("tamano='" + tamano + "'");

				// Activamos el flag (boolean) campo previo
				campoPrevio = true;
			}

			if (premium == 0 || premium == 1) {

				// La , no la añadimos sólo si previamente
				// No se modifico ningun cambio
				if (campoPrevio)
					actualizar.concat(",premium=" + premium);
				else
					actualizar.concat("premium=" + premium);

			}

			actualizar = actualizar + " WHERE idMontadito = " + idMontadito;

			int filasAfectadas = stmt.executeUpdate(actualizar);

			// Si no se ha actualizado ningun registro
			// devolvemos fallo
			if (filasAfectadas == 0)
				return 1;

			// Cerramos la conexion con la BD
			con.close();
			stmt.close();

		} catch (SQLException sqe) {
			sqe.printStackTrace();
		}

		return 0;
	}

	public ArrayList<MontaditoVO> cargarMontaditosBD() {

		// Definimos el arrayList que guardara todos los montaditos de la BD
		ArrayList<MontaditoVO> montaditos = new ArrayList<MontaditoVO>();

		// Conectamos con la BD
		Connection con = ConexionBD.conectar();

		// Definimos un ResulSet para recoger los datos de la BD
		ResultSet res = null;

		try {

			// Creamos el Statement
			Statement stmt = con.createStatement();

			// Recuperamos de la BD el montadito
			res = stmt.executeQuery("SELECT * FROM montaditos");

			// Cargamos todos los registros de la tabla montaditos
			// en el arrayList, Mientras haya filas en la tabla
			// Creamos un montadito y lo añadimos al ArrayList
			while (res.next()) {
				// Creamos un montadito y lo cargamos con los datos del resulset
				MontaditoVO montadito = new MontaditoVO(res.getInt("idMontaditos"), res.getString("nombre"),
						res.getInt("precio"), res.getString("tamanio"), res.getShort("premium"));
				// Añadimos
				montaditos.add(montadito);

			}

			stmt.close();
			con.close();
			res.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// devolvemos el array cargado con los montaditos
		return montaditos;

	}

}
