package Model;
import java.util.Timer;
import Model.Game;


public class Dague extends Weapon implements Damage{
	private int degat;
	public int itération;
	public GameObject go;
	public Living living;
	public Game game;
	
	
	public Dague(int posX, int posY, int iteration , int degats, Game g, int color, int count){
		super(posX,posY, count, g, color, degats);
		this.game= g;
		this.itération = iteration;


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