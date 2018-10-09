package items;

import thing.*;
import rooms.*;
import enviro.*;
import chars.*;

public class HalalFood extends Item{
    //Consider this item #1.
    //Halal food is filling and delicious. (and cheap)
    //+ to your HP.

    private int itemNum = 1;

    public HalalFood(int f, int rx, int ry, int x, int y){
	super(f,rx,ry,x,y,1);
    }

    public boolean itemEffect(Basechar other){
	other.setMaxHP(other.getMaxHP()+1);
	return true;
    }
    //You can always increase your max HP, so this should
    //never return false.
    
}

