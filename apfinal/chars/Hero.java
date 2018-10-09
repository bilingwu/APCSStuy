package chars;

import enviro.*;
import floors.*;  
import guiStuff.*;
import items.*; 
import rooms.*; 
import thing.*; 

/*
  Hero as always is the character you play as. While most games have multiple
  options when it comes to what class you choose for your hero, Isaac starts 
  out with only one. So this Hero class comes with the most basic stats.
  Range is a feature that is currently unique to Hero, because we didn't
  have time to implement ranged enemies.
*/

public class Hero extends Basechar{
    
    private String name;
    private int range;

    public Hero(String n, int f, int rx, int ry, int x, int y){
	super(Thing.Type.FRIENDLY,f,rx,ry,x,y);
        setName(n);
	setMaxHP(10);
	setCurrentHP(getMaxHP());
	setAtk(1);
    }

    /*--------------------- Gets & Sets -----------------------*/

    public String getName(){
	return name;
    }

    public void setName(String s){
        name = s;
    }

    public int getRange(){
	return range;
    }

    public void setRange(int r){
	range = r;
    }


}
