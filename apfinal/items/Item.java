package items;

import thing.*;
import rooms.*;
import enviro.*;
import chars.*;

public abstract class Item extends Thing{
    private int itemnumber;

    public Item(int f, int rx, int ry, int x, int y, int i){
	super(Type.ITEM,f,rx,ry,x,y);
	itemnumber = i;
    }

    public abstract boolean itemEffect(Basechar other);
    //Each item has an effect which gets applied to a character when
    //it gets picked up, aka when the character collides with it.
    //Monsters cannot pick up items.


    //Itemnumber exists to make it easier to randomly generate items.
    public int getItemNum(){
	return itemnumber;
    }
    
    public void setItemNum(int n){
	itemnumber = n;
    }

}
