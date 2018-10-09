package floors;

import java.util.Random;
import java.util.Arrays;
import thing.*;
import rooms.*;
import enviro.*;
import items.*;
import chars.*;
import guiStuff.*;

public class Basefloor{
    /*
      Every floor is a 2D grid, not completely filled so you can have a 
      variety of paths that could be generated.
      The code for generation of doors and how to make a player move from 
      room to room is very iffy, so we abandoned the plan for the floor. 
      It was a crucial step that we didn't know how to do. We decided to  
      stick to a single room instead.

      But I do really like this code and generation formula, so I left it in.
    */

    /*--------------------- Variables & Contructors --------------------*/

    private Baseroom[][] rooms = new Baseroom[7][7]; //the map of the floor
    private int floornum; 
    private Random rnd = new Random();

    public Basefloor(int f){
	floornum = f;
    }

    public Basefloor(int f, int horizontal, int vertical){
	floornum = f;
	rooms = new Baseroom[horizontal][vertical];
    }

    /*------------------------- Utilities --------------------------*/

    public Baseroom[][] getRooms(){
	return rooms;
    }

    //Doesn't do anything, what can you print to represent a Baseroom after all
    public String print(){
	return Arrays.toString(rooms);
    }

    /*--------- The one method I spent ages trying to figure out -----------*/

    public boolean generateFloor(){
	Baseroom spawn = new Baseroom(floornum,3,3);
	spawn.createSpawn();
	rooms[3][3] = spawn;
	
	/*
	  This first while loop generates standard monster rooms in the 
	  floor. We start by creating one spawnroom in the middle. Then we 
	  randomly place rooms in the grid. If a room touches another one
	  (that's the purpose of the large if statement) then we generate it.
	  Then we randomly choose how to fill the room with diff methods.
	  Each floor has 11 rooms and is 7 x 7.
	  I'm too lazy to code in edge cases for a 5 x 5 grid like I originally
	  planned (you'd have to have different if statements to make sure 
	  an IndexOutOfBoundsException never gets returned if x or y are 0
	  or max). This way, that'll never happen. The random number 
	  generators will now generate ints 1 to 5. Just remember the "actual"
	  size of the floor is 5 x 5. 
	*/
	int i = 0; 
        while(i < 10){
	    int x = rnd.nextInt(5)+1;
	    int y = rnd.nextInt(5)+1;
	    if((rooms[x][y-1] != null || rooms[x][y+1] != null || 
		rooms[x-1][y] != null || rooms[x+1][y] != null) 
	       && rooms[x][y] == null){
		int roomtype = rnd.nextInt(3);
		Baseroom mroom = new Baseroom(floornum,x,y);
		if(roomtype == 0){
		    mroom.createMonsterEasy();
		}
		if(roomtype == 1){
		    mroom.createMonsterMed();
		}
		if(roomtype == 2){
		    mroom.createMonsterHard();
		}
		rooms[x][y] = mroom;
		i++;
	    }
	}
	
	/*
	  This was the easiest way to generate another room that I thought
	  of. We don't want too much treasure per floor, so only 1 of them
	  per floor. I decided to use the same algorithm to generate an 
	  additional treasure room seperately, for a total of 10 "normal"
	  rooms and 1 treasure room.
	*/
	while(i < 11){
	    int x = rnd.nextInt(5)+1;
	    int y = rnd.nextInt(5)+1;
	    if((rooms[x][y-1] != null || rooms[x][y+1] != null || 
		rooms[x-1][y] != null || rooms[x+1][y] != null) 
	       && rooms[x][y] == null){
		Baseroom troom = new Baseroom(floornum,x,y);
		troom.createTreasure();
		rooms[x][y] = troom;
		i++;
	    }
	}

	/* 
	   This code generates doors between rooms that need them. First loop
	   keeps track of how many rooms we've made doors for so far. Second and
	   third loops iterate through the entire grid. Once the loop reaches a 
	   room that's not empty, it creates whatever doors it needs.
	*/
	int j = 0;
	int xcor = 1;
	int ycor = 1;
	while(j < 11){
	    while(xcor > 0 && xcor < 6){
		while(ycor > 0 && ycor < 6){
		    if(rooms[xcor][ycor] != null){
			Baseroom b = rooms[xcor][ycor];
			if(rooms[xcor-1][ycor] != null){
			    Enviro d1 = new Enviro(Enviro.EnviroType.DOOR,xcor,ycor,55,385);
			    addThing(d1,55,385);
			}
			if(rooms[xcor+1][ycor] != null){
			    Enviro d2 = new Enviro(Enviro.EnviroType.DOOR,xcor,ycor,1311,385);
			    addThing(d2,1311,385);
			}
			if(rooms[xcor][ycor-1] != null){
			    Enviro d3 = new Enviro(Enviro.EnviroType.DOOR,xcor,ycor,683,55);
			    addThing(d3,683,55);
			}
			if(rooms[xcor][ycor+1] != null){
			    Enviro d4 = new Enviro(Enviro.EnviroType.DOOR,xcor,ycor,683,713);
			    addThing(d4,683,713);
			}
			j++;
		    }
		    ycor++;
		}
		ycor = 0;
		xcor++;
	    }
	}
	return true;
    }

}
