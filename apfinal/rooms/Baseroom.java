package rooms;
 
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.lang.Math;
import thing.*;
import enviro.*;
import items.*;
import chars.*;
import guiStuff.*;

public class Baseroom{

    /*---------------------------- Variables --------------------------------*/

    private int roomxcor, roomycor, floor, difficulty;
    /*
      Currently difficulty doesn't increase, but in the Monster class the difficulty
      param increases their HP. Roomxcor and roomycor are the coordinates of the room
      on the floor as a whole. However, we decided not to do a floor, so those two
      variables aren't really important anymore. And we decided not to make multiple 
      floors, so the floor variable is also pretty arbitrary.
    */

    private Thing[][] grid = new Thing[1366][768];
    //1366 x 768 is the number of pixels in our GUI display. Because we wanted
    //smoother movement, the room is designed on a pixel-by-pixel basis.

    private ArrayList<Thing> things = new ArrayList<Thing>();
    //List of objects in our room to make unit collision easier
    
    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    //List of monsters to make unit collision easier + faster

    private ArrayList<Item> items = new ArrayList<Item>();

    //1366 x 768 is the number of pixels in our GUI display. Because we want 
    //smooth movement, the room is designed on a pixel-by-pixel basis.

    private Random rnd = new Random();
    private Enviro.EnviroType desk = Enviro.EnviroType.DESK;
    private Enviro.EnviroType trash = Enviro.EnviroType.TRASHCAN;

    /*------------------------- Constructor(s) --------------------------*/
    
    public Baseroom(int f, int rx, int ry, int d){
	floor = f;
	roomxcor = rx;
        roomycor = ry;
	difficulty = d;
    }

    /*---------------------------- Methods ------------------------------*/

    //To update the 2D array we use this method
    public boolean addThing(Thing t, int x, int y){
	if(grid[x][y] == null){
	    grid[x][y] = t;
	    things.add(t);
	    // adds it to both; monsters will be used for movement
	    // things will just be used for unitcollision
	    if (t.getType() == Thing.Type.ENEMY)
		monsters.add((Monster)t);
	    if (t.getType() == Thing.Type.ITEM)
		items.add((Item)t);
	    return true;
	}
	/*
	  I made this so we can troubleshoot easier.
	  This function should never come into play when
	  the game actually runs.
	*/
	else{
	    System.out.println(grid[x][y]);
	    return false;
	}
    }

    //To update the arraylist of things / monsters is a separate matter
    public void updateThing(Thing t, int x, int y, boolean isMonster){
	try{
	    int i = things.indexOf(t);
	    things.get(i).setPosInRoom(x,y);
	    // if its a monster, also update it in monsters
	    if (isMonster){
		int j = monsters.indexOf(t);
		monsters.get(j).setPosInRoom(x,y);
	    }
	}catch(Exception e){
	    //do nothing, monster is dead
	}
    }

    //When something dies, the chance it has to drop an item is here
    //This method also kills the thing and spawns in the item
    //Then it returns the item it created or null if nothing dropped
    public Item itemDrop(Thing deadThing){
	int chance = rnd.nextInt(100);	       
	int loc[] = deadThing.getLocation();
	die(deadThing);
	if(chance < 20){
	    if(chance >= 12){
		CurvedTestGrade ctg = new CurvedTestGrade(loc[0],loc[1],loc[2],loc[3],loc[4]);
		addThing(ctg,loc[3],loc[4]);
		return ctg;
	    }
	    else{
		int drop = chance % 4;
		if(drop == 0){
		    HalalFood hf = new HalalFood(loc[0],loc[1],loc[2],loc[3],loc[4]);
		    addThing(hf,loc[3],loc[4]);
		    return hf;
		}
		if(drop == 1){
		    Starbucks sb = new Starbucks(loc[0],loc[1],loc[2],loc[3],loc[4]);
		    addThing(sb,loc[3],loc[4]);
		    return sb;
		}
		if(drop == 2){
		    FreshmanBackpack fb = new FreshmanBackpack(loc[0],loc[1],loc[2],loc[3],loc[4]);
		    addThing(fb,loc[3],loc[4]);
		    return fb;
		}
		if(drop == 3){
		    FiveHourEnergy fhe = new FiveHourEnergy(loc[0],loc[1],loc[2],loc[3],loc[4]);
		    addThing(fhe,loc[3],loc[4]);
		    return fhe;
		}
	    }
	}
	return null;
    }

