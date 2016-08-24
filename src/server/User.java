package server;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Random;

public class User {
	
	private InetAddress address;
	
	private ArrayList<Blob> blobs;
	
	private Random ran;
	
	private String name;
	
	private int port;
	
	public User(InetAddress ipAddress, String userName, int newPort) {
		ran = new Random();
		
		blobs = new ArrayList<Blob>();
		
		address = ipAddress;
		
		name = userName;
		
		
		port = newPort;
		
		blobs.add(new Blob(ran.nextInt(Game.boundaryX - Game.initialDiam), ran.nextInt(Game.boundaryY - Game.initialDiam), 100, 0,0, name));
		
		
	}
	
	public void addBlob(Blob blob) {
		
		blobs.add(blob);
		
	}
	
	public Blob getBlob(int index) {
		
		Blob blob = blobs.get(index);
		return blob;
	}
	public ArrayList<Blob> getBlobs() {
		
		return blobs;
	}
	public String getName() {
		
		return name;
	}
	public void setBlob(int index, Blob blob) {
		
		blobs.set(index, blob);
		
	}

}
