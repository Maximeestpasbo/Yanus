package Model;

public class Hammer extends Weapon  {
	public Hammer (int posX, int posY, int count, Game game, int degats, int color){
		super(posX,posY, count, game, color, degats);
 		this.game = game;
		this.count = count;
	}
	@Override
	public void damage(Living living, int degats) {
		living.Hit(degats);
		//Animation animation = new Animation
		
	}
	@Override
	public boolean checkPos(int x, int y, GameObject go2) {
		boolean so =false;
		boolean distanceX = x - go2.getPosX() == 0 ;
		boolean distanceY = y - go2.getPosY() == 0 ;

		if(distanceX && distanceY){
			so = true;	
		}
		return so;

	} 
	
}

