package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import javafx.concurrent.Task;

public class ClienteServidor {

	private static final int Puerto = 2000;
	private String host = "localhost";
	private Boolean abierto = true;
	

	// Envia
	public void Servidor() {
		ServerSocket skServidor;
		try {
			skServidor = new ServerSocket(2000);
			
			while (abierto) {
				System.out.println("Escucho el puerta " + 2000);
				
				Socket sCliente = skServidor.accept();
							
				DataOutputStream dos = new DataOutputStream(sCliente.getOutputStream());
				dos.writeUTF("Hola cliente soy papi " + Math.random() * 50);

				sCliente.close();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Escucha
	public void Cliente() {

		try {
//			while (abierto) {
				Socket sCliente = new Socket("10.2.2.17", 2001);
				
				DataInputStream dis = new DataInputStream(sCliente.getInputStream());
				String datos = dis.readUTF();
				System.out.println(datos);
				sCliente.close();
//			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	public static void main(String[] args) {
		ClienteServidor cs = new ClienteServidor();
		
		Thread servidor = new Thread() {
		    public void run() {
		        cs.Servidor();
		    }
		};
		servidor.start();
		
		Thread cliente = new Thread() {
		    public void run() {
		        cs.Cliente();
		    }
		};
		cliente.start();
//		
		
		
	}

}
