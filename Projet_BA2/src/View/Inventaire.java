package View;

import Model.Game;
import Model.GameObject;
import Model.Item;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class Inventaire extends JPanel  {
	private Color Brun;
	private Color lightBrun;
	private Color Gris;
	private Color lightGris;
	private JButton itoic;
	private JButton itow;
	private JButton ictoi;
	private JButton wtoi;
	private JButton start;
	private ArrayList<GameObject> inventaireCombat = new ArrayList<GameObject>();
	private Game game;
	
	private JButton item01;
	private JButton item02;
	private JButton item03;
	private JButton item04;
	private JButton item05;
	private JButton item06;
	private JButton item07;
	private JButton item08;
	private JButton item09;
	private JButton item00;
	private JButton item11;
	private JButton item12;
	private JButton item13;
	private JButton item14;
	private JButton item15;
	private JButton item16;
	private JButton item17;
	private JButton item18;
	private JButton item19;
	private JButton item20;
	private JButton item21;

	public Inventaire(Game game){

		this.game = game;
	    this.Brun = new Color (80, 39, 3);//65,28,27
	    this.lightBrun = new Color(94,77,57);
	    this.Gris = new Color (52,52, 48); 
	    this.lightGris = new Color(78,78,71);
	    this.setInventaireCombat(game.getInventaireCombat());
	  
	    
	}
	public void paint (Graphics g){
		
		start = new JButton("START !");
		start.setBounds(1710, 40, 100, 90);
		for(int h =0; h< 2; h++){
		itoic = new JButton("inv to fight inv");
		itoic.setBounds(1690, 140+450*h, 125, 50);
		itow = new JButton("inv to weapons");
		itow.setBounds(1690, 240+450*h, 125, 50);
		ictoi = new JButton ("fight inv to inv");
		ictoi.setBounds(1690, 340+450*h, 125, 50);
		wtoi = new JButton("weapons to inv");
		wtoi.setBounds(1690, 440+450*h, 125, 50);
		add(itoic);
		add(itow);
		add(ictoi);
		add(wtoi);
		add(start);
		}
		
		g.setColor(Brun);
		g.fillRect(0, 0, 1900, 1040);
		g.setColor(lightBrun);
		g.fillRect(25, 25, 1830, 950);
		g.setColor(Gris);
		g.fillRect(50, 50, 1610, 475);
		g.setColor(lightGris);
		for (int i = 0; i < 13; i++){
			for (int j =0; j< 3; j++){
				Image image = game.getInventaireCombat().get(i).getImage();
				g.fillRect(90+120*i, 90+150*j, 90, 90);
				JButton item = new JButton();
				item.setBounds(130+120*i, 90+150*j, 50, 50);
				item.setIcon(new ImageIcon(image));
			
		}}
		
		for(int h =0; h < 2; h++){
		for (int i = 0; i< 2; i++){
		g.setColor(Gris);
		g.fillRect(50+830*i, 550+250*h , 775, 150);

	}
		for (int i = 0; i< 2; i++){
			for(int j = 0; j< 5; j++){

		g.setColor(lightGris);
		g.fillRect(120+140*j+830*i, 580+250*h, 90, 90);
	}}	}
		
	
	}
	public void setInventaireCombat(ArrayList<GameObject> objects){
		this.inventaireCombat = objects;
	}
	
	public void redraw(){
		this.repaint();
	}
}