    //This is already used in itemDrop, but if there's ever an object 
    //that can't drop an item, this is what we would call. It removes the 
    //thing from the 2D array and the things arraylist
    public void die(Thing deadThing){
	int[] loc = deadThing.getLocation();
	things.remove(deadThing);
	if (deadThing.getType() == Thing.Type.ENEMY){
	    // almost always will be an ENEMY
	    // might be a breakable ENVIRO
	    monsters.remove(deadThing);
	}
	if (deadThing.getType() == Thing.Type.ITEM)
	    items.remove(deadThing);
	grid[ loc[3] ][ loc[4] ] = null;
    }	

    /*
      Initially all the rooms were supposed to come hardcoded with their monsters
      But since we turned the room into an arena-type survival fight
      we had to add this method as well. It just finds a valid area in the grid
      and spawns a monster there. 83 and 85 just happen to be multiples of 50 from
      the center of the screen, so we chose them as our effective borders.
    */ 
    public boolean addRandomMonster(){
	boolean added = false;
	while(!added){
	    int tryX = 83 + rnd.nextInt(25)*50;
	    int tryY = 85 + rnd.nextInt(13)*50;
	    if(grid[tryX][tryY] == null){
		Monster m = new Monster(Monster.MonsterType.SUBSTITUTE,floor,roomxcor,roomycor,tryX,tryY,difficulty);
		addThing(m,tryX,tryY);
		added = true;
		monsters.add(m);
	    }
	}
	return added;
    }

    /*------------------------ Gets & Sets & Utilities ------------------------*/
    
    public int getRX(){
	return roomxcor;
    }

    public int getRY(){
	return roomycor;
    }

    public int getFloor(){
	return floor;
    }

    public int getDifficulty(){
	return difficulty;
    }

    public void setDifficulty(int d){
	difficulty = d;
    }
	
    public Random getRandom(){
	return rnd;
    }

    public Thing[][] getGrid(){
	return grid;
    }

    public Thing getThingAt(int x, int y){
	return grid[x][y];
    }

    public void clearGrid(){
	for (int i = 0; i < 1367; i++){
	    for (int j = 0; j < 769; j++){
		grid[i][j] = null;
	    }
	}
    }

    public ArrayList<Thing> getThingArrayList(){
	return things;
    }

    public void setThingArrayList(ArrayList<Thing> t){
	things = t;
    }

    public void clearThingArrayList(){
        while (things.size() > 0){
	    things.remove(0);
	}
    }

    public ArrayList<Monster> getMonsterArrayList(){
	return monsters;
    }

    public void setMonsterArrayList(ArrayList<Monster> m){
	monsters = m;
    }

    /*---------------------- Room Generation Options ----------------------*/

    /*
      The spawn room on each floor - where you go after you beat the boss and
      advance to the next level - was supposed to be very basic, with just a 
      chance at getting some item drops and that's it.
    */

    public boolean createSpawn(){
	
	Enviro tc1 = new Enviro(trash,floor,roomxcor,roomycor,55,55);
	addThing(tc1,55,55);	
	Enviro tc2 = new Enviro(trash,floor,roomxcor,roomycor,1311,55);
	addThing(tc2,1311,55);
	Enviro tc3 = new Enviro(trash,floor,roomxcor,roomycor,55,713);
	addThing(tc3,55,713);
	Enviro tc4 = new Enviro(trash,floor,roomxcor,roomycor,1311,713);
	addThing(tc4,1311,713);
	
	return true;
    }

