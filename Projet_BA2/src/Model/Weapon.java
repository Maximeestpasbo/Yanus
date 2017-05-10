package Model;

public abstract class Weapon implements Damage, CheckPos {
	private int color;
	private int degats;
	public Weapon (int color, int degats){
		this.color = color;
		this.degats = degats;
		
	}
	
	public int getDegats(){
		return this.degats;
	}
	
	

}
