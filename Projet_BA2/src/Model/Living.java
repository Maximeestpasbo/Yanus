package Model;

import java.util.ArrayList;

public abstract class Living extends GameObject  {

	protected int lp;
	protected int timeTS;
	protected int trueTimeTS;

	

	public Living (int posX, int posY, int color, int lp, int timeTS) {
		super(posX, posY, color);  //attribut commun à toutes les filles de GameObject, pas besoin de les spécifier dans chacune   //permet de regarder si rentre en conatct avec un objet
		this.lp = lp;
		this.timeTS = timeTS;
		this.trueTimeTS= timeTS;
	}
	
	public void setTimeTS(int timeTS){
		this.timeTS = timeTS;
		
	}
	public int getTimeTS(){
		return this.timeTS;
	}
	public void Hit(int degats){
		int newLp = this.getLp()-degats;
		this.setLp(newLp);
	
	}
	
	public void move(int x, int y){

		this.posX = this.posX + x;
		this.posY = this.posY + y;

	}	
	public void Gain(int degats){
		int newLp = this.getLp()+degats;
		this.setLp(newLp);
	
	}

	protected void setLp(int newLp) {
		this.lp = newLp;
		
		
	}

	protected int getLp() {
		
		return this.lp;
	}

	public int getTrueTimeTS() {
		return this.trueTimeTS;
	}
}
