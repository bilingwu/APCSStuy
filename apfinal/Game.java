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
import javax.swing.JTextArea;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Math;
import chars.*;
import enviro.*;
import floors.*; 
import guiStuff.*;
import items.*; 
import rooms.*; 
import thing.*; 

public class Game extends JFrame{

    //private static final long serialVersionUID = 7416567620110237028L;
    private int x = 683;
    private int y = 385;
    private int startx=76768;
    private int starty;
    private JPanel canvas;
    private JTextArea healthBar; 
    private Container pane;
    private BufferedImage background, hero, desk, trashcan, senor, nomar, laserR, laserL, laserU, laserD, starbucks, freshmanbackpack, fivehourenergy, halalfood, curvedtestgrade; // door
    private Rectangle l;
    private Hero player;
    private int spd;
    private Thing.Direction laserdirection = Thing.Direction.LEFT;
    private Baseroom room;
    private boolean laserBool = false;
    private int monstersKilled = 0;

    public Game(Baseroom r, Hero p){
	setTitle("Room");
	setSize(1380,905);

	room=r;
	player = p;
	spd = player.getSpeed();
	pane=getContentPane();
	pane.setLayout(new FlowLayout());
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	try {                
	    background = ImageIO.read(new File("images/background.png"));
	    hero = ImageIO.read(new File("images/temphero.png"));
	    desk = ImageIO.read(new File("images/desk.png"));
	    trashcan = ImageIO.read(new File("images/trashcan.png"));
	    senor = ImageIO.read(new File("images/senor.png"));
	    nomar = ImageIO.read(new File("images/nomar.png"));
	    laserR = ImageIO.read(new File("images/laserR.png"));
	    laserL = ImageIO.read(new File("images/laserL.png"));
	    laserU = ImageIO.read(new File("images/laserU.png"));
	    laserD = ImageIO.read(new File("images/laserD.png"));
	    starbucks = ImageIO.read(new File("images/starbucks.png"));
	    freshmanbackpack = ImageIO.read(new File("images/freshmanbackpack.png"));
	    fivehourenergy = ImageIO.read(new File("images/fivehourenergy.png"));
	    halalfood = ImageIO.read(new File("images/halalfood.png"));
	    curvedtestgrade = ImageIO.read(new File("images/curvedtestgrade.png"));

	} catch (IOException ex) {
	    System.out.println("oops");
	}

	canvas = new Canvas();
	canvas.setPreferredSize(new Dimension(1366,768));
	canvas.update(canvas.getGraphics());
	pane.setFocusable(true);
	pane.addKeyListener(new Key());
	pane.add(canvas);

	healthBar = new JTextArea();
	healthBar.setEditable(false);
	healthBar.setPreferredSize(new Dimension(500,75));
	healthBar.setBorder(BorderFactory.createLineBorder(Color.blue,2));
	pane.add(healthBar);

	healthBar.setText("Status Bar \n" + "Health:" + player.getCurrentHP()+ "\n" + "Monsters Killed: " + monstersKilled + "\n");
    }

    public void setFocusable(boolean b){
	pane.setFocusable(b);
    }

