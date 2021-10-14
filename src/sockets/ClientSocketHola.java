package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketHola {

	public static final int PUERTO_SERVIDOR = 1233;
	public static final String HOST_SERVIDOR = "localhost";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket socketCliente = null;
		Scanner teclado = new Scanner(System.in);
		String mensaje = "";
		String respuesta = "";

		try {
			// Conectamos con el servidor
			socketCliente = new Socket(HOST_SERVIDOR, PUERTO_SERVIDOR);

			// Creamos los objetos de comunicación con el servidor
			DataOutputStream sout = new DataOutputStream(socketCliente.getOutputStream());
			DataInputStream sin = new DataInputStream(socketCliente.getInputStream());

			// Leemos la frase por teclado
			System.out.println("Bienvenido.\n Mensaje: ");

			// Mientras el servidor no nos diga adios
			while (respuesta.toUpperCase().indexOf("CERRADA") == -1) {

				mensaje = teclado.nextLine();

				// Enviamos el mensaje al servidor
				sout.writeUTF(mensaje);

				// Leemos la respuesta del servidor
				respuesta = sin.readUTF();
				// Recibimos la respuesta del servidor
				if (respuesta.toUpperCase().indexOf("INCORRECTO") == -1)
					System.out.print(respuesta);
				else
					System.out.print("El servidor no ha entendido lo que has dicho.\n Cliente:");

			}

			// Cerramos los sockets
			sin.close();
			sout.close();
			socketCliente.close();

		} catch (IOException ioe) {
			System.out.println("Error al conectarse al servidor");
			ioe.printStackTrace();
		}

	}

}
