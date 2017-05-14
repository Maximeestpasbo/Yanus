package Model;

import java.util.ArrayList;
import java.util.Random;

import Model.Game;

public abstract class Monster extends Living implements Runnable{
	protected Game game;
	protected int lp;
	protected int mVision;
	protected int x;
	protected int y;
	

	public Monster(int posX, int posY, int x, int y, int color, Game game, int mVision, int lp) {
		super(posX, posY, color, lp , 500);  //attribut commun à toutes les filles de GameObject, pas besoin de les spécifier dans chacune 
		this.game = game;    //permet de regarder si rentre en conatct avec un objet
		this.lp = lp;
		this.x =x;
		this.y = y;
	}
	
	@Override
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






}


