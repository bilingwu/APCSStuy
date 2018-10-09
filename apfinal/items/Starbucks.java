package items;

import java.util.Random;
import thing.*;
import rooms.*;
import enviro.*;
import chars.*;

public class Starbucks extends Item{
    //Consider this item #2.
    //Starbucks drinks give you energy, right?
    //So they can buff speed or attack, 50/50 chance for either.

    private int itemNum = 2;

    public Starbucks(int f, int rx, int ry, int x, int y){
	super(f,rx,ry,x,y,2);
    }

    public boolean itemEffect(Basechar other){
	Random rnd = new Random();
	int test = rnd.nextInt(2);
	
	if(test == 0){
	    other.setAtk(other.getAtk()+1);
	    return true;
	}
	else{
	    other.setSpeed(other.getSpeed()+1);
	    return true;
	}
	
    }
    
}
