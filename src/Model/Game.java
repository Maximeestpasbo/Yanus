package Model;
import View.Window;

import java.util.ArrayList;
import java.util.Random;

public class Game implements Disappear{//implements DemisableObserver{
	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private ArrayList<GameObject> inventaireCombat = new ArrayList<GameObject>();
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	
	private Window window;
	private int sizeX = 11;
	private int sizeY = 12;
	private int numberOfBreakableBlocks = 5;
	private int numberOfmBomber = 1;
	private int numberOfmMicrobe = 0;
	private int level = 1;
	
	public Game(Window window){
		this.window = window;

		// Creating one Player at position (1,1)
		objects.add(new Player(5,5,3,8));
		objects.add(new Player(15,10,3,5));
		objects.add(new TrapSlow(1, 2,this, 5, 100, 1000, 0, 0, 100, 6));
		//weapons.add(new Fleche(1,1,5, 1, 3, this, 5 ));
		//objects.add(new Potion(1,2,3,this,7,20));

		//weapons.add(new Hammer(1,4));
		//weapons.add(new Dague(3,5, this, 3));
		
		System.out.println(weapons);

		this.mapInit(level);
		
		
	}

	
	
	public void mapInit(int level){
		
		

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 	 MAP LEVEL 5  Boss
		
		if(level%5 == 0){
		//monster building

			numberOfBreakableBlocks = 0;
			 numberOfmBomber = 15;
			 numberOfmMicrobe = 15;
			 
				Random rand1 = new Random();
				for(int i = 0; i < numberOfmBomber; i++){
					int x = rand1.nextInt(9) + 2;
					int y = rand1.nextInt(9) +2;
					mBomber Monster = new mBomber(x,y,this,2);
					//\\Monster.demisableAttach(this);
					objects.add(Monster);
				}
				for(int i = 0; i < numberOfmMicrobe; i++){
					int x = rand1.nextInt(9) + 2;
					int y = rand1.nextInt(9) +2;
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
					int x = rand.nextInt(9) + 2;
					int y = rand.nextInt(9) +2;
					BlockBreakable block = new BlockBreakable(x,y);
					//\\block.demisableAttach(this);
					objects.add(block);
				}
				
				Item item = new iSlow(17,10,2,this, 10, 5, 0,1000,5);
				//\\item.demisableAttach(this);
				objects.add(item);
				//item de d�part
				for (int i =0; i < 6; i++){
				//Item item = new Item(20+i,10,2,this);
				//item.demisableAttach(this);
				//objects.add(item); 
				}
				
				
				window.setGameObjects(this.getGameObjects());
				notifyView();
				}
	
	

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MAP 4
		
		
		
		
		
		
		
	if(level%5 == 4){
		//monster building
		

		numberOfBreakableBlocks = 120;
		 numberOfmBomber = 15;
		 numberOfmMicrobe = 15;
		Random rand1 = new Random();
		for(int i = 0; i < numberOfmBomber; i++){
			int x = rand1.nextInt(9) + 2;
			int y = rand1.nextInt(25) +2;
			mBomber Monster = new mBomber(x,y,this,2);
			//\\Monster.demisableAttach(this);
			objects.add(Monster);
		}
		for(int i = 0; i < numberOfmMicrobe; i++){
			int x = rand1.nextInt(9) + 2;
			int y = rand1.nextInt(29) +2;
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
			//objects.add(new BlockUnbreakable(sizeX-1, i));
		}
		Random rand = new Random();
		for(int i = 0; i < numberOfBreakableBlocks; i++){
			int x = rand.nextInt(12) + 2;
			int y = rand.nextInt(25) +2;
			BlockBreakable block = new BlockBreakable(x,y);
			//\\block.demisableAttach(this);
			objects.add(block);
		}
		
		Item item = new iSlow(17,10,2,this, 10, 5, 0,1000,5);
		//\\item.demisableAttach(this);
		objects.add(item);
		//item de d�part
		for (int i =0; i < 6; i++){
		//Item item = new Item(20+i,10,2,this);
		//item.demisableAttach(this);
		//objects.add(item); 
		}
		
		
		window.setGameObjects(this.getGameObjects());
		notifyView();
		}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MAP 3
	
	
	if (level%5 ==3){
		numberOfmBomber= 7;
		numberOfmMicrobe = 7;

		numberOfBreakableBlocks = 5;
	
	
	//monster building
	Random rand1 = new Random();
	for(int i = 0; i < numberOfmBomber; i++){
		int x = rand1.nextInt(9) + 2;
		int y = rand1.nextInt(25) +2;
		mBomber Monster = new mBomber(x,y,this,2);
		//\\Monster.demisableAttach(this);
		objects.add(Monster);
	}
	for(int i = 0; i < numberOfmMicrobe; i++){
		int x = rand1.nextInt(9) + 2;
		int y = rand1.nextInt(25) +2;
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
		//objects.add(new BlockUnbreakable(0,i));
		objects.add(new BlockUnbreakable(sizeX-1, i));
	}
	Random rand = new Random();
	for(int i = 0; i < numberOfBreakableBlocks; i++){
		int x = rand.nextInt(9) + 2;
		int y = rand.nextInt(28) +2;
		BlockBreakable block = new BlockBreakable(x,y);
		//\\block.demisableAttach(this);
		objects.add(block);
	}
	
	Item item = new iSlow(17,10,2,this, 10, 5, 0,1000,5);
	//\\item.demisableAttach(this);
	objects.add(item);
	//item de d�part
	for (int i =0; i < 6; i++){
	//Item item = new Item(20+i,10,2,this);
	//item.demisableAttach(this);
	//objects.add(item); 
	}
	
	
	window.setGameObjects(this.getGameObjects());
	notifyView();
	}
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MAP 2
	
	
	
	
	
	if (level%5 == 2){
		//monster building
		numberOfmBomber= 3;
		numberOfmMicrobe = 4;

		 numberOfBreakableBlocks = 17;
		
		Random rand1 = new Random();
		for(int i = 0; i < numberOfmBomber; i++){
			int x = rand1.nextInt(12) + 2;
			int y = rand1.nextInt(12) +2;
			mBomber Monster = new mBomber(x,y,this,2);
			//\\Monster.demisableAttach(this);
			objects.add(Monster);
		}
		for(int i = 0; i < numberOfmMicrobe; i++){
			int x = rand1.nextInt(12) + 2;
			int y = rand1.nextInt(12) +2;
			mMicrobe Monster = new mMicrobe(x,y,this,1);
			//\\Monster.demisableAttach(this);
			objects.add(Monster);
		}
		


		// Map building 
		
		for(int i = 0; i < sizeX; i++){
			objects.add(new BlockUnbreakable(i,0));
			//objects.add(new BlockUnbreakable(i, sizeY-1));
		}
		for(int i = 0; i < sizeY; i++){
			objects.add(new BlockUnbreakable(0,i));
			objects.add(new BlockUnbreakable(sizeX-1, i));
		}
		Random rand = new Random();
		for(int i = 0; i < numberOfBreakableBlocks; i++){
			int x = rand.nextInt(12) + 2;
			int y = rand.nextInt(12) +2;
			BlockBreakable block = new BlockBreakable(x,y);
			//\\block.demisableAttach(this);
			objects.add(block);
		}
		
		Item item = new iSlow(17,10,2,this, 10, 5, 0,1000,5);
		//\\item.demisableAttach(this);
		objects.add(item);
		//item de d�part
		for (int i =0; i < 6; i++){
		//Item item = new Item(20+i,10,2,this);
		//item.demisableAttach(this);
		//objects.add(item); 
		}
		
		
		window.setGameObjects(this.getGameObjects());
		notifyView();
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MAP 1
	
	if (level%5 == 1){
		//monster building
		numberOfmBomber= 2;
		numberOfmMicrobe = 0;

		numberOfBreakableBlocks = 0;

		
		Random rand1 = new Random();
		for(int i = 0; i < numberOfmBomber; i++){
			int x = rand1.nextInt(7) + 2;
			int y = rand1.nextInt(7) +2;
			mBomber Monster = new mBomber(x,y,this,2);
			//\\Monster.demisableAttach(this);
			objects.add(Monster);
		}
		for(int i = 0; i < numberOfmMicrobe; i++){
			int x = rand1.nextInt(7) + 2;
			int y = rand1.nextInt(7) +2;
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
			int x = rand.nextInt(7) + 2;
			int y = rand.nextInt(7) +2;
			BlockBreakable block = new BlockBreakable(x,y);
			//\\block.demisableAttach(this);
			objects.add(block);
		}
		
		Item item = new iSlow(17,10,2,this, 10, 5, 0,1000,5);
		//\\item.demisableAttach(this);
		objects.add(item);
		//item de d�part
		for (int i =0; i < 6; i++){
		//Item item = new Item(20+i,10,2,this);
		//item.demisableAttach(this);
		//objects.add(item); 
		}
		
		
		window.setGameObjects(this.getGameObjects());
		notifyView();
	}
	level+=1;
	}
	
	
	
	
	
	
	
	
	
	

	


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// PLAYER
	
	
	public void dropBomb(String bombType, int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		BombObject bombDropped = player.dropBomb(bombType);
		if(bombDropped != null){
			//\\bombDropped.demisableAttach(this);
			for(GameObject object : objects){
				if(object instanceof Explodable  && !(object instanceof iSlow)){
					((BombObject) object).explodableAttach(((ExplodableObserver) bombDropped));
				}
				if(object instanceof ExplodableObserver && !(object instanceof iSlow)){
					bombDropped.explodableAttach(((ExplodableObserver) object));  //enl�ve les objets touch�s par l'explosion
				}
			}
			objects.add(bombDropped);
			notifyView();
		}
	}
	
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
		for(GameObject object : objects){
			
			
			if(object.isAtPosition(nextX, nextY)){
			
				if (object instanceof Portal){
					Portal portal = (Portal) object;
			
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
			notifyView();
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
		
		boolean obstacle = false;
		for(GameObject object : objects){
			if(object.isAtPosition(nextX, nextY)){
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
			}
		}
		
		if(obstacle == false){
			one.move(one.getX(),one.getY());
			
		} }
	
	
	
	
	public void newMonster (GameObject one){

		int x = one.getPosX() +1;// ((rand1.nextInt(2))*2-1);
		int y = one.getPosY();
		boolean obstacle = false;
		for(GameObject object : objects){
			if(object.isAtPosition(x, y)){
				obstacle = object.isObstacle();
			}
			if(obstacle == true){
				break;
			}}
		
			if(obstacle == false){
				mBomber Monster = new mBomber(x,y,this,1);
				//\\	Monster.demisableAttach(this);
				objects.add(Monster);
			} notifyView();
			
	}
	

	
	public void monsterDropBomb(String bombType, Monster one){
		mBomber monster = (mBomber) one;

		BombObject bombDropped = monster.dropBomb(bombType);
		if(bombDropped != null){
			//bombDropped.demisableAttach(this);
			disappear(bombDropped);
			for(GameObject object : objects){
				if(object instanceof Explodable && !(object instanceof iSlow)){
					((BombObject) object).explodableAttach(((ExplodableObserver) bombDropped));
				}
				if(object instanceof ExplodableObserver && !(object instanceof iSlow)){
					bombDropped.explodableAttach(((ExplodableObserver) object));
				}
			}
			objects.add(bombDropped);  //affiche la bombe
		}}


	
	

	
	

	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//ITEM
	
	public void newItem (GameObject one){

		int x = one.getPosX();  // pose objet l� o� �tait le mosntre
		int y = one.getPosY();
		boolean obstacle = false;
		for(GameObject object : objects){
			if(object.isAtPosition(x, y)){
				obstacle = object.isObstacle();
			}
			if(obstacle == true){
				break;
			}}
		
			if(obstacle == false){
				Item item = new iSlow(x,y,3,this, 10000, 5, 0,200,5);
				//\\item.demisableAttach(this);
				objects.add(item);
			} notifyView();
			
	}
	
	public void doTake(int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		int posX = player.getPosX();
		int posY = player.getPosY();
		for (GameObject object : objects){
			if ((object.getPosX() == posX && object.getPosY() == posY) && object instanceof Item){
				Item item = (Item) object;
				if (inventaireCombat.size() < player.getPlaceInventaire())
				item.take();
			}
			}}
	
	public void doUse(int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		Item item = ((Item) inventaireCombat.get(0));
		item.setPosX(player.getPosX());
		item.setPosY(player.getPosY());
		item.use(playerNumber);
		if (item.getCount() <= 0){
			inventaireCombat.remove(item);
		} notifyView();
	}
	
	public void doDel(int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		Item item = ((Item) inventaireCombat.get(0));
		item.setPosX(player.getPosX());
		item.setPosY(player.getPosY());
		item.del(objects);
		System.out.println(inventaireCombat.size());
		notifyView();
	} 
	
	
	public void addInventaireCombat(Item one){
		inventaireCombat.add(one);
	}
	
	public void removeInventaireCombat(Item one){
		inventaireCombat.remove(one);
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
		weapon.setPosX(player.getPosX());
		weapon.setPosY(player.getPosY());
		int x = player.getDirectionX();
		int y = player.getDirectionY();
		
		int degats = weapon.getDegats();
		if (weapon instanceof Fleche){
			Fleche fleche = (Fleche) weapon;
			fleche.newThread(x, y);
			System.out.println("newThread");
			//System.out.println("fin");
			}
		else{
			Animation animation = new Animation(3,x,y,2,this,0,0);
		//for (GameObject object : objects){
			for(int i =0; i <objects.size(); i++ ){
				GameObject object = objects.get(i);
				if (object instanceof Living){
					if (weapon.checkPos( x,  y, object)){
					
						weapon.damage((Living)object, degats);
			}}}

		
		}
		
	}

	
	
	

	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void checkPos (iSlow one){
		boolean test = false;
		if (one.getDetonated() == false){
		for(GameObject object : objects){
			
			if(object instanceof Monster){

			boolean distanceX = Math.abs(object.getPosX() - one.getPosX()) == 0;
			boolean distanceY = Math.abs(object.getPosY() - one.getPosY()) == 0;
			if(distanceX && distanceY){
				test = true;
				//one.setDetonated(true);
				}}
		}}
		
		else if (one.getDetonated() == true){
			for(GameObject object : objects){

				boolean distanceX = Math.abs(object.getPosX() - one.getPosX()) == 0;
				boolean distanceY = Math.abs(object.getPosY() - one.getPosY()) == 0;
				if(distanceX && distanceY){
					if(object instanceof Living){
						one.explodableAttach((ExplodableObserver) object);
					}
					}}
			}
		one.setDetonated(test);}
	
	
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
	
		
	@Override
	synchronized public void disappear (GameObject gameObject){
		
		objects.remove(gameObject);
		
	}
	
	//@Override
	//synchronized public void demise(Demisable ps, ArrayList<GameObject> loot) {
		//objects.remove(ps);
		//if(loot != null){
			//objects.addAll(loot);
		//}
		//notifyView();
	//}	

}
	