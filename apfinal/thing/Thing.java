package thing;

import java.util.Arrays;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Toolkit;
import java.awt.Rectangle;
import floors.*;
import enviro.*;
import items.*;
import chars.*;
import guiStuff.*;

public class Thing{

    /*-------------------- Variables & Enums ----------------------*/

    private int[] location;
    private int speed = 50;
   
    public enum Type {
	FRIENDLY, ENEMY, PROJECTILE, ENVIRONMENT, ITEM
    }
    /*
      Most of these types should be pretty self explanatory
      We were going to do projectiles but ran into trouble, so we ended
      up with that laser function in Game.java, which doesn't deal with 
      travel time and just instantly does damage.
    */
    
    private Type type;


    public enum Direction {
	UP, DOWN, LEFT, RIGHT
    }
    //Necessary for motion and shooting of lasers/projectiles

    private Direction dir;

    /*---------------------- Constructor(s) -----------------------*/

    public Thing(Type t, int floor, int rx, int ry, int x, int y){
	type = t;
        location = new int[]{floor, rx, ry, x, y};
        setDir(Direction.UP);
    }

    /*----------------------- Gets & Sets ------------------------*/

    public Type getType(){
	return type;
    }
    
    public String printLocation(){
	return Arrays.toString(location);
    }

    public int[] getLocation(){
	return location;
    }

    public void setLocation(int[] loc){
	location = loc;
    }

    public int getFloor(){
	return location[0];
    }

    public void setFloor(int fl){
	location[0] = fl;
    }

    public int[] getRoom(){
	int[] roomCoor = new int[]{ location[1], location[2] };
	return roomCoor;
    }

    public void setRoom(int newrx, int newry){
	location[1] = newrx;
	location[2] = newry;
    }

    public int[] getPosInRoom(){
	int[] PosInRoom = new int[]{ location[3], location[4] };
	return PosInRoom;
    }

    public void setPosInRoom(int newx, int newy){
	location[3] = newx;
	location[4] = newy;
    }

    public Direction getDir(){
	return dir;
    }

    public void setDir(Direction d){
	dir = d;
    }

    public int getSpeed(){
	return speed;
    }

    public void setSpeed(int s){
	speed = s;
    }

    /* --------------------------------- Methods -------------------------------- */

    // changes the position in room of the Thing based on its direction
    public void move(){
	int[] loc = getLocation();
	switch (dir){
	case UP:
	    setPosInRoom( loc[3], loc[4]+speed );
	    break;
	case DOWN:
	    setPosInRoom( loc[3], loc[4]+speed );
	    break;
	case LEFT:
	    setPosInRoom( loc[3]-speed, loc[4] );
	    break;
	case RIGHT:
	    setPosInRoom( loc[3]+speed, loc[4] );
	    break;
	}
    }


    // tryMove is used in unitCollision (see Baseroom)
    // checks if the place that the Thing WOULD move to
    public int[] tryMove(Thing.Direction d){
	int[] loc = getLocation();
	setDir(d);
	switch (d){
	case UP:
	    loc[4]+=speed;
	    setDir(Direction.UP);
	case DOWN:
	    loc[4]-=speed;
	    setDir(Direction.DOWN);
	case LEFT:
	    loc[3]-=speed;
	    setDir(Direction.LEFT);
	case RIGHT:
	    loc[3]+=speed;
	    setDir(Direction.RIGHT);
	}
	return loc;
    }

    //For GUI purposes
    public void drawChar(BufferedImage pic, Graphics g){
	g.drawImage(pic, getPosInRoom()[0], getPosInRoom()[1],null);
	Toolkit.getDefaultToolkit().sync();
    }

    /*----------------------- UnitCollision -----------------------*/

    /*
      All of these bounds functions are here so that we can draw the
      hitbox of any object in our game for unit collission purposes.
      Depending on the params we have available, we need different forms of 
      this method, so we overloaded them.
    */

    public Rectangle bounds(){
	int[] PosInRoom = getPosInRoom();
	Rectangle b = new Rectangle( PosInRoom[0], PosInRoom[1], 50, 50);
	return b;
    }

    public Rectangle bounds(int x, int y){
	Rectangle b = new Rectangle( x, y, 50, 50);
	return b;
    }

    public Rectangle bounds(int x, int y, int s){
	Rectangle b = new Rectangle( x, y, s, s );
	return b;
    }

    
}
