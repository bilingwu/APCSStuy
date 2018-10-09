package guiStuff;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class MergeGuibeta extends JFrame{
    
    private ImageIcon image1;
    private JTextArea area;
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;

    public MergeGuibeta() {
	frame = new JFrame("Welcome to Stuyablo");
	frame.setVisible(true);
	frame.setSize(1270,820);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame.getContentPane().add(new Grid());
	//	frame.setLayout(null);

	area = new JTextArea();
	area.setBounds(0,0,500,400);
	area.setBorder(BorderFactory.createLineBorder(Color.blue,2));	
        add(area);
	//terminal output
	
	ImageIcon image1= new ImageIcon("locker.png");
	JLabel locker = new JLabel(image1);
	
	        locker.setLocation(10, 150);

		panel.add(locker);
	//	panel.add(label);

	//     frame
		frame.add(panel);    }
    /*
    class Grid extends JComponent {
	public void paint(Graphics g) {
	    //g.drawRect (10, 10, 1260, 760);    
	    
	    for (int i = 10; i <= 1260; i+= 50)
		g.drawLine (i, 10, i, 760);

	    for (int i = 10; i <= 760; i+= 50)
		g.drawLine (10, i, 1260, i);
		//grid layout for gui     
	}
    }
*/

    public static void main (String [] args){
	new MergeGuibeta();
    }
}
