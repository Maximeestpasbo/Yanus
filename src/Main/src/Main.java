package Main.src;
import Controller.Keyboard;
import Model.Game;
import View.Window;
import View.Viewer;

public class Main {
	public static void main(String[] args) {
		Window window = new Window();
		Viewer viewer = new Viewer(window);
		
		Game game = new Game(window);
		Keyboard keyboard = new Keyboard(game);
		window.setKeyListener(keyboard);
	}
}
