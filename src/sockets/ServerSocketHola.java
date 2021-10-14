package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketHola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket socketCliente = null;
		ServerSocket servicio = null;
		String mensaje = "", respuesta = "incorrecto";

		try {

			// Creamos el socket Servidor
			servicio = new ServerSocket(ClientSocketHola.PUERTO_SERVIDOR);

			// Esperamos a que un cliente se conecte
			// Y recibimos el socket de la conexion
			socketCliente = servicio.accept();

			// Creamos los objetos de comunicación con el servidor
			DataOutputStream sout = new DataOutputStream(socketCliente.getOutputStream());
			DataInputStream sin = new DataInputStream(socketCliente.getInputStream());

			// Mientras la conexion este activa
			// respondemos al cliente
			while (!socketCliente.isClosed()) {
				// Recibimos el mensaje del cliente
				mensaje = sin.readUTF();

				// Comprobamos si tiene la palabra hola
				if (mensaje.toUpperCase().indexOf("HOLA") != -1) {
					respuesta = "\nServidor: Hola!. ¿Qué tal estás?\n Bienvenido al Servicio\n Cliente:";
				} else if (mensaje.toUpperCase().indexOf("ADIOS") != -1) {
					respuesta = "\nServidor: Hasta Otra, nos ha encantado contar con su excelsa presencia (y su dinero)\nConexión cerrada";
				} else
					respuesta = "incorrecto";

				// Devolvemos el mensaje al cliente
				sout.writeUTF(respuesta);

				// Cierro el socket si me dice adios
				if (mensaje.toUpperCase().indexOf("ADIOS") != -1) {
					socketCliente.close();
				}

			}

			// Cerramos los sockets
			sin.close();
			sout.close();
			servicio.close();

		} catch (IOException ioe) {
			System.out.println("No se ha podido levantar el servicio");
			ioe.printStackTrace();
		}

	}

}
