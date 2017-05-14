package Model;
import java.util.ArrayList;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Random;

public class mBomber extends Monster {
	private static int mVision = 1;

	private Image image;

	public mBomber(int posX, int posY, Game game,  int lp, int x, int y) {
		super(posX, posY,x,y, 12, game, mVision, lp);
		
        ImageIcon ii = new ImageIcon("D:/Users/Maxime/Pictures/Bloom04.png");
        image = ii.getImage();

		
		
		Thread t1 = new Thread(this);
		t1.start();
	}

	@Override
	public void run() {
		Random rand = new Random();
		int count = 0;
		int lpTest = this.lp;
		while(lpTest > 0){
			try {
				synchronized(this){    //////////TODO\\\\\\\\\
				Thread.sleep(timeTS);
				count = count + 1;
				game.moveMonster(this, mVision);
				if(rand.nextInt(5) == 0 && count>= 8){
				//game.monsterDropBomb("nuke",  this);
				Bombs bomb = new Bombs(this.getPosX(), this.getPosY(), game, 5,0,1,1,1);
				count = 0;
				}
				lpTest = this.getLp();
				
			} }catch (InterruptedException e) {
				e.printStackTrace();
			}}
			 if (rand.nextInt(1) == 0){
				//game.newItem(this);
			} 
			//demisableNotifyObserver();
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


	
	
    public Image getImage() {
        return image;
    }
	

	
	
	
}




