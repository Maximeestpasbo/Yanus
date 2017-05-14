package Model;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Bombs extends Trap implements Runnable{
	
	private Image image;
	
	public Bombs(int posX, int posY, Game game, int color,  int count, int degats, int rangeX, int rangeY){
		
		super(posX,posY,game,13, count, degats, rangeX, rangeY);
        ImageIcon ii = new ImageIcon("D:/Users/Maxime/Pictures/Bomb01.png");
        image = ii.getImage();

		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run(){
		//synchronized(this){ 
		game.addObjects(this);
		while(this.count < 10  ){
			try {
				Thread.sleep(200);
				this.count += 1;
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
		game.trapTime(this);
		//for (int i = this.posX-rangeX; i <= this.posX+rangeX; i++){
		//	for(int j = this.posY-rangeY; j <= this.posY+rangeY; j++){
				
				Animation animation = new Animation (3,this.getPosX(),this.getPosY(),3,game,0,0);
				
			//}}
		game.removeObject(this);
	}

	public Image getImage() {
		return this.image;
	}
	
	}
	



		
	//}

