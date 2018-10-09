//package guiStuff;

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Room extends JFrame {//implements KeyListener{
    private JFrame frame;
    private JPanel canvas;
    private Container pane;
    private BufferedImage image;
    private JTextArea displayGPA, displayPowerUp;


    public Room(){
	setTitle("Room");
	setSize(1380,805);

	pane=getContentPane();
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	try {                
	    image = ImageIO.read(new File("../images/background.png"));
	} catch (IOException ex) {
	    System.out.println("oops");
	}

	canvas = new Canvas();
	canvas.setPreferredSize(new Dimension(1366,768));
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
					 
    }

    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image, 0, 0, null);
	}
    }
    
    public static void main (String[] args){
	Room r = new Room();

	r.setVisible(true);
    }

}
