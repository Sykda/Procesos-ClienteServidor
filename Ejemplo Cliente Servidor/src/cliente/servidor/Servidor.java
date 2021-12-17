package cliente.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws Exception {

		String clientSentence;
		String capitalizedSentence;

		// Create welcoming socket at port 2009
		ServerSocket welcomeSocket = new ServerSocket(2009);
		System.out.println("SERVER Conectado al socket de servidor en el puerto: " + welcomeSocket.getLocalPort() + ". Esperando conexiones de clientes.\n");
		
		while (true) {

			// Wait, on welcoming socket for contact by client
			Socket connectionSocket = welcomeSocket.accept();
			

			// Create input stream, attached to socket
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			// Create output stream, attached to socket
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			// Read in line from socket
			clientSentence = inFromClient.readLine();
			capitalizedSentence = clientSentence.toUpperCase() + '\n';

			// Write out line to socket
			outToClient.writeBytes(capitalizedSentence);

			// End of while loop, bloop back and
			// wait for another client connection

			
			System.out.println("CLIENT Conectado desde: "+connectionSocket.getInetAddress().getHostAddress()+":"+connectionSocket.getPort());
			System.out.println("SERVER Client sentence: "+clientSentence);
			System.out.println("SERVER Capitalized sentence: " + capitalizedSentence);

		}
	}
}
