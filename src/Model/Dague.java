package Model;
import java.util.Timer;
import Model.Game;


public class Dague extends Weapon implements Damage{
	private int degat;
	public int itération;
	public GameObject go;
	public int color;
	public Living living;
	public Game game;
	
	
	public Dague(int posX, int posY, int iteration , int degat, Game g, int color){
		super(posX, posY, iteration, g, degat, color);
		
		this.degat = degat;
		this.game= g;
		this.itération = iteration;
		this.color = color;
		}
	
	public void damage(Living living, int degats){
		DPS dps = new DPS(itération, degats, living,0);
		//System.out.println("lp =="+ living.getLp());
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
