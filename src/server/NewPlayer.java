package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class NewPlayer implements Runnable{
	private Thread thread;
	public String threadName;

	public NewPlayer(String nam) {

		threadName = nam;

	}

	public void run() {
		try{ 
			DatagramSocket serverSocket = new DatagramSocket(9876);
			
			while (true) {
				byte[] receiveData = new byte[50];
				// InetAddress address = InetAddress.getLocalHost();
				// System.out.println(address);
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
				
				/*for(int i = 0 ; i < receiveData.length; i++) {
					System.out.print(receiveData[i]);
				
				}
				System.out.println();*/
				
				//get the inetaddress from the packet and make sure that the user isn't already in the directory
					// if so...pass the packet on to another function that handles the position of the blob
				
				String receive = new String(receivePacket.getData());
				
				ArrayList<String> message = new ArrayList<String>();
				
				int lastIndex = 0;
				
				for(int i = 0; i < receive.length(); i++) {
					
					if(receive.charAt(i) == ':') {
						
						message.add(receive.substring(lastIndex, i));
						lastIndex = i + 1;
					}
					
					
				}
				
				message.add(receive.substring(lastIndex, receive.length()));
				InetAddress IPAddress = receivePacket.getAddress();
				
				if(Game.addresses.containsKey(IPAddress) && message.get(0) != null) {
					
				/*	System.out.println(message.get(0));
					System.out.println(message.get(1));
					System.out.println(message.get(2));*/
					Blob blob = Game.blobList.get(message.get(0).trim()).getBlob(0);
					
					blob.setX(Float.parseFloat(message.get(1)));
					blob.setY(Float.parseFloat(message.get(2)));
					Game.blobList.get(message.get(0)).setBlob(0, blob);
					Game.blobList.put(message.get(0), Game.blobList.get(message.get(0)));
					
				}
				else {
					
					System.out.println("New User: " + message.get(0));

					int port = receivePacket.getPort();
					Game.newUser(message.get(0), IPAddress, port);
					
					
				}
				
				
				/*String capitalizedSentence = name;
				sendData = capitalizedSentence.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
				serverSocket.send(sendPacket);*/
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void start() {

		thread = new Thread(this, threadName);
		thread.start();
	}

}
