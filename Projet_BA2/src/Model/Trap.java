package Model;

public class Trap extends Item implements CheckPos, Damage {
	
	private int degats;
	protected int rangeX;
	protected int rangeY;
	

	public Trap (int posX, int posY, Game game, int color,  int count, int degats, int rangeX, int rangeY){
		super(posX,posY,count,game,color);
		this.degats = degats;
		this.rangeX = rangeX;
		this.rangeY = rangeY;
	}
	
	@Override
	public boolean checkPos(int x, int y, GameObject gameObject){
		boolean so =false;
		boolean distanceX = Math.abs(x - gameObject.getPosX()) <= rangeX ;
		boolean distanceY = Math.abs(y - gameObject.getPosY()) <= rangeY ;

		if(distanceX && distanceY){
			so = true;	
		}
		return so;

	}
	
	@Override
	public void damage(Living living, int degats) {
		living.Hit(degats);
		//Animation animation = new Animation
		
	}
	
	public int getDegats(){
		return this.degats;
	}
	
	public int getRangeX(){
		return this.rangeX;
	}
	
	public int getRangeY(){
		return this.rangeY;
	}
}
