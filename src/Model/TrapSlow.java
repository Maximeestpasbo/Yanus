package Model;

public class TrapSlow extends Trap implements Runnable{
	
	private int slowTime;
	private int duree;
	private int dureeSlow;

	public TrapSlow(int posX, int posY, Game game, int color, int count, int slowTime, int rangeX, int rangeY, int duree, int dureeSlow) {
		super(posX, posY, game, color, count, 0, rangeX, rangeY);
		this.duree = duree;
		this.dureeSlow = dureeSlow;
		this.slowTime = slowTime;
	
	}






	
	
	public void use(int playerNumber){
		
		
		Thread t1 = new Thread(this);
		t1.start();
		
		/*for(int i =0; i<game.getGameObjects().size(); i++){
		if (this.checkPos(getPosX(), getPosY(), go )){
			System.out.print("chekpos ok");
			if (go instanceof Living){
				System.out.print("living ok");
				
				Living living = (Living) go;
				((Living) go).setTimeTS(slowTime);
				
			
				
			}
			}
			}*/
		}
	
	
	

	@Override
	public void run() {
		
		game.addObjects(this);
		int count01 = 0;

		
		while(count01 < duree){
			try{
				count01 = count01 +1 ;
				Thread.sleep(100);
				
		for(int i =0; i<game.getGameObjects().size(); i++){
			GameObject go = game.getGameObjects().get(i);
			if (this.checkPos(posX, posY, go)){
				
				if(go instanceof Living){
					
					Slow slow = new Slow(dureeSlow,slowTime, (Living) go, 0);
				}
			}
			
			}
		
		}
			catch(Exception e){
			}
			}
		game.removeObject(this);
		}
		

			
	
	@Override
	public boolean checkPos(int x, int y, GameObject gameObject){
		boolean so =false;
		boolean distanceX = Math.abs(x - gameObject.getPosX()) == 0 ;
		boolean distanceY = Math.abs(y - gameObject.getPosY()) == 0 ;

		if(distanceX && distanceY){
			so = true;	
		}
		return so;

	}
	}



