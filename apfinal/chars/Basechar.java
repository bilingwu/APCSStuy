package chars;

import thing.*;
import rooms.*;
import enviro.*;
import items.*;
import guiStuff.*;

/*
  Basechar is your standard character that can be extended to a player or 
  a monster. 
  The move and tryMove methods should also be relatively straightforward,
  they just add/subtract speed depending on direction and cause movement
  or simiulated movement. 
*/

public abstract class Basechar extends Thing{


    /* -------------------------- Variables ---------------------------- */

    private int currentHP;
    private int maxHP;
    private int atk;
    private int speed = 50;


    /* ------------------------ Constructors --------------------------- */

    //Since Basechar can be a monster or a player, the constructor must 
    //have a parameter for the enums type as well. 
    
    public Basechar(Type t, int f, int rx, int ry, int x, int y){
	super(t, f, rx, ry, x, y);
    }

    /* ------------------------ Gets & Sets --------------------------- */

    public void setCurrentHP(int health){
	currentHP = health;
    }
    
    public int getCurrentHP(){
	return currentHP;
    }

    public void setMaxHP(int health){
	maxHP = health;
    }
    
    public int getMaxHP(){
	return maxHP;
    }

    public void setAtk(int a){
	atk = a;
    }
    
    public int getAtk(){
	return atk;
    }

    /* -------------------------- Methods -------------------------- */

    public void attack(Basechar other){
	other.setCurrentHP(other.getCurrentHP() - atk);
    }

    // changes the position in room of the Thing based on its direction
    public void move(){
	int[] loc = getLocation();
	switch (getDir()){
	case UP:
	    setPosInRoom( loc[3], loc[4]-speed );
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
	    loc[4]-=speed;
	case DOWN:
	    loc[4]+=speed;
	case LEFT:
	    loc[3]-=speed;
	case RIGHT:
	    loc[3]+=speed;
	}
	return loc;
    }
    
}
