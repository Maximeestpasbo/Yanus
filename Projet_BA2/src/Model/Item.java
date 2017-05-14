package Model;

import java.util.ArrayList;

public abstract class Item extends GameObject {

	protected int count;
	protected Game game;
	
	public Item (int posX, int posY, int count, Game game, int color){
		super(posX, posY, color);
		this.count = count;
		this.game = game;
	}
	
	public void take (int playerNumber){
		if (playerNumber==0){
		game.addInventaireCombat(this);
		}
		else if (playerNumber==1){
			game.addInventaireCombat2(this);
		}
		game.removeObject(this);
		
			
	}
	
	public void del (ArrayList objects, int playerNumber){
		if (playerNumber==0){
		game.removeInventaireCombat(this);
		}
		else if (playerNumber==1){
			game.removeInventaireCombat2(this);
		}
		game.addObjects(this);
	}
	
	
	public void use(int playerNumber){
		game.newItem(this);
		count -= 1;
	}
	
	
	public int getCount(){
		return this.count;
	}
	
	public void setPosX(int posX){
		this.posX = posX;
	}
	
	public void setPosY(int posY){
		this.posY = posY;
	}

////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
@Override
public boolean isObstacle() {
return false;
}	




}
