package Model;

public abstract class Weapon extends Item implements Damage, CheckPos {
	private int color;
	protected int degats;
	public Weapon (int posX, int posY, int count, Game game, int color, int degats){
		super(posX,posY,count,game,color);
		this.color = color;
		this.degats = degats;
		
	}
	
	public int getDegats(){
		return this.degats;
	}
	
	

}
