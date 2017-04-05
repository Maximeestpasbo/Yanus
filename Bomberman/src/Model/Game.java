package Model;
import View.Window;

import java.util.ArrayList;
import java.util.Random;

public class Game implements DemisableObserver{
	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	private Window window;
	private int sizeX = 35;
	private int sizeY = 20;
	private int bombTimer = 3000;
	private int numberOfBreakableBlocks = 90;
	private int numberOfmBomber = 9;
	private int numberOfmMicrobe = 3;
	
	public Game(Window window){
		this.window = window;

		// Creating one Player at position (1,1)
		objects.add(new Player(10,10,3,5));
		objects.add(new Player(15,10,3,5));


		
		
		//monster building
		Random rand1 = new Random();
		for(int i = 0; i < numberOfmBomber; i++){
			int x = rand1.nextInt(31) + 2;
			int y = rand1.nextInt(16) +2;
			mBomber Monster = new mBomber(x,y,this,2);
			Monster.demisableAttach(this);
			objects.add(Monster);
		}
		for(int i = 0; i < numberOfmMicrobe; i++){
			int x = rand1.nextInt(31) + 2;
			int y = rand1.nextInt(16) +2;
			mMicrobe Monster = new mMicrobe(x,y,this,1);
			Monster.demisableAttach(this);
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
			int x = rand.nextInt(31) + 2;
			int y = rand.nextInt(16) +2;
			BlockBreakable block = new BlockBreakable(x,y);
			block.demisableAttach(this);
			objects.add(block);
		}
		
		window.setGameObjects(this.getGameObjects());
		notifyView();
	}


	
	public void dropBomb(String bombType, int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		
		BombObject bombDropped = player.dropBomb(bombType);
		if(bombDropped != null){
			bombDropped.demisableAttach(this);
			for(GameObject object : objects){
				if(object instanceof Explodable){
					((BombObject) object).explodableAttach(((ExplodableObserver) bombDropped));
				}
				if(object instanceof ExplodableObserver){
					bombDropped.explodableAttach(((ExplodableObserver) object));
				}
			}
			objects.add(bombDropped);
			notifyView();
		}
	}
	
	public void movePlayer(int x, int y, int playerNumber){
		Player player = ((Player) objects.get(playerNumber));
		int nextX = player.getPosX()+x;
		int nextY = player.getPosY()+y;
		
		boolean obstacle = false;
		for(GameObject object : objects){
			if(object.isAtPosition(nextX, nextY)){
				obstacle = object.isObstacle();
			}
			if(obstacle == true){
				break;
			}
		}
		
		if(obstacle == false){
			player.move(x,y);
			notifyView();
		}
	}

	
	public void moveMonster( Monster one, int mVision){
		//Monster Monster = ((Monster) objects.get(monsterNumber));
		Monster Monster = one;



		int nextX = Monster.getPosX()+Monster.getX();
		int nextY = Monster.getPosY()+Monster.getY();
		
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
					Monster.setX(-Monster.x);
					moveMonster(Monster,mVision);
					
					
				}
			}
		}
		
		if(obstacle == false){
			Monster.move(Monster.x,Monster.y);
			
		} notifyView();
	}
	
	public void newMonster (Monster one){
		Random rand1 = new Random();

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
				mMicrobe Monster = new mMicrobe(x,y,this,1);
				Monster.demisableAttach(this);
				objects.add(Monster);
			} notifyView();
			
	}
	
	public void monsterDropBomb(String bombType, Monster one){
		//mBomber Monster = ((mBomber) objects.get(monsterNumber));
		mBomber Monster = (mBomber) one;

		BombObject bombDropped = Monster.dropBomb(bombType);
		if(bombDropped != null){
			bombDropped.demisableAttach(this);
			for(GameObject object : objects){
				if(object instanceof Explodable){
					((BombObject) object).explodableAttach(((ExplodableObserver) bombDropped));
				}
				if(object instanceof ExplodableObserver){
					bombDropped.explodableAttach(((ExplodableObserver) object));
				}
			}
			objects.add(bombDropped);
			notifyView();
		}}
	
	
	
	private void notifyView(){
		window.update();
	}

	public ArrayList<GameObject> getGameObjects(){
		return this.objects;
	}
	
	@Override
	synchronized public void demise(Demisable ps, ArrayList<GameObject> loot) {
		objects.remove(ps);
		if(loot != null){
			objects.addAll(loot);
		}
		notifyView();
	}	

}
	
