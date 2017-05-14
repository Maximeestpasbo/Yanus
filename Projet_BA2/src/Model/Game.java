package Model;
import View.Window;
import View.WindowInventaire;
import View.Inventaire;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private ArrayList<GameObject> inventaireCombat = new ArrayList<GameObject>();
	private ArrayList<GameObject> inventaireCombat2 = new ArrayList<GameObject>();
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	
	private Window window;
	private int sizeX = 35;
	private int sizeY = 20;
	private int numberOfBreakableBlocks = 50;
	private int numberOfmBomber = 3;
	private int numberOfmMicrobe = 3;
	private int level = 0;
	
	public Game(Window window){
		this.window = window;

		// Creating one Player at position (1,1)
		objects.add(new Player(10,10,5,6,this.objects));
		objects.add(new Player(15,10,5,6,this.objects));

		weapons.add(new Hammer(10,10,20,this,1,4));
		weapons.add(new Dague(15,10,6,1,this,1,10));

		this.mapInit(level);
		
		
	}

	
	

	 	public void mapInit(int level){
	 		
	 		
	 

	 		//monster building
	 
	 		
	 		Random rand1 = new Random();
	 		for(int i = 0; i < numberOfmBomber; i++){
	 			int x = rand1.nextInt(30) + 2;
	 			int y = rand1.nextInt(15) +2;
	 			mBomber Monster = new mBomber(x,y,this,2,1,0);
	 			//\\Monster.demisableAttach(this);
	 			objects.add(Monster);
	 		}
	 		for(int i = 0; i < numberOfmMicrobe; i++){
	 			int x = rand1.nextInt(30) + 2;
	 			int y = rand1.nextInt(15) +2;
	 			mMicrobe Monster = new mMicrobe(x,y,this,1);
	 			//\\Monster.demisableAttach(this);
	 			objects.add(Monster);
	 		}
	 		
	 
	 
	 		// Map building 
	 		
	 		for(int i = 0; i < sizeX; i++){
	 			objects.add(new BlockUnbreakable(i,0));
	 			objects.add(new BlockUnbreakable(i, sizeY-1));
	 		}
	 	for(int i = 0; i < sizeY; i++){
	 			objects.add(new BlockUnbreakable(0,i));
	 			objects.add(new BlockUnbreakable(sizeX-1, i));
	 		}
	 		Random rand = new Random();
	 		for(int i = 0; i < numberOfBreakableBlocks; i++){
	 			int x = rand.nextInt(30) + 2;
	 			int y = rand.nextInt(15) +2;
	 			BlockBreakable block = new BlockBreakable(x,y);
	 			//\\block.demisableAttach(this);
	 			objects.add(block);
	 		}
	 		
	 		Item item = new Potion(17,10,2,this,7,5);
	 		//\\item.demisableAttach(this);
	 		objects.add(item);
	 		//item de dpart
	 		for (int i =0; i < 6; i++){
	 		//Item item = new Item(20+i,10,2,this);
	 		//item.demisableAttach(this);
	 		//objects.add(item); 
	 		}
	 		
	 		
	 		window.setGameObjects(this.getGameObjects());
	 		notifyView();
	 	
	 	level+=1;
	 	}
	
	
	
	
	
	

	


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// PLAYER
	
	

	
	public void movePlayer(int x, int y, int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		GameObject go = ((Player) objects.get(playerNumber));
		int nextX = player.getPosX()+x;
		int nextY = player.getPosY()+y;
		int nextx = go.getPosX()+x;
		int nexty = go.getPosY()+y;
		player.setDirectionX(x);
		player.setDirectionY(y);
		
		
		boolean obstacle = false;
		try{
			for (int i = 0; i<objects.size(); i++){
				GameObject object = objects.get(i);
			
			if(object.isAtPosition(nextX, nextY)){
			
				if (object instanceof Portal){
					Portal portal = (Portal) object;
					//WindowInventaire wInventaire = new WindowInventaire(this);
			
					portal.newLevel(objects);
					this.level += 1;
					this.mapInit(level);
			
			}}
			
		
			if(object.isAtPosition(nextX, nextY)){
				obstacle = object.isObstacle();
			}
			if(obstacle == true){
				break;
			}/////////////////////
		
		}

		if(obstacle == false){
			player.move(x,y);
			
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MONSTER
	
	synchronized public void moveMonster(Monster one, int mVision){
		



		int nextX = one.getPosX()+one.getX();
		int nextY = one.getPosY()+one.getY();
		//try{
		boolean obstacle = false;
		for (int i = 0; i<objects.size(); i++){
			
			if(i> objects.size()){
			//	throw new IndexOutOfBoundsException("Objects out of Bounds.");
			}
			GameObject object = objects.get(i);
			if(object.isAtPosition(nextX, nextY)){
				if(object instanceof Player){
					Player player = (Player) object;
					player.Hit(1);
					break;
				}
				obstacle = object.isObstacle();
			}
			if(obstacle == true){
				if (mVision == 0){
				break;
				}
				if (mVision ==1){
					mVision = 0;
					one.setX(-one.getX());
					moveMonster(one,mVision);
					
					}
				}}
		
		if(obstacle == false){
			one.move(one.getX(),one.getY());
			
		}//}
		//catch(Exception)
		}
	
	
	
	
	public void newMonster (GameObject one){

		int x = one.getPosX() +1;// ((rand1.nextInt(2))*2-1);
		int y = one.getPosY();
		boolean obstacle = false;
		for (int i = 0; i<objects.size(); i++){
			GameObject object = objects.get(i);
			if(object.isAtPosition(x, y)){
				obstacle = object.isObstacle();
			}
			if(obstacle == true){
				break;
			}}
		
			if(obstacle == false){
				mBomber Monster = new mBomber(x,y,this,1,1,0);
				//\\	Monster.demisableAttach(this);
				objects.add(Monster);
			} 
			
	}
	

	



	
	

	
	

	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//ITEM
	
	public void newItem (GameObject one){

		int x = one.getPosX();  // pose objet là où était le mosntre
		int y = one.getPosY();
		boolean obstacle = false;
		for (int i = 0; i<objects.size(); i++){
			GameObject object = objects.get(i);
			if(object.isAtPosition(x, y)){
				obstacle = object.isObstacle();
			}
			if(obstacle == true){
				break;
			}}
		
			if(obstacle == false){
				Item item = new Potion(x,y,2,this,10, 3);
				//\\item.demisableAttach(this);
				objects.add(item);
			} 
			
	}
	
	public void doTake(int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		int posX = player.getPosX();
		int posY = player.getPosY();
		if(playerNumber==0){
		for (int i =0; i < objects.size(); i++){
			GameObject object = objects.get(i);
			if ((object.getPosX() == posX && object.getPosY() == posY) && object instanceof Item){
				Item item = (Item) object;
				if (inventaireCombat.size() < player.getPlaceInventaire())
				item.take(playerNumber);
			}
			}}
		else{

			for (int i =0; i < objects.size(); i++){
				GameObject object = objects.get(i);
				if ((object.getPosX() == posX && object.getPosY() == posY) && object instanceof Item){
					Item item = (Item) object;
					if (inventaireCombat2.size() < player.getPlaceInventaire())
					item.take(playerNumber);
				}
				}
			}
		}
	
	public void doUse(int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		if(playerNumber==0){
		Item item = ((Item) inventaireCombat.get(0));
		item.setPosX(player.getPosX());
		item.setPosY(player.getPosY());
		item.use(playerNumber);
		if (item.getCount() <= 0){
			inventaireCombat.remove(item);
		} }
		else if( playerNumber ==1){
			Item item = ((Item) inventaireCombat2.get(0));
			item.setPosX(player.getPosX());
			item.setPosY(player.getPosY());
			item.use(playerNumber);
			if (item.getCount() <= 0){
				inventaireCombat2.remove(item);
			}
		}
	}
	
	public void doDel(int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		if(playerNumber==0){
		Item item = ((Item) inventaireCombat.get(0));
		item.setPosX(player.getPosX());
		item.setPosY(player.getPosY());
		item.del(objects,playerNumber);}
		else{
			Item item = ((Item) inventaireCombat2.get(0));
			item.setPosX(player.getPosX());
			item.setPosY(player.getPosY());
			item.del(objects, playerNumber);
		}
		
		
		System.out.println(inventaireCombat.size());
		
	} 
	
	
	public void addInventaireCombat(Item one){
		inventaireCombat.add(one);
	}
	public void addInventaireCombat2(Item one) {
		inventaireCombat2.add(one);
		
	}
	
	public void removeInventaireCombat(Item one){
		inventaireCombat.remove(one);
	}
	public void removeInventaireCombat2(Item one){
		inventaireCombat2.remove(one);
	}
	public ArrayList<GameObject> getInventaireCombat(){
		return this.inventaireCombat;
	}
	
	public void addObjects(GameObject one){
		//synchronized (objects){
		objects.add(one);
		window.setGameObjects(this.getGameObjects());
		//if (one instanceof Item){
		//Item two = (Item) one;
		//\\two.demisableAttach(this);
	//}}
	}
	
	public void removeObject(GameObject one){
		//synchronized (objects){
		objects.remove(one);
		window.setGameObjects(this.getGameObjects());
		//}
	}
	

	
	public void useWeapon(int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		Weapon weapon = ((Weapon) weapons.get(playerNumber));
		int x = player.getDirectionX();
		int y = player.getDirectionY();
		int degats = weapon.getDegats();
		Animation animation = new Animation(9,x,y,5,this,0,0);
		//for (GameObject object : objects){
		for(int i =0; i <objects.size(); i++ ){
			GameObject object = objects.get(i);
			if (object instanceof Living){
				if (weapon.checkPos( x,  y, object)){
					
					weapon.damage((Living)object, degats);
			}}

		
		}
		
	}

	
	
	

	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	
	
	public void trapTime (Trap trap){
		int x = trap.getPosX();
		int y = trap.getPosY();
		int degats = trap.getDegats();
		//for (GameObject object : objects){
		for(int i =0; i <objects.size(); i++ ){
			GameObject object = objects.get(i);
			if (object instanceof Living){
				
				if( trap.checkPos(x,y,object)){
				
					Living living = (Living) object;
					trap.damage(living,degats);
				}
			}
		}
	}
	
	
	
	
	
	public void notifyView(){
		window.update();
	}

	public ArrayList<GameObject> getGameObjects(){
		return this.objects;
	}
	
	public void setGameObjects(ArrayList objects){
		this.objects = objects;
	}
	
		public ArrayList<Weapon> getWeapons(){
		return this.weapons;
	}
	
	public int getSizeX(){
		return this.sizeX;
	}
	public int getSizeY(){
		return this.sizeY;
	}
	
		




	

}
	