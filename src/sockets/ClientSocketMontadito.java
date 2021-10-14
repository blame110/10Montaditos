package sockets;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.MontaditoVO;

public class ClientSocketMontadito {

	public static final int PUERTO_SERVIDOR = 1233;
	public static final String HOST_SERVIDOR = "localhost";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MontaditoVO montadito = new MontaditoVO(20, "Chiguagua", 3, "G", (short) 1);

		try {

			Socket cliente = new Socket(HOST_SERVIDOR, PUERTO_SERVIDOR);
			// Creo un stream para enviar el objeto
			ObjectOutputStream sout = new ObjectOutputStream(cliente.getOutputStream());

			sout.writeObject(montadito);

			cliente.close();
			sout.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
