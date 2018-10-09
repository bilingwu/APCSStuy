/*all this GUI code is made to test the working projectile*/

package guiStuff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProjectileTest extends JFrame implements ActionListener{

    private JButton b1,b2;
    private Container pane;
    private Canvas canvas;
    private int[] location;
    private int x=135;
    private int y= 135;
    private int x1=135;
    private int y1= 135;
    private int y2= 135;
    private int x2= 135;
    private int y3= 135;
    private int x3= 135;
    private int y4= 135;
    private int x4= 135;




    private class Canvas extends JPanel {

	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.setColor(Color.red);
	    g.fillOval(x,y,30,30);
	    g.setColor(Color.blue);
	    g.fillOval(x1,y1,30,30);
	    g.setColor(Color.yellow);
	    g.fillOval(x2,y2,30,30);
	    g.setColor(Color.green);
	    g.fillOval(x3,y3,30,30);
	    g.setColor(Color.orange);
	    g.fillOval(x4,y4,30,30);
	   
	}
    }

    public void actionPerformed(ActionEvent e){
	while(e.getSource() == b1){
	    x=x+2;
	    x1= x1-2;
	    x2+=2;
	    y2+=2;
	    x3-=2;
	    y3+=2;
	    y4+=4;
	    if (e.getSource() == b2){
		System.out.println("Shutting down");
	    }
	    try{Thread.sleep (200);}
	    catch(Exception b){System.out.println("yey");}
	    canvas.update(canvas.getGraphics());

	    System.exit(0);	}
    }




    public ProjectileTest(){
	setSize(600,600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = getContentPane();
	pane.setLayout(new FlowLayout());
	b1 = new JButton("Click me");
	b1.addActionListener(this);
	pane.add(b1);
	b2 = new JButton("exit");
	b2.addActionListener(this);
	pane.add(b2);

	canvas = new Canvas();
	canvas.setPreferredSize(new Dimension(300,300));
	//	canvas.setBorder(BorderFactory.createLineBorder(Color.blue,2));		
	pane.add(canvas);
    }

    public static void main (String[] args){
	ProjectileTest f= new ProjectileTest();
	f.setVisible(true);
    }
    

}
