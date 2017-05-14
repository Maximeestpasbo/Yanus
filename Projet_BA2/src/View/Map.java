package View;
import Model.Bombs;
import Model.GameObject;
import Model.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.util.Random;


public class Map extends JPanel {
	private ArrayList<GameObject> objects;
	private Image image;
	private Image image2;
	private Image image3;
	private int test;
	private int test2;
	
	public Map(){
		this.setFocusable(true);
		this.requestFocusInWindow();
		Random rand = new Random();
		this.test = rand.nextInt(5);
		this.test2 = rand.nextInt(5);
	}
	
	 public void paint(Graphics g) {
			 Color Brun = new Color (65, 28, 27);  //creates your new color
		
		try{	  
			 
	        ImageIcon ii = new ImageIcon("D:/Users/Maxime/Pictures/sol02.png");
	        image = ii.getImage();
	        
	        ImageIcon ii2 = new ImageIcon("D:/Users/Maxime/Pictures/sol03.png");
	        image2 = ii2.getImage();
	        
	        ImageIcon ii3 = new ImageIcon("D:/Users/Maxime/Pictures/sol04.png");
	        image3 = ii3.getImage();
	        
		for(int i = 0; i<35; i++){							// Vire la valeur 20 et parametrer ca
			for(int j = 0; j<20; j++){
				int x = i;
				int y = j;
				int h = (i+j)%3 ;
				if (h ==0){
					Graphics2D g2d = (Graphics2D) g;
					g2d.drawImage(image, x*50, y*50, this); }
				else if (h == 1){
					Graphics2D g2d = (Graphics2D) g;
					g2d.drawImage(image2, x*50, y*50, this); 
				}
				else if (h == 2){
					Graphics2D g2d = (Graphics2D) g;
					g2d.drawImage(image3, x*50, y*50, this); 
				}
				//g.setColor(Color.LIGHT_GRAY);
				//g.fillRect(x*50, y*50, 48, 48); 
				//g.setColor(Color.BLACK);
				//g.drawRect(x*50, y*50, 48, 48); 
			}
		}
		
		//for(GameObject object : this.objects){
		for(int i =0; i <objects.size(); i++ ){
			if(i> objects.size()){
				throw new IndexOutOfBoundsException("Objects out of Bounds.");
			}
			GameObject object = objects.get(i);

			int x = object.getPosX();
			int y = object.getPosY();
			int color = object.getColor();	

			if(object.getColor() < 12){
			if(color == 0){
				g.setColor(Color.DARK_GRAY);
			}
			
			else if(color == 1){
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
			else if(color == 8){
				g.setColor(Color.BLUE);
				g.fillRect(x*50, y*50-50, 48, 148);
			}
			
			else if(color == 10){
			g.setColor(Brun);
			}
			else if(color == 11){
				g.setColor(Color.LIGHT_GRAY);
				}


			g.fillRect(x*50, y*50, 48, 48);
			//g.setColor(Color.BLACK);
			g.drawRect(x*50, y*50, 48, 48); 
			
			
			
			}
			else if(color == 12){
				mBomber go = (mBomber) object;
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawImage(go.getImage(), object.getPosX()*50, object.getPosY()*50, this); 
				//g.drawImage(go.getImage(),50,50, null);
				}
			else if(color == 13){
				Bombs go = (Bombs) object;
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawImage(go.getImage(), object.getPosX()*50, object.getPosY()*50, this); 
				//g.drawImage(go.getImage(),50,50, null);
				}
			else if(color == 14){
				Animation go = (Animation) object;
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawImage(go.getImage(), object.getPosX()*50-50, object.getPosY()*50-50, this); 
				//g.drawImage(go.getImage(),50,50, null);
				}
			else if(color == 15){
				BlockBreakable go = (BlockBreakable) object;
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawImage(go.getImage(), object.getPosX()*50, object.getPosY()*50, this); 
				//g.drawImage(go.getImage(),50,50, null);
				}
			else if(color == 16){
				BlockUnbreakable go = (BlockUnbreakable) object;
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawImage(go.getImage(), object.getPosX()*50, object.getPosY()*50, this); 
				//g.drawImage(go.getImage(),50,50, null);
				}
		}}
		catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
			}
			
		
	
	
	public void setObjects(ArrayList<GameObject> objects){
		this.objects = objects;
	}
	
	
    private void doDrawing(Graphics g) {

    	for(int i = 0; i<objects.size(); i++){
    		GameObject object = objects.get(i);
        if (object instanceof mBomber){
        	mBomber go = (mBomber) object;
        	System.out.println(go.getImage());
        Graphics2D g2d = (Graphics2D) g;
       g2d.drawImage(go.getImage(), go.getX(), go.getY(), this); 
        g.drawImage(go.getImage(),50,50, this);
       
        System.out.println("doDarawin");
    }}}
	
	public void redraw(){
		this.repaint();
	}
}

