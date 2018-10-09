package items;

import thing.*;
import rooms.*;
import enviro.*;
import chars.*;

public class FiveHourEnergy extends Item{
    //Consider this item #4.
    //5-hour energy gives you lots of energy (buffing speed AND attack)
    //But that's at the expense of your health, of course.

    private int itemNum = 4;
    
    public FiveHourEnergy(int f, int rx, int ry, int x, int y){
	super(f,rx,ry,x,y,4);
    }

    public boolean itemEffect(Basechar other){
	other.setAtk(other.getAtk()+1);
	other.setSpeed(other.getSpeed()+1);
	other.setMaxHP(other.getMaxHP()-1);
	return true;
    }
    
}
