package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Game;

public class Keyboard implements KeyListener{
	private Game game;
	
	private static final int player1 = 0;
	private static final int player2 = 1;
	
	public Keyboard(Game game){
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		
		switch (key){
			case KeyEvent.VK_RIGHT: 
				game.movePlayer(1, 0, player1);
				System.out.println("PosX =" +game.getGameObjects().get(player1).getPosX());
				break;
			case KeyEvent.VK_LEFT:
				game.movePlayer(-1, 0, player1);
				break;
			case KeyEvent.VK_DOWN:
				game.movePlayer(0, 1, player1);
				break;
			case KeyEvent.VK_UP:
				game.movePlayer(0, -1, player1);
				break;	
			case KeyEvent.VK_C:
				game.doTake(player1);
				break;
			case KeyEvent.VK_X:
				game.doUse(player1);
				break;
			case KeyEvent.VK_D:
				game.doDel(player1);
				break;


				
			case KeyEvent.VK_A:
				game.useWeapon(player1);
				break;
				
				
			case KeyEvent.VK_M: 
				game.movePlayer(1, 0, player2);
				break;
			case KeyEvent.VK_K:
				game.movePlayer(-1, 0, player2);
				break;
			case KeyEvent.VK_L:
				game.movePlayer(0, 1, player2);
				break;
			case KeyEvent.VK_O:
				game.movePlayer(0, -1, player2);
				break;	
				
			case KeyEvent.VK_T:
				game.useWeapon(player2);
				break;
			case KeyEvent.VK_H:
				game.doTake(player2);
				break;
			case KeyEvent.VK_G:
				game.doUse(player2);
				break;
			case KeyEvent.VK_F:
				game.doDel(player2);
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