    public void drawRoom(Baseroom r, Graphics g){
	ArrayList<Thing> thingstoDraw = r.getThingArrayList();
	for (int i = 0; i < thingstoDraw.size(); i++){
	    Thing t = thingstoDraw.get(i);
	    Thing.Type thingType = t.getType();
	    int[] PosInRoom = t.getPosInRoom();
	    int xcoor = PosInRoom[0];
	    int ycoor = PosInRoom[1];
	    switch (thingType){
	    case ENVIRONMENT:
		Enviro.EnviroType enviroType = ((Enviro)t).getEnviroType();
		switch (enviroType){
		case DESK:
		    g.drawImage(desk, xcoor, ycoor, null);
		    break;
		case TRASHCAN:
		    g.drawImage(trashcan, xcoor, ycoor, null);
		    break;
		}
		break;
	    case ENEMY:
		Monster.MonsterType monsterType = ((Monster)t).getMonsterType();
		switch (monsterType){
		case SUBSTITUTE:
		    g.drawImage(senor, xcoor, ycoor, null);
		    break;
		case BOSS:
		    g.drawImage(nomar, xcoor, ycoor, null);
		    break;
		}
		break;

	    case FRIENDLY:
		r.updateThing(t, x, y, false);
		g.drawImage(hero, x, y, null);
		break;
	    case ITEM:
		int itemNum = ((Item)t).getItemNum();
		if (itemNum == 0)
		    g.drawImage(curvedtestgrade, xcoor, ycoor, null);
		else if (itemNum == 1)
		    g.drawImage(halalfood, xcoor, ycoor, null);
		else if (itemNum == 2)
		    g.drawImage(starbucks, xcoor, ycoor, null);
		else if (itemNum == 3)
		    g.drawImage(freshmanbackpack, xcoor, ycoor, null);
		else if (itemNum == 4)
		    g.drawImage(fivehourenergy, xcoor, ycoor, null);
		break;
	    }
	}
	
    }
 

    public void laser(){
	int r = player.getRange();
	int loc[] = player.getLocation();      

	switch (laserdirection) {
	case LEFT:
	    startx = loc[3]+25;
	    starty = loc[4]-10;
	    l = new Rectangle(startx,starty,loc[3]+r,loc[4]+10);
	    break;
	case RIGHT:
	    startx = loc[3]-r-25;
	    starty = loc[4]-10;
	    l = new Rectangle(startx,starty,loc[3],loc[4]+10);
	    break;
	case UP:
	    startx = loc[3]-10;
	    starty = loc[4]-r-25;
	    l = new Rectangle(startx,starty,loc[3]+10,loc[4]);
	    break;
	case DOWN:
	    startx = loc[3]-10;
	    starty = loc[4]+25;
	    l = new Rectangle(startx,starty,loc[3]+10,loc[4]+r); 
	    break;
	}
	laserBool = true;
	
	//Should check if the laser and some enemy collide
	ArrayList<Thing> things = room.getThingArrayList();
	for (int i = 0; i < things.size(); i++){	
	    if( (things.get(i).bounds().intersects(l)) && (things.get(i).getType() == Thing.Type.ENEMY) ){
	        Monster m = ((Monster)things.get(i));
		player.attack(m);
		
		//This takes care of items dropping. Makes sense to put it here,
		//because this is the only way Monsters can die.
		if(m.getCurrentHP() <= 0){
		    monstersKilled++;
		    Item drop = room.itemDrop(m); 
		    //Itemdrop kills it, then returns the item dropped
		    //(if it did drop one), else null
		    if(drop != null){
			//draw in the image
			//need your help for this too Sara
		    }
		}
	    }
	    //After a wait, destroy the rectangle here Sara pls halp me
	    l = null;
	}
    }

    public boolean checkPlayerDeath(){
	return (player.getCurrentHP() < 0);
    }

    public int getMonstersKilled(){
	return monstersKilled;
    }

