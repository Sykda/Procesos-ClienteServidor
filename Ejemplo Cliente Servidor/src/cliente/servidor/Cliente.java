package cliente.servidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) throws Exception {

		String sentence;
		String modifiedSentence;
		
		System.out.println("CLIENT: ");

		// Create an input stream
		//BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		// Create a client socket, connect to server
		Socket clientSocket = new Socket("127.0.0.1", 2009);

		int i = 0;
		
		while (true) {
			
			
			i++;
			
			// Create an output stream attached to the socket
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

			
			// Create an input stream attached to socket
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			sentence = "Hola";
			System.out.println("Frase "+i + ": "+sentence);

			// Send a line to server
			outToServer.writeBytes(sentence + '\n');

			// Read a line from server
			modifiedSentence = inFromServer.readLine();

			System.out.println("FROM SERVER: " + modifiedSentence);

			//clientSocket.close();

			Thread.sleep(1000);
		}

	}
}
