package multi.thread.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Hilo implements Runnable {

	String clientSentence, capitalizedSentence;
	Socket connectionSocket;

	public Hilo(Socket connectionSocket) {	
		this.connectionSocket = connectionSocket;
		
	}

	public void run() {
		
		while (true) {

			try {
				// Create input stream, attached to socket
				BufferedReader inFromClient = new BufferedReader(
						new InputStreamReader(connectionSocket.getInputStream()));

				// Create output stream, attached to socket
				DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

				// Read in line from socket
				clientSentence = inFromClient.readLine();
				capitalizedSentence = clientSentence.toUpperCase() + '\n';

				// Write out line to socket
				outToClient.writeBytes(capitalizedSentence);

				// End of while loop, bloop back and
				// wait for another client connection

				System.out.println("CLIENT Conectado desde: " + connectionSocket.getInetAddress().getHostAddress() + ":"
						+ connectionSocket.getPort());
				System.out.println("SERVER Client sentence: " + clientSentence);
				System.out.println("SERVER Capitalized sentence: " + capitalizedSentence);
				
			} catch (Exception ex) {
				System.out.println("Error: "+ ex.getMessage());
			}
			
			
		}
		
	}

}