    public boolean unitCollision(Basechar movingChar, Thing.Direction dir){
	ArrayList<Thing> things = room.getThingArrayList();
	int currentx = movingChar.getPosInRoom()[0];
	int currenty = movingChar.getPosInRoom()[1];
	int[] ifMoved = movingChar.tryMove(dir);
	int xcoor = ifMoved[3];
	//System.out.println("x after tryMoving " + xcoor);
	int ycoor = ifMoved[4];
	//System.out.println("y after tryMoving " + ycoor);
	
	//While the walls are not techinically units, it's easier to keep
	//all the "movement checking" in one method.
	if (dir == Thing.Direction.LEFT || dir == Thing.Direction.RIGHT){
	    if (xcoor < 35 || xcoor > 1330)
		return true;
	}
	if (dir == Thing.Direction.UP || dir == Thing.Direction.DOWN){
	    if (ycoor < 85 || ycoor > 705)
		return true;
	}
	
	//And this loop checks the list of things that have been spawned in
	//and sees if any of those things occupy the area the Basechar
	//is trying to move into.
	for (int i = 0; i < things.size(); i++){
	    if (movingChar != things.get(i)){
		int xcoor2 = things.get(i).getPosInRoom()[0];
		int ycoor2 = things.get(i).getPosInRoom()[1];
		/*
		  System.out.println( Arrays.toString( things.toArray() ) );
		  System.out.println(xcoor + " : " + xcoor2);
		  System.out.println(movingChar.getPosInRoom()[0]);
		  System.out.println(ycoor + " : " + ycoor2);
		  System.out.println(movingChar.getPosInRoom()[1]);
		*/
		if ((movingChar.bounds(xcoor,ycoor).intersects( things.get(i).bounds())
		     || (movingChar.bounds(xcoor,ycoor).equals( things.get(i).bounds()))))
		    return true;
		// TODO: maybe fix/cleanup the code & diagnose the problem

		// no idea why the first check (above) doesnt cover everything..
		// did testing & this was the closest way to cover the two weird scenes which were:
		//      - you approach a thing from underneath or from the thing's right
		//      with only the above code, able to go through either the bottom or the right
		//      (and it was diff for each object)
		// POSSIBLE CAUSES: maybe the generation of the images?
		//     - starts from TOPLEFT corner of the image, and the TOP & LEFT scenarios work fine
		//     but the others dont
		if ((dir == Thing.Direction.UP && ycoor2 < currenty && currentx == xcoor2) ||
		    (dir == Thing.Direction.LEFT && xcoor2 < currentx && currenty == ycoor2))
		    if ((movingChar.bounds(currentx-76,currenty-76,77).intersects( things.get(i).bounds(xcoor2,ycoor2) ))
			|| (movingChar.bounds(currentx-76,currenty-76,77).contains( things.get(i).bounds(xcoor2,ycoor2) )))
			return true;
	    }
	}
	return false;
    }

    public int[] getCollisionPoint(Basechar movingChar, Thing.Direction dir){
	Thing[][] grid = room.getGrid();
	int[] loc = movingChar.tryMove(dir);
	int locx = loc[3];
	int locy = loc[4];
	int[] collision = new int[2];
	int xbound = locx - 50;
	int ybound = locy - 50;
	for ( ; locx >= 0 && locx > xbound; locx--){
	    for ( ; locy >= 0 && locy > ybound; locy--){
		if (grid[locx][locy] != null){
		    collision[0] = locx;
		    collision[1] = locy;
		    break;
		}
	    }
	    locy = loc[4];
	}
	return collision;
    }

  // returns what the movingChar collides with (essentially same code as above unitCollision)
    public Thing thingUnitCollision(Basechar movingChar, Thing.Direction dir){
	ArrayList<Thing> things = room.getThingArrayList();
	int currentx = movingChar.getPosInRoom()[0];
	int currenty = movingChar.getPosInRoom()[1];
	int[] ifMoved = movingChar.tryMove(dir);
	int xcoor = ifMoved[3];
	int ycoor = ifMoved[4];
	for (int i = 0; i < things.size(); i++){
	    if (movingChar != things.get(i)){
		int xcoor2 = things.get(i).getPosInRoom()[0];
		int ycoor2 = things.get(i).getPosInRoom()[1];
		if ((movingChar.bounds(xcoor,ycoor).intersects( things.get(i).bounds())
		     || (movingChar.bounds(xcoor,ycoor).equals( things.get(i).bounds()))))
		    return things.get(i);
		if ((dir == Thing.Direction.UP && ycoor2 < currenty && currentx == xcoor2) ||
		    (dir == Thing.Direction.LEFT && xcoor2 < currentx && currenty == ycoor2))
		    if ((movingChar.bounds(currentx-76,currenty-76,77).intersects( things.get(i).bounds(xcoor2,ycoor2) ))
			    || (movingChar.bounds(currentx-76,currenty-76,77).contains( things.get(i).bounds(xcoor2,ycoor2) )))
			return things.get(i);
	    }
	}
	return null;
    }


