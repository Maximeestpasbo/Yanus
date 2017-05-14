package View;
import Model.GameObject;
import Model.mBomber;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;


public class Map extends JPanel {
	private ArrayList<GameObject> objects;
	
	public Map(){
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	 public void paint(Graphics g) { 
		 synchronized(objects){
			 doDrawing(g);
		for(int i = 0; i<25; i++){							// Vire la valeur 20 et parametrer ca
			for(int j = 0; j<15; j++){
				int x = i;
				int y = j;
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(x*50, y*50, 48, 48); 
				g.setColor(Color.BLACK);
				g.drawRect(x*50, y*50, 48, 48); 
			}
		}
		
		//for(GameObject object : this.objects){
		for(int i =0; i <objects.size(); i++ ){
			GameObject object = objects.get(i);
			int x = object.getPosX();
			int y = object.getPosY();
			int color = object.getColor();			
			
			if(color == 0){
				g.setColor(Color.DARK_GRAY);
			}else if(color == 1){
				g.setColor(Color.GRAY);
			}else if(color == 2){
				g.setColor(Color.BLUE);
			}else if(color == 3){
				g.setColor(Color.GREEN);
			}else if(color == 4){
				g.setColor(Color.RED);
			}else if(color == 5){
				g.setColor(Color.ORANGE);
			}else if(color == 6){
				g.setColor(Color.BLACK);
			}else if(color == 7){
				g.setColor(Color.PINK);
			}

			g.fillRect(x*50, y*50, 48, 48);
			g.setColor(Color.BLACK);
			g.drawRect(x*50, y*50, 48, 48); 
			
			if(color == 8){
				g.setColor(Color.BLUE);
				g.fillRect(x*50, y*50-50, 48, 148);
			}
		}}
	}
	
	public void setObjects(ArrayList<GameObject> objects){
		this.objects = objects;
	}
	
	
    private void doDrawing(Graphics g) {
    	for(int i = 0; i<objects.size(); i++){
    		GameObject object = objects.get(i);
        if (object instanceof mBomber){
        	mBomber go = (mBomber) object;
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(go.getImage(), go.getX(), go.getY(), this);        
    }}}
	
	public void redraw(){
		this.repaint();
	}
}

