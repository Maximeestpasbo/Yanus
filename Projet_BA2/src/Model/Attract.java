package Model;

public class Attract implements Runnable {
	private Living living;
	private int x;
	private int y;
	private Game game;
	private int posX;
	private int posY;

	public Attract(int posX, int posY,Living living, int degats, Game game){
		this.game = game;
		this.living = living;
		
		this.posX = posX;
		this.posY = posY;
		if (degats == 8){
			this.x = 0;
			this.y = -1;
		}
		if (degats == 5){
			this.x = 0;
			this.y = 1;
		}
		if (degats == 6){
			this.x = 1;
			this.y = 0;
		}
		if (degats == 4){
			this.x = -1;
			this.y = 0;
		}
		Thread thread = new Thread(this);
		thread.start();
	}
	
	
	@Override
	public void run(){
		boolean obstacle = false;
		
		while(!obstacle && !(living.isAtPosition(posX,posY))){
			System.out.println(living.isAtPosition(posX, posY));

			try{
				Thread.sleep(50);
				
				for(GameObject object : game.getGameObjects()){
					if(object.isAtPosition(living.getPosX()+x, living.getPosY()+y)){
						obstacle = object.isObstacle();
					}
				
			}
				if(obstacle == false){
					living.move(x,y);
					
				}
				
		}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	}}
}
