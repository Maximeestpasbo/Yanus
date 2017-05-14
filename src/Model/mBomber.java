package Model;
import java.util.ArrayList;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.Random;

public class mBomber extends Monster {
	private ArrayList<DemisableObserver> observers = new ArrayList<DemisableObserver>();
	private static int mVision = 1;
	private static int x = 1;
	private static int y = 0;
	private Image image;

	public mBomber(int posX, int posY, Game game,  int lp) {
		super(posX, posY,x,y, 4, game, mVision, lp);
		
        ImageIcon ii = new ImageIcon("images/Bloom.png");
        image = ii.getImage();
		
		
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
		boolean running = true;
		while(lpTest > 0){
			try {
				synchronized(this){    //////////TODO\\\\\\\\\
				Thread.sleep(this.timeTS);
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
				game.newItem(this);
			} 
			//demisableNotifyObserver();
			game.disappear(this);
			if(this.getLp() <= 0){
				boolean test = true;
				for (GameObject object : game.getGameObjects()){
					if (object instanceof Monster){
						test = false;
						System.out.println(object);
					}
				}
				if (test){
					
					Portal portal = new Portal(game.getSizeX(), game.getSizeY());
					game.addObjects(portal);
			}
			}
	}

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

	
	
    public Image getImage() {
        return image;
    }
	

	
	
	
}




