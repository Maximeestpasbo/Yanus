package Model;

import java.util.ArrayList;

public abstract class Item extends GameObject implements DemisableObserver, ExplodableObserver, Demisable{
	protected ArrayList<DemisableObserver> observers = new ArrayList<DemisableObserver>();

	protected int count;
	protected Game game;
	
	public Item (int posX, int posY, int count, Game game, int color){
		super(posX, posY, color);
		this.count = count;
		this.game = game;
	}
	
	public void take (){
		game.addInventaireCombat(this);
		game.removeObject(this);
			
	}
	
	public void del (ArrayList objects){
		//objects.add(this);                 ///////\\\\\\\\ changer les ajouts de game par ceux de objects et utiliser les get/set
		game.removeInventaireCombat(this);
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

@Override
public void demisableAttach(DemisableObserver po) {
observers.add(po);		
}

@Override
public void demisableNotifyObserver() {
for (DemisableObserver o : observers) {
o.demise(this, null);
}	
}

@Override
public void exploded(Explodable e) {
BombObject bomb = (BombObject) e;
boolean distanceX = Math.abs(this.getPosX() - bomb.getPosX()) <= bomb.getRange();
boolean distanceY = Math.abs(this.getPosY() - bomb.getPosY()) <= bomb.getRange();

if(distanceX && distanceY){
//this.count = this.count;
}
if(count <= 0){
demisableNotifyObserver();


}
}


@Override
public void demise(Demisable d, ArrayList<GameObject> loot) {
//TODO Auto-generated method stub

}



}