    /*
      The treasure room basically has a guaranteed chance to have an item in it
      instead. Since these items could also be dropped from normal monsters, it might
      have been better to add higher tier items that would spawn here if we had 
      more time. Right now, this is pretty imbalanced. 
    */
     public boolean createTreasure(){
	 Enviro d1 = new Enviro(desk,floor,roomxcor,roomycor,341,385);
	 addThing(d1,341,385);

	 Enviro d2 = new Enviro(desk,floor,roomxcor,roomycor,1025,385);
	 addThing(d2,1025,385);

	 int treasure = rnd.nextInt(4) + 1;
	 if(treasure == 1){
	     HalalFood hf = new HalalFood(floor,roomxcor,roomycor,683,385);
	     addThing(hf,683,385);
	 }
	 if(treasure == 2){
	     Starbucks sb = new Starbucks(floor,roomxcor,roomycor,683,385);
	     addThing(sb,683,385);
	 }
	 if(treasure == 3){
	     FreshmanBackpack fb = new FreshmanBackpack(floor,roomxcor,roomycor,683,385);
	     addThing(fb,683,385);
	 }
	 if(treasure == 4){
	     FiveHourEnergy fhe = new FiveHourEnergy(floor,roomxcor,roomycor,683,385);
	     addThing(fhe,683,385);
	 }

	 return true;
     }

     /*
       The next 3 methods are the beginning of an attempt to make a variety of
       "standard" rooms, rooms that you'd have to go through to get to the boss
       and to your desired items.
       The only difference between easy, med, and hard is the number of monsters
       and overall layout. Hard is not actually finished, it was supposed to have many
       more monsters and more variety. Easy and med only use Substitutes.
       We ended up using med as a template for our final arena room.        
     */

    public boolean createMonsterEasy(){
	
	Enviro d1 = new Enviro(desk,floor,roomxcor,roomycor,383,185);
	addThing(d1,383,385);
        Enviro d2 = new Enviro(desk,floor,roomxcor,roomycor,383,585);
	addThing(d2,383,585);
        Enviro d3 = new Enviro(desk,floor,roomxcor,roomycor,983,585);
	addThing(d3,983,585);

	Monster sub  = new Monster(Monster.MonsterType.SUBSTITUTE,floor,roomxcor,roomycor,683,585,difficulty);
	addThing(sub,683,385);
	
	return true;
    }

    public boolean createMonsterMed(){

	Enviro d1 = new Enviro(desk,floor,roomxcor,roomycor,383,185);
	addThing(d1,383,185);
	Enviro d2 = new Enviro(desk,floor,roomxcor,roomycor,983,185);
	addThing(d1,983,185);
	Enviro d3 = new Enviro(desk,floor,roomxcor,roomycor,383,585);
	addThing(d3,383,585);
	Enviro d4 = new Enviro(desk,floor,roomxcor,roomycor,1033,585);
	addThing(d4,983,585);

	Monster sub1 = new Monster(Monster.MonsterType.SUBSTITUTE,floor,roomxcor,roomycor,683,185,difficulty);
	addThing(sub1,683,185);
	//Monster sub2 = new Monster(Monster.MonsterType.SUBSTITUTE,floor,roomxcor,roomycor,683,585,difficulty);
	//addThing(sub2,683,585);
	return true;
    }

    /*
    public boolean createMonsterHard(){

	Enviro d1 = new Enviro(desk,floor,roomxcor,roomycor,341,55);
	addThing(d1,341,55);
	Enviro d2 = new Enviro(desk,floor,roomxcor,roomycor,1025,55);
	addThing(d2,1025,55);
        Enviro d3 = new Enviro(desk,floor,roomxcor,roomycor,341,713);
	addThing(d3,341,713);
	Enviro d4 = new Enviro(desk,floor,roomxcor,roomycor,1025,713);
	addThing(d4,1025,713);

	return true;
    }
    */
}

    
	  
    
