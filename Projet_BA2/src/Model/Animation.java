package Model;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Animation extends GameObject implements Runnable{
	private Image image;
	private int count;
	private Game game;

	public Animation(int color, int x, int y, int count, Game game, int rangeX, int rangeY){
		super(x,y,14);
        ImageIcon ii = new ImageIcon("D:/Users/Maxime/Pictures/explo03.png");
        image = ii.getImage();
		this.count = count;
		this.game = game;
		//for (int i = x-rangeX; i <= x+rangeX; i++){
			//for(int j = y-rangeY; j <= y+rangeY; j++){
					//this.posX = i;
					//this.posY = j;
				//System.out.println(this.getPosX());
				Thread thread = new Thread(this);
				thread.start();
	}//}}
	
	@Override
	 public void run(){
		//synchronized(this){ 
		game.addObjects(this);

		while(count > 0){
			try {
				Thread.sleep(100);
				count = count -1;
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
		game.removeObject(this);
		}//}
	
	@Override
	public boolean isObstacle(){
		return false;
	}
	
	public Image getImage() {
		return this.image;
	}
}
