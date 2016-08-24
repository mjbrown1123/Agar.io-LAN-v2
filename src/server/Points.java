package server;

import java.awt.Color;
import java.util.Random;

public class Points {
	
	//variables for each point (small dot on screen)
	private float x;
	private float y;
	private float diam;
	private Color color; 
	
	//size = area of point
	private float size;
	
	//constructor
	public Points(int xx, int yy, Color col) {
		newColor();
		x = xx;
		y = yy; 
	}

	//methods for setting and getting certain variables for points
	public void setSize(float newSize) {
		
		size = newSize;
		
		diam = 2 * (float)Math.sqrt(newSize / Math.PI);
		
	}
	
	public void newColor() {
		Random ran = new Random();
		
		float r = ran.nextFloat() * (float)0.750;
		float g = ran.nextFloat() * (float)0.750;
		float b = ran.nextFloat() * (float)0.750;
		
		color = new Color(r, g, b);
	}
	public Color getColor() {
		
		return color;
	}
	
	public void setDiam(float newDiam) {
		
		diam = newDiam;
		
		size = (float)(Math.PI * Math.pow(diam/2, 2));
	}
	
	public float getSize() {
		
		return size;
	}

	
	public float getDiam() {
		
		return diam;
		
	}
	
	public float getRadius() {
		
		return diam / 2;
	}
	
	public void setRadius(int r) {
		
		diam = 2 * r;
		
	}
	
	public void setX(int xx) {
		
		x = xx;
		
	}
	
	public void setY(int yy) {
		y = yy;
		
	}
	public float X() {
		
		
		return x;
	}
	
	public float Y() {
		
		return y;
	}

}
