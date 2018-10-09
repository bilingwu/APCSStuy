package items;

import thing.*;
import rooms.*;
import enviro.*;
import chars.*;

public class CurvedTestGrade extends Item{
    //This is essentially a healing item that drops from mobs.
    //Since your HP is your GPA in this game, it makes sense that
    //a curved test grade would increase your GPA. :)
    //Consider this item #0, as it has the most basic effect.

    private int itemNum = 0;

    public CurvedTestGrade(int f, int rx, int ry, int x, int y){
	super(f,rx,ry,x,y,0);
    }

    public boolean itemEffect(Basechar other){
	if( other.getCurrentHP() + 1 <= other.getMaxHP() ){
	    other.setCurrentHP(other.getCurrentHP() + 1);
	    return true;
	}
	else{
	    return false;
	}
    }

}
    
