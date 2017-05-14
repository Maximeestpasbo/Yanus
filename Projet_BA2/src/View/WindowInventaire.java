package View;
import Model.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class WindowInventaire extends JFrame {
	private Color Brun;
	private Inventaire inventaire;
	public WindowInventaire(Game game){	    
		inventaire  = new Inventaire(game);
	    JFrame window = new JFrame("Inventaire");
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(0, 0, 1900, 1040);

	    window.getContentPane().setBackground(Color.gray);
	    window.getContentPane().add(this.inventaire);
	    this.setLayout(null);

	    //JPanel layout
	    inventaire.setLayout(null);
	    //inventaire.redraw();
	    window.setVisible(true);		
	    
		
	}	

	/* public void setGameObjects(ArrayList<GameObject> objects){
		this.map.setObjects(objects);
		this.map.redraw();
	}
	
	public void update(){
		this.map.redraw();
	}
	
	public void setKeyListener(KeyListener keyboard){
	    this.map.addKeyListener(keyboard);
	}*/
}