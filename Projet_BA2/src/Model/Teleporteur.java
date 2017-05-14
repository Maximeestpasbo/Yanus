package Model;
import java.util.ArrayList;
import java.util.Random;
import Model.Player;

public class Teleporteur extends Trap implements CheckPos,  Runnable {

	public int postfiy = 2;
	public int postfix = 10;
	private static int color = 10;

	
	public Teleporteur(int x, int y, Game g, int count) {
		
		//super(postx, posty, 0 , g , 1); ça ne marche pas du coup je crée un new constructeur dans Item
		super(x, y, g, color, 2, 0, 0, 0);
		Thread t1 = new Thread(this);
		t1.start();
		
	}
	
	public void teleporteur(){
		//System.out.println("premier -1");
		boolean test = false;
		int x = this.getPosX();
		int y = this.getPosY();
		int numberPlayer;
		//while (test==false){
			for (GameObject go : game.getGameObjects()){
			//System.out.println("premier");
			if (go instanceof Player){
				Player player = (Player) go;
				//objects = game.getGameObjects();
				//numberPlayer = objects.indexOf(player);
				//System.out.println("second");
				if(checkPos(x,y,go)){
			
					//System.out.println("3");
					boolean essai = true ;
					while (essai == true){
						//System.out.println("4");
						Random rand = new Random();
						x = rand.nextInt(7);
						y = rand.nextInt(7);
						essai = this.checkPos(x, y, go);
					}
							//Player player = (Player) objects.get(numberPlayer);
							//System.out.println("5");
							player.move(x, y);
							this.count -=1;
			}
				else{
					
				}}
			else{
				
			}
			}}
					
					
				
			
			
		
		
	
	
	
@Override
	public void run(){
		//System.out.println("run1");
		
		while(count>0){
			try {
				//System.out.println("run2");
				Thread.sleep(100);
				
				this.teleporteur();
			
				}
				
		catch (InterruptedException e) {
			e.printStackTrace();
		
		}
				
	}
		game.removeObject(this);

	}
}



