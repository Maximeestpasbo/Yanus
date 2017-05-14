package Model;

public class Fleche extends Weapon {
	private Living living;
	private Player player;
	private static int playerNumber;
	private int count;
	private int scopelength;
	private int widthrange;
	private int color;
	//private Living living;
	private int degat;
	private Game game;
	private GameObject go2;
	private int monsterNumber;

	public Fleche(int color, int degat, int count, Game game,Player player) {
		super(color, degat );
		this.game = game;
		this.count = count;
		this.player= player;
		
		Thread t = new Thread();
		t.start();
		
	}
	public void aim(){

	}

	
	/* viser(dans use Weapon); tirer; collision; disparition*/

		
		
	
	@Override
	public void damage(Living living, int degats) {
		int x = player.getPosX();
		int y = player.getPosY();
		int dirx = player.getDirectionX();
		int diry = player.getDirectionY();
		while (x < scopelength && y < scopelength){
			
			if (this.checkPos(x, y, go2) && go2.isObstacle()){
		
				living.Hit(degats);
				this.count -=1;
		
		}
			else{}
		}
		
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
	public int getScopelength() {
		return scopelength;
	}
	public void setScopelength(int scopelength) {
		this.scopelength = scopelength;
	} 
	
}
