package Model;

import java.util.ArrayList;
import java.util.Random;

public class mMicrobe extends Monster {
	
private static int mVision = 0;
private static int x;
private static int y;
	
	
	public mMicrobe(int posX, int posY, Game game, int lp) {
		super(posX, posY, x, y, 7, game, mVision, lp);
		Thread t1 = new Thread(this);
		t1.start();
	}
	
	
	@Override
	public void run() {
		Random rand = new Random();

		int count = 0;
		int posX = this.posX;
		int posY = this.posY;
		int lpTest = this.lp;

		while(lpTest>0){
			try {
				Thread.sleep(timeTS);
				
				x = ((rand.nextInt(2))*2-1);
				y = ((rand.nextInt(2))*2-1);
				
				setX(x);
				setY(y);
				
				game.moveMonster(this, mVision);

				if(rand.nextInt(20) == 0){
				game.newMonster(this);
				}
				lpTest = this.getLp();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			} 
		game.removeObject(this);
		if(this.getLp() <= 0){
			boolean test = true;
			for (int i = 0; i< game.getGameObjects().size(); i++){
				GameObject object = game.getGameObjects().get(i);
				if (object instanceof Monster){
					test = false;
					
				}
			}
			if (test){
				
				Portal portal = new Portal(game.getSizeX(), game.getSizeY());
				game.addObjects(portal);
		}
		}
		}	


	
	
	
}