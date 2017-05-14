package Model;

import java.util.ArrayList;

public class Fleche extends Weapon implements Runnable {
	private Living living;
	private Player player;
	private static int playerNumber;
	private int count;
	private int scopelength;
	private int widthrange;
	private int color;
	//private Living living;
	private Game game;
	private GameObject go2;
	private int monsterNumber;
	private int dirX;
	private int dirY;
	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public Fleche(int posX, int posY, int color, int degats, int count, Game game, int scopelength) {
		super(posX,posY, count, game, color, degats);
		this.game = game;
		this.count = count;
		this.scopelength= scopelength;
		
	}
	public boolean isAtPosition(int x, int y){
		return this.posX == x && this.posY == y;
	}
	public void moveArrow(int X, int Y){
		this.posX= this.posX + X;
		this.posY = this.posY + Y;

		//System.out.println("positionX==" + this.posX + "positionY ==" +this.posY);
		
		//System.out.println("directionX==" + this.dirX + "directionY ==" +this.dirY);
		//System.out.println("vie monstre"+ living.getLp());
	}
	public void newThread(int x, int y){
		this.dirX = x;
		this.dirY = y;
		Thread thread = new Thread(this);
		thread.start();
	}

	
	/* viser(dans use Weapon); tirer; collision; disparition*/


	@Override
	public boolean checkPos(int x, int y, GameObject go2) {
		
		boolean so =false;
		
		boolean distanceX = (this.getPosX()+x - go2.getPosX() )== 0 ;
		boolean distanceY = (this.getPosY()+y - go2.getPosY() )== 0 ;

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
	@Override
	public void damage(Living living, int degats) {
		living.Hit(this.degats);		
	} 
	
	@Override
	public void run(){
		

		
		int scopelength = this.getScopelength();
		
		int i =0;
		boolean test = false;
		while(!test && i< this.getScopelength()){
			System.out.println(this.getPosX());
			for (int j =0; j<game.getGameObjects().size(); j++){
				GameObject go2 = ( game.getGameObjects().get(j));
				if (this.checkPos(dirX,dirY, go2)){
					System.out.println("Hit!");
					test=go2.isObstacle();
					if (go2 instanceof Living){
						this.damage((Living) go2, this.degats);
						//System.out.println("hit by an arrow");
						if(go2 instanceof Player){
							i = scopelength;
							
						}
				
				
			}}
			}
			if(!test){
				Animation animation = new Animation(3,this.getPosX()+dirX,this.getPosY()+dirY,2,game,0,0);
				this.moveArrow(dirX,dirY);
				//System.out.println(fleche.getPosX());
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i+=1;
				
			}
				
		}
	}
	
}
