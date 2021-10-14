package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.MontaditoVO;

public class ServerSocketMontadito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket socketCliente = null;
		ServerSocket servicio = null;
		MontaditoVO montaditoRecibido = null;

		try {

			// Creamos el socket Servidor
			servicio = new ServerSocket(ClientSocketHola.PUERTO_SERVIDOR);

			// Esperamos a que un cliente se conecte
			// Y recibimos el socket de la conexion
			socketCliente = servicio.accept();

			// Creamos el stream para recibir el objeto montadito
			ObjectInputStream sin = new ObjectInputStream(socketCliente.getInputStream());

			// leemos el montadito
			montaditoRecibido = (MontaditoVO) sin.readObject();

			System.out.println(montaditoRecibido.toString());

			sin.close();
			socketCliente.close();
			servicio.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
