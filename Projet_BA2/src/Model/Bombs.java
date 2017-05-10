package Model;

public class Bombs extends Trap implements Runnable{
	

	
	public Bombs(int posX, int posY, Game game, int color,  int count, int degats, int rangeX, int rangeY){
		
		super(posX,posY,game,color, count, degats, rangeX, rangeY);

		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run(){
		
		game.addObjects(this);
		while(count < 10  ){
			try {
				Thread.sleep(100);
				count += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
		game.trapTime(this);
		Animation animation = new Animation (9,super.posX,super.posY,2,game,2,2);
		game.removeObject(this);
	}
	



		
	}

