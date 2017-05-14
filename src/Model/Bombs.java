package Model;

public class Bombs extends Trap implements Runnable{
	

	
	public Bombs(int posX, int posY, Game game, int color,  int count, int degats, int rangeX, int rangeY){
		
		super(posX,posY,game,color, count, degats, rangeX, rangeY);

		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run(){
		//synchronized(this){ 
		game.addObjects(this);
		while(this.count < 10  ){
			try {
				Thread.sleep(100);
				this.count += 1;
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
		game.trapTime(this);
		for (int i = this.posX-rangeX; i <= this.posX+rangeX; i++){
			for(int j = this.posY-rangeY; j <= this.posY+rangeY; j++){
				//Animation animation = new Animation (3,i,j,3,game,2,2);
			}}
		game.removeObject(this);
	}}
	



		
	//}

