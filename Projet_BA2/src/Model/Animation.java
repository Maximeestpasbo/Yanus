package Model;

public class Animation extends GameObject implements Runnable{

	private int count;
	private Game game;

	public Animation(int color, int x, int y, int count, Game game, int rangeX, int rangeY){
		super(x,y,color);
		this.count = count;
		this.game = game;
		for (int i = x-rangeX; i <= x+rangeX; i++){
			for(int j = y-rangeY; j <= y+rangeY; j++){
				Thread thread = new Thread(this);
				thread.start();
	}}}
	
	@Override
	public void run(){
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
		}
	
	@Override
	public boolean isObstacle(){
		return false;
	}
}
