package Model;

import javax.swing.ImageIcon;

public class DeadPlayer extends GameObject{
	public DeadPlayer(int posX, int posY){
		super(posX,posY,11);
	}

	@Override
	public boolean isObstacle() {
		return false;
	}

}
