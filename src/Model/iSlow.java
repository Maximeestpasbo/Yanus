package Model;

import java.util.ArrayList;

public class iSlow extends Item implements Runnable, Explodable{
	
	private int temps;
	private int duree;
	private int range;
	private boolean detonated;
	private int effet;
	private ArrayList<ExplodableObserver> explodableObservers = new ArrayList<ExplodableObserver>();
	
	public iSlow (int posX, int posY, int count, Game game, int temps, int duree, int range, int effet, int color){
		super(posX,posY,count,game,color);
		this.temps = temps;
		this.duree = duree;
		this.range = range;
		this.effet = effet;
	}

	@Override 
	public void use(int playerNumber){
		Thread thread = new Thread(this);
		thread.start();
		count -= 1;
	}
	
	@Override
	public void run() {
		int timer = 0;
		//this.demisableAttach(game);
		game.addObjects(this);
		while(!this.detonated  ){
			try {
				Thread.sleep(10);
				game.checkPos(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
		this.color = 8;
		while (timer < temps){
			try {
				Thread.sleep(100);
				game.checkPos(this);
				System.out.println(timer);
				this.explodableNotifyObserver();
				timer = timer+ 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		game.removeObject(this);
	}
	
		
		
		
	public void setDetonated(boolean fact){
		this.detonated = fact;
	}
	public boolean getDetonated(){
		return this.detonated;
	}
	
	@Override
	public void explodableAttach(ExplodableObserver eo) {
		explodableObservers.add(eo);
	}
	@Override
	public void explodableNotifyObserver() {
		for (ExplodableObserver o : explodableObservers) {
			Living one = (Living) o;
			Slow slow = new Slow (one, effet, duree);
			explodableObservers.remove(o);
		}
	}
	

	
	
	
	
}

	

