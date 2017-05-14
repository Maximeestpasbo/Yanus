package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class BlockUnbreakable extends Block{
	private Image image;
	
	public BlockUnbreakable(int X, int Y) {
		super(X, Y, 16);
		ImageIcon ii = new ImageIcon("D:/Users/Maxime/Pictures/BlockBreakable01.png");
        image = ii.getImage();
	}
	public Image getImage() {
		return this.image;
	}

	@Override
	public boolean isObstacle() {
		return true;
	}
}
