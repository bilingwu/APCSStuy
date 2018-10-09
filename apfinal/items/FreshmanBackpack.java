package items;

import thing.*;
import rooms.*;
import enviro.*;
import chars.*;

public class FreshmanBackpack extends Item{
    //Consider this item #3.
    //Freshman backpack somehow manages to weigh over 20 pounds.
    //Therefore, it raises attack, but lowers speed.
    
    private int itemNum = 3;

    public FreshmanBackpack(int f, int rx, int ry, int x, int y){
	super(f,rx,ry,x,y,3);
    }

    public boolean itemEffect(Basechar other){
	other.setAtk(other.getAtk()+1);
	other.setSpeed(other.getSpeed()-1);
	return true;
    }
    //Again, no cap on speed or atk, so this always returns true.
    
}
