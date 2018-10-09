package enviro;

import thing.*;
import rooms.*;
import items.*;
import chars.*;
import guiStuff.*;

public class Enviro extends Thing{

    /*------------------------ Enums -----------------------------*/

    private boolean breakable, movable;

    public enum EnviroType{
	DESK, TRASHCAN, DOOR
    }
    //Desk == a rock. Standard environemnt object you can't do anything to.
    //Trashcan == pots in Zelda. You can smash them for chances at drops.
    //Door == transport between rooms. Step on it, and you travel to the 
    //adjacent room. Unfortunately, we couldn't get that to work in time.

    private EnviroType enviroType;

    /*----------------------- Constructors ------------------------*/
    
    public Enviro(EnviroType e, int f, int rx, int ry, int x, int y){
	super(Type.ENVIRONMENT,f,rx,ry,x,y);
	enviroType = e;
	setup(e);
    }

    private void setup(EnviroType e){
	switch (e){
	case DESK:
	    breakable = false;
	    movable = false;
	    break;
	case TRASHCAN:
	    breakable = true;
	    movable = false;
	    break;
	case DOOR:
	    breakable = false;
	    movable = false;
	    break;
	}
    }

    /*---------------------- Gets & Sets --------------------------*/

    public EnviroType getEnviroType(){
	return enviroType;
    }

    public boolean getBreakable(){
	return breakable;
    }

    public void setBreakable(boolean br){
	br = breakable;
    }

    public boolean getMovable(){
	return movable;
    }

    public void setMovable(boolean mov){
	mov = movable;
    }

}
