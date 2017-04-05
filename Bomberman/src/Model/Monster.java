package Model;

import java.util.ArrayList;
import java.util.Random;

import Model.Game;

public abstract class Monster extends GameObject implements Runnable, DemisableObserver, ExplodableObserver, Demisable{
	protected ArrayList<DemisableObserver> observers = new ArrayList<DemisableObserver>();
	protected Game game;
	protected int lp;
	protected int mVision;
	protected int x;
	protected int y;
	

	public Monster(int posX, int posY, int x, int y, int color,  Game game, int mVision, int lp) {
		super(posX, posY, color);  //attribut commun à toutes les filles de GameObject, pas besoin de les spécifier dans chacune 
		this.game = game;    //l'attribut game prend l'objet que lui envoi celui qui appelle le constructeur
		this.lp = lp;
		this.x =x;
		this.y = y;
	}
	
	public void move(int x, int y){

		this.posX = this.posX + x;
		this.posY = this.posY + y;

	}	

	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	
	public void setY(int y){
		this.y = y;
	}
		


	

	
	
	


	


////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
@Override
public void run() {
}

@Override
public boolean isObstacle() {
return true;
}	

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
public void exploded(Explodable e) {
BombObject bomb = (BombObject) e;
boolean distanceX = Math.abs(this.getPosX() - bomb.getPosX()) <= bomb.getRange();
boolean distanceY = Math.abs(this.getPosY() - bomb.getPosY()) <= bomb.getRange();

if(distanceX && distanceY){
this.lp = this.lp -1;
}
if(lp <= 0){
demisableNotifyObserver();


}
}


@Override
public void demise(Demisable d, ArrayList<GameObject> loot) {
//TODO Auto-generated method stub

}


}


