package Model;

import java.util.ArrayList;

public class Player extends Living {
	
	int countBomb = 0;
	int maxBomb = 0;
	int bombRange = 1;
	int placeInventaire = 3;
	static int timeTS = 200;
	int directionX;
	int directionY;

	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public Player(int x, int y, int maxBomb, int lifes, ArrayList <GameObject> objects){
		super(x,y,2,lifes, timeTS);
		this.maxBomb = maxBomb;
		this.countBomb = maxBomb;
		this.directionX =x+1;
		this.directionY = y;
		this.objects = objects;
	}
	
	
	
	@Override
	public void move(int X, int Y){
		super.posX = this.posX + X;
		super.posY = this.posY + Y;
		this.directionX= this.posX+(X%2);
		this.directionY = this.posY+(Y%2);
		
	}
	


	
	
	public int getPlaceInventaire(){
		return this.placeInventaire;
	}
	public int getDirectionX(){
		return this.directionX;
	}
	public int getDirectionY(){
		return this.directionY;
	}
	

	
	////////////////////////////////////////////////////////////////////////////////////////


	@Override 
	public void Hit (int degats){
		int newLp = this.getLp()-degats;
		this.setLp(newLp);
		if (this.getLp()<=0){
			objects.set(objects.indexOf(this),new DeadPlayer(this.getPosX(),this.getPosY()));
			
		}
	}
	
	
	@Override
	public boolean isObstacle() {
		return false;
	}

	public void setPosX(int i) {
		this.posX = i;
		
	}
	public void setPosY(int i) {
		this.posY = i;
		
	}

	public void setDirectionX(int x) {
		this.directionX= this.posX+(x%2);
		
		
	}
	public void setDirectionY(int y) {
		this.directionY = this.posY+(y%2);
		
	}
}
