import floors.*;
import thing.*;
import rooms.*;
import enviro.*;
import items.*;
import chars.*;
import guiStuff.*;
//import java.awt.swing.*;

public class Driver{
    public static void main(String[] args){
	boolean gameIsRunning = true;
	StartEndScreen ses = new StartEndScreen();
	ses.setScreen("start");
	ses.setVisible(true);

	try{
	    Thread.sleep(5000);
	}
	catch(Exception e){}

	ses.setVisible(false);

	Baseroom b = new Baseroom(10,3,3,0);
	b.createMonsterMed();
	Hero player = new Hero("Isaac",10,3,3,683,385);
	b.addThing(player,683,385);
	Game g = new Game(b, player);

	while (gameIsRunning){
	    g.setVisible(true);
	    if (player.getCurrentHP() <= 0){
		g.setFocusable(false);
		try{
		    Thread.sleep(5000);
		}
		catch(Exception e){}
		gameIsRunning = false;
		g.setVisible(false);
		g.dispose();
	    }
	}
	ses.setScreen("end");
	ses.setupPointCounter( g.getMonstersKilled() );
	ses.setVisible(true);
	try{
	    Thread.sleep(15000);
	} catch (Exception e){}
	ses.setVisible(false);
	ses.dispose();
    }
}
