package Model;
import java.util.Timer;
import Model.Game;


public class Dague extends Weapon implements Runnable, Damage{
	private int degat;
	public int itération;
	public GameObject go;
	public int color;
	public Living living;
	public Game game;
	
	
	public Dague(int iteration , int degat, Game g, int color){
		super(iteration, degat);
		this.degat = degat;
		this.game= g;
		this.itération = iteration;
		this.color = color;
		Thread t1 = new Thread(this);
		t1.start();

		}
	public void damage(Living living, int degats){
		DPS dps = new DPS(itération, degats, living,0);
		//System.out.println("lp =="+ living.getLp());
	}

	
	
	@Override
		public void run() {
			int count = 0;
			
			while (count < itération){
			
			this.damage(living, degat);
			count += 1;
			System.out.println(" run dague /// count == "+ count);
			try {
				Thread.sleep(1000);
				count = count + 1;
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			//game.removeObject(this);
	}

	}
	@Override
	public boolean checkPos(int x, int y, GameObject go2) {
		boolean so =false;
		boolean distanceX = x - go2.getPosX() == 0 ;
		boolean distanceY = y - go2.getPosY() == 0 ;

		if(distanceX && distanceY){
			so = true;	
		}
		return so;

	} }