    public boolean checkMove(Thing.Direction dir){
	boolean collide = unitCollision(player, dir);
	if (!(collide)){
	    player.setDir(dir);
	    player.move();
	    //System.out.println("x " + player.getPosInRoom()[0]);
	    //System.out.println("y " + player.getPosInRoom()[1]);
	    return true;
	}
	else{
	    int[] colpt = getCollisionPoint(player, dir);
	    Thing t = room.getThingAt(colpt[0],colpt[1]);
	    Thing.Type thingType = t.getType();
	    switch(thingType){
	    case ENEMY:
		((Basechar)t).attack(player);
		healthBar.setText("Current Health : "+ player.getCurrentHP() + "\n" + "Monsters Killed : " + monstersKilled + "\n");
		break;
	    case ITEM:
		boolean consumed = ((Item)t).itemEffect(player);
		if(consumed)
		    room.die(t);
		break;
	    case ENVIRONMENT:
		break;
	    }	
	    //case FRIENDLY never happens, case PROJECTILE is something 
	    //we can use in a further expansion maybe
	}
	return false;
    }

    public void monsterMove(){
	ArrayList<Monster> monsters = room.getMonsterArrayList();
	for (int i = 0; i < monsters.size(); i++){
	    Monster m = monsters.get(i);
	    if (!(unitCollision(m, m.getDir()))){
		m.autoMove(player);
		int[] PosInRoom = m.getPosInRoom();
		room.updateThing( m, PosInRoom[0], PosInRoom[1], true );
	    }
	    else {
		Thing t = thingUnitCollision(m, m.getDir());
		if (t == player){
		    // monsters deal damage and die upon contact with hero
		    // spawn a monster everytime one of them dies
		    monstersKilled++;
		    m.dealDmg(player);
		    room.die(m);
		    room.addRandomMonster();
		}
	    }
	}
	healthBar.setText("This Is The Health Bar \n Current Health: "+ player.getCurrentHP() + "\n" + "Monsters Killed : " + monstersKilled + "\n");
    }

    private class Key implements KeyListener{
	public void keyPressed(KeyEvent e){
	    try{
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
		    if (checkMove(Thing.Direction.LEFT))
			x-=spd;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
		    if (checkMove(Thing.Direction.RIGHT))
			x+=spd;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP){
		    if (checkMove(Thing.Direction.UP))
			y-=spd;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
		    if (checkMove(Thing.Direction.DOWN))
			y+=spd;
		}
		else if (e.getKeyCode() == KeyEvent.VK_A){
		    laserdirection = Thing.Direction.LEFT;
		    laser();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D){
		    laserdirection = Thing.Direction.RIGHT;
		    laser();
		}
		else if (e.getKeyCode() == KeyEvent.VK_W){
		    laserdirection = Thing.Direction.UP;
		    laser();
		}
		else if (e.getKeyCode() == KeyEvent.VK_S){
		    laserdirection = Thing.Direction.DOWN;
		    laser();
		}
	    }
	    catch (Exception exc){
		// do nothing
	    }
	    monsterMove();
	    canvas.update(canvas.getGraphics());
	}
	public void keyReleased (KeyEvent e){}
	public void keyTyped(KeyEvent e){}
    }


    private class Canvas extends JPanel {
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(background, 0, 0, null);
	    drawRoom(room,g);
	    while (laserBool){
		switch (laserdirection){
	    	case LEFT:
			g.drawImage(laserL, startx-325, starty+25, null);
			break;
		case RIGHT:
			g.drawImage(laserR, startx+75, starty+25, null);
			break;
	    	case UP:
			g.drawImage(laserU, startx+25, starty-300, null);
			break;
		case DOWN:
			g.drawImage(laserD, startx+25, starty+50, null);
			break;
	    	}		
		try{
		    Thread.sleep(100);
		}
		catch(Exception e){}
		laserBool = false;
	    }
	}
    }

}
