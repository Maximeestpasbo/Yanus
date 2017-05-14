package Model;

import java.util.ArrayList;

public class Portal extends GameObject{
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Portal (int sizeX, int sizeY){
		super(11, 10, 4);

	}
	
	synchronized public void newLevel(ArrayList <GameObject> objects){
		synchronized(objects){
			if (objects.get(0) instanceof DeadPlayer){
				players.add(new Player(10,10,3,1, objects));
			}
			else{
			players.add((Player) objects.get(0)); 
			Player player = players.get(0);
			player.setPosX(10);
			player.setPosY(10);
			}
			if (objects.get(1) instanceof DeadPlayer){
				players.add(new Player(15,10,3,1, objects));
			}
			else{
			GameObject go = objects.get(1);
			if(go instanceof Player){
			players.add((Player) go);
			Player player2 = players.get(1);
			player2.setPosX(15);
			player2.setPosY(10);
			}}
			objects.removeAll(objects);
			objects.add(players.get(0));
			objects.add(players.get(1));
			
			
			
			
			
			/*
			for (int i =0; i < objects.size(); i++){
			GameObject object = objects.get(i);
			if (!(object instanceof Player)){
				objects.remove(object);
			}
		} */ } 
	}

	@Override
	public boolean isObstacle() {
	return false;
	}	
}
