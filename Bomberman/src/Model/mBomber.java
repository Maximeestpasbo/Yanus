package Model;
import java.util.ArrayList;
import java.util.Random;

public class mBomber extends Monster {
	private ArrayList<DemisableObserver> observers = new ArrayList<DemisableObserver>();
	private static int mVision = 1;
	private static int x = 1;
	private static int y = 0;

	public mBomber(int posX, int posY, Game game,  int lp) {
		super(posX, posY,x,y, 4, game, mVision, lp);
		Thread t1 = new Thread(this);
		t1.start();
	}

	@Override
	public void run() {
		Random rand = new Random();
		int count = 0;
		int posX = this.posX;
		int posY = this.posY;
		while(lp>0){
			try {
				Thread.sleep(500);
				count = count + 1;
				game.moveMonster(this, mVision);
				if(rand.nextInt(5) == 0 && count>= 8){
				game.monsterDropBomb("nuke",  this);
				count = 0;
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}}

	public BombObject dropBomb(String type){
		//if(this.maxBomb > 0){
			//this.maxBomb = this.maxBomb - 1;
			BombObject bomb = null;
			if(type.equals("nuke")){
				bomb = new Nuke(this.posX, this.posY, 3000, 0);
			}else if(type.equals("bomb")){
				bomb = new Bomb(this.posX, this.posY, 3000, 1);
			}
			bomb.demisableAttach(this);
			Thread thread = new Thread(bomb);
			thread.start();
			return bomb;
		
	}



	
	
	
}




