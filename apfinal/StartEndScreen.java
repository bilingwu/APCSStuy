import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.JTextArea;

public class StartEndScreen extends JFrame{
    
    private BufferedImage start, end;
    private Canvas canvas;
    private Container pane;
    private JTextArea points;

    public StartEndScreen(){
	setTitle("The Binding Of Stuysaac: Boss Trap");
	setSize (1380,855);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = getContentPane();
	pane.setLayout(new FlowLayout());
	try { 
	    start = ImageIO.read(new File("images/startUpScreen.png"));
	    end = ImageIO.read(new File ("images/endScreen.png"));
	} catch (IOException ex) {System.out.println ("boo");}

	canvas = new Canvas();
	canvas.setPreferredSize(new Dimension(1366,768));
	canvas.update(canvas.getGraphics());
	pane.add(canvas);
    }

    public void setupPointCounter(int monstersKilled){
	points = new JTextArea();
	points.setEditable(false);
	points.setPreferredSize(new Dimension(75, 75));
	points.setBorder(BorderFactory.createLineBorder(Color.white,2));
	points.setText("SCORE: \n" + monstersKilled);
	pane.add(points);
    }

    public void setScreen(String s){
	canvas.setStartOrEnd(s);
	canvas.update(canvas.getGraphics());
    }


    private class Canvas extends JPanel{

	private String startOrEnd;

	public void paintComponent(Graphics g){
	    if (startOrEnd.equals("start"))
		g.drawImage(start, 0, 0, null);
	    else if (startOrEnd.equals("end"))
		g.drawImage(end,0,0,null);
	}

	public void setStartOrEnd(String s){
	    startOrEnd = s;
	}
    }
}
