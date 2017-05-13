package Model;

import java.util.ArrayList;
import java.util.Random;

import Model.Game;

public abstract class Monster extends Living implements Runnable, DemisableObserver, ExplodableObserver, Demisable{
	protected ArrayList<DemisableObserver> observers = new ArrayList<DemisableObserver>();
	protected Game game;
	protected int lp;
	protected int mVision;
	protected int x;
	protected int y;
	protected static int timeTS = 500;
	

	public Monster(int posX, int posY, int x, int y, int color, Game game, int mVision, int lp) {
		super(posX, posY, color, lp , timeTS);  //attribut commun à toutes les filles de GameObject, pas besoin de les spécifier dans chacune 
		this.game = game;    //permet de regarder si rentre en conatct avec un objet
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
		


	@Override
	public void Hit(int degats){
		int newLp = this.getLp()-degats;
		this.setLp(newLp);
		
	
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
observers.add(po); //ajoute game à la liste observers pour pouvoir l'enlever de l'écran le moment venu	
}

@Override
public void demisableNotifyObserver() {
for (DemisableObserver o : observers) {
o.demise(this, null); //enlève ennemi quand mort
}	
}

@Override
public void exploded(Explodable e) {
BombObject bomb = (BombObject) e;
boolean distanceX = Math.abs(this.getPosX() - bomb.getPosX()) <= bomb.getRange();
boolean distanceY = Math.abs(this.getPosY() - bomb.getPosY()) <= bomb.getRange();

if(distanceX && distanceY){
this.Hit(1);
}
//if(lp <= 0){
//demisableNotifyObserver();


//}
}




@Override
public void demise(Demisable d, ArrayList<GameObject> loot) {
//TODO Auto-generated method stub

}


}


