package Model;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class GameObject {
	protected int posX;
	protected int posY;
	protected int color;
	private Image image;
	
	public GameObject(int X, int Y, int color){
		this.posX = X;
		this.posY = Y;
		this.color = color;
        ImageIcon ii = new ImageIcon("D:/Users/Maxime/Pictures/Bomb01.png");
        image = ii.getImage();
	}
	
	public int getPosX(){
		return this.posX;
	}
	
	public int getPosY(){
		return this.posY;
	}
	
	public int getColor(){
		return this.color;
	}
	public Image getImage() {
		return this.image;
	}
	

	
	public boolean isAtPosition(int x, int y){
		return this.posX == x && this.posY == y;
	}
	
	public abstract boolean isObstacle();


}
