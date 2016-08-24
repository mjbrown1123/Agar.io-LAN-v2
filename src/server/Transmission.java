package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Transmission implements Runnable {
	
	private InetAddress address;
	private int port;
	private Thread thread;
	private String name;
	
	public Transmission(int newPort, InetAddress ipAddress, String nam) {

		address = ipAddress;
		port = newPort;
		name = nam;
		
	}

	public void run() {
		
		try{ 
			DatagramSocket serverSocket = new DatagramSocket(9876);
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			while (true) {
				// InetAddress address = InetAddress.getLocalHost();
				// System.out.println(address);
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				String name = new String(receivePacket.getData());
				System.out.println("New User: " + name);
				InetAddress IPAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();
				Game.newUser(name, IPAddress, port);
				
				String capitalizedSentence = name;
				sendData = capitalizedSentence.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
				serverSocket.send(sendPacket);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void start() {
		
		thread = new Thread(this, name);
		thread.start();
		
	}
	
	
}
