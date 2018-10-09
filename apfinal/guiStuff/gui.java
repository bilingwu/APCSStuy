package guiStuff;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;


public class gui {

    private ImageIcon image1;
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;

    public gui() {
	layout();
    }
    class Grid extends JComponent {
	public void paint(Graphics g) {
	    //g.drawRect (10, 10, 1260, 760);    

	    for (int i = 10; i <= 1260; i+= 50)
		g.drawLine (i, 10, i, 760);

	    for (int i = 10; i <= 760; i+= 50)
		g.drawLine (10, i, 1260, i);
	    g.drawLine(10,770,1260,770);
	}
    }
    
    public void layout() {
	frame = new JFrame("Welcome to Stuyablo");
	frame.setVisible(true);
	frame.setSize(1270,820);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(new Grid());
	//	frame.setLayout(null);

	
	ImageIcon image1= new ImageIcon("locker.png");
	JLabel locker = new JLabel(image1);
	
	        locker.setLocation(10, 150);

		panel.add(locker);
	//	panel.add(label);

	//     frame
		frame.add(panel);
    } 




    public static void main(String[] args) {
	new gui();

    }



}
