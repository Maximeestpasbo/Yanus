package Model;

import java.util.ArrayList;

public abstract class Living extends GameObject implements Demisable {
	protected ArrayList<DemisableObserver> observers = new ArrayList<DemisableObserver>();
	protected int lp;
	protected int timeTS;

	

	public Living (int posX, int posY, int color, int lp, int timeTS) {
		super(posX, posY, color);  //attribut commun � toutes les filles de GameObject, pas besoin de les sp�cifier dans chacune   //permet de regarder si rentre en conatct avec un objet
		this.lp = lp;
		this.timeTS = timeTS;
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
}
