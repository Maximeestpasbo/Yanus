package Model;

import java.util.ArrayList;

import java.awt.Image;
import javax.swing.ImageIcon;

public class BlockBreakable extends Block {


	private Image image;
	public BlockBreakable(int X, int Y) {
		super(X, Y, 15);
		ImageIcon ii = new ImageIcon("D:/Users/Maxime/Pictures/BlockUnbreackable01.png");
        image = ii.getImage();
	}



	@Override
	public boolean isObstacle() {
		return true;
	}
	public Image getImage() {
		return this.image;
	}
	
}
