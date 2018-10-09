package guiStuff;

import thing.*;
import rooms.*;
import chars.*;
import items.*;
import enviro.*;

public class Projectile extends Thing{
    
    private Direction dir;
    private int speedBoost = 1;
    private int damage = 1;

    public Projectile(int floor, int rx, int ry, int x, int y, int s){
	super(Type.PROJECTILE, floor, rx, ry, x, y);
	setTotalSpeed(s + speedBoost);
    }


    // Gets & Sets


    public void setTotalSpeed(int s){
	setSpeed(s + speedBoost);
	// s is the speed of the Basechar from which the Projectile
	// is created
    }

    public int getTotalSpeed(){
	return getSpeed();
    }

    public void setSpeedBoost(int sb){
	speedBoost = 1;
    }

    public int getSpeedBoost(){
	return speedBoost;
    }

    public void setDamage(int d){
	damage = d;
    }

    public int getDamage(){
	return damage;
    }

    // Methods
    /*
    public void hit(Basechar target){
	if (target.getType() == Type.ENEMY){
	    //target.setHP-= damage;
	    //fix this line pls
	}
    }
    */
    
}
