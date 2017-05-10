package Model;

import java.util.ArrayList;

public class Player extends Living implements DemisableObserver, ExplodableObserver, Demisable{
	
	int countBomb = 0;
	int maxBomb = 0;
	int bombRange = 1;
	int placeInventaire = 3;
	static int timeTS = 200;
	int directionX;
	int directionY;
	private ArrayList<DemisableObserver> observers = new ArrayList<DemisableObserver>();
	
	public Player(int x, int y, int maxBomb, int lifes){
		super(x,y,2,lifes, timeTS);
		this.maxBomb = maxBomb;
		this.countBomb = maxBomb;
		this.directionX =x+1;
		this.directionY = y;
	}
	
	public void move(int X, int Y){
		super.posX = this.posX + X;
		super.posY = this.posY + Y;
		this.directionX= this.posX+X;
		this.directionY = this.posY+Y;
	}
	

	public BombObject dropBomb(String type){
		if(this.maxBomb > 0){
			this.maxBomb = this.maxBomb - 1;
			BombObject bomb = null;
			if(type.equals("nuke")){
				bomb = new Nuke(this.posX, this.posY, 3000, this.bombRange);
			}else if(type.equals("bomb")){
				bomb = new Bomb(this.posX, this.posY, 3000, this.bombRange);
			}
			bomb.demisableAttach(this);
			Thread thread = new Thread(bomb);
			thread.start();
			return bomb;
		}
		return null;
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
	public void demisableAttach(DemisableObserver po) {
		observers.add(po);		
	}

	@Override
	public void demisableNotifyObserver() {
		for (DemisableObserver o : observers) {
			o.demise(this, null);
		}	
	}

	@Override
	public void demise(Demisable ps, ArrayList<GameObject> loot) {
		if(this.maxBomb < this.countBomb){
			this.maxBomb = this.maxBomb + 1;	
		}
	}

	@Override
	public void exploded(Explodable e) {
		BombObject bomb = (BombObject) e;
		boolean distanceX = Math.abs(this.getPosX() - bomb.getPosX()) <= bomb.getRange();
		boolean distanceY = Math.abs(this.getPosY() - bomb.getPosY()) <= bomb.getRange();

		if(distanceX && distanceY){
			this.lp = this.lp - 1;
			if(this.lp == 0){
				demisableNotifyObserver();
			}			
		}		
	}

	@Override
	public boolean isObstacle() {
		return false;
	}
}
