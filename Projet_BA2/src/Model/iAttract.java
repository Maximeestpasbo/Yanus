package Model;

public class iAttract extends Item implements CheckPos{
	private int degats;
	public iAttract(int posX, int posY, int count, Game game, int color){
		super(posX,posY,count,game,color);
		this.degats=0;
	}
	
	@Override
	public void use(int playerNumber){
		int x = this.getPosX();
		int y = this.getPosY();
		for (int i =0; i < game.getGameObjects().size(); i++){
			GameObject object = game.getGameObjects().get(i);
			if (object instanceof Monster){
			if (this.checkPos( x,  y, object)){
				if (x-object.getPosX()== 0 && y > object.getPosY()){
					degats = 5;}
				if (x-object.getPosX()== 0 && y < object.getPosY()){
					degats = 8;}
				if (y-object.getPosY()== 0 && x > object.getPosX()){
					degats = 6;}
				if (y-object.getPosY()== 0 && x < object.getPosX()){
					degats = 4;}
				Living object2 = (Living) object;
				System.out.println(this.getPosX());
				System.out.println(this.getPosY());
				Attract attract = new Attract (x,y,object2, degats, game);
			}
		}}
		this.count -= 1;
		
	}
	@Override
	public boolean checkPos(int x, int y, GameObject go){
		boolean so =false;
		boolean distanceX = Math.abs(x - go.getPosX()) <= game.getSizeX() && y-go.getPosY() == 0 ;
		boolean distanceY = Math.abs(y - go.getPosY()) <= game.getSizeY() && x-go.getPosX() == 0 ;

		if(distanceX || distanceY){
			so = true;	
		}
		return so;
		
	}
	


}
