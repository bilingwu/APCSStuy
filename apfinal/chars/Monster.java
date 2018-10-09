package chars;

import thing.*;
import rooms.*;
import enviro.*;
import items.*;
import java.lang.Math.*;

/*
  Your two types of monsters are Substitutes and Bosses. Subs are basic 
  enemies, that only do dmg via contact. We were going to make the bosses
  have attack patterns and ranged attack and everything (just like Isaac) 
  but ran into complications, so we stuck to just spawning the Subs for now.
  The autoMove simply moves the monster in the direction of the player.
*/

public class Monster extends Basechar{

    /*----------------------- Enums --------------------------*/

    public enum MonsterType{
	SUBSTITUTE, BOSS
    }

    private MonsterType monsterType;

    public MonsterType getMonsterType(){
	return monsterType;
    }

    /*------------------- Constructors ---------------------*/

    public Monster(MonsterType m, int f, int rx, int ry, int x, int y, int difficulty){
	super(Thing.Type.ENEMY,f,rx,ry,x,y);	
	setup(m,difficulty);
    }

    private void setup(MonsterType m, int difficulty){
	switch(m){
	case SUBSTITUTE:
	    monsterType = Monster.MonsterType.SUBSTITUTE;
	    setMaxHP(1+difficulty);
	    setCurrentHP(getMaxHP());
	    setAtk(1);
	    break;
	case BOSS:
	    monsterType = Monster.MonsterType.BOSS;
	    setMaxHP(50);
	    setCurrentHP(getMaxHP());
	    setAtk(2);
	    break;
	}
    }

    /*----------------------- Methods -------------------------*/

    public void autoMove(Hero player){
	int[] playerPos = player.getPosInRoom();
	int[] thisPos = this.getPosInRoom();
	int dx = Math.abs(playerPos[0] - thisPos[0]);
	int dy = Math.abs(playerPos[1] - thisPos[1]);
	if (dx > dy){
	    if (thisPos[0] > playerPos[0])
		this.setDir(Thing.Direction.LEFT);
	    else if (thisPos[0] < playerPos[0])
		this.setDir(Thing.Direction.RIGHT);
	}
	else {
	    if (thisPos[1] >  playerPos[1])
		this.setDir(Thing.Direction.UP);
	    else if (thisPos[1] < playerPos[1])
		this.setDir(Thing.Direction.DOWN);
	}
	super.move();
    }
	
    public boolean dealDmg(Basechar player){
	player.setCurrentHP(player.getCurrentHP() - this.getAtk());
	return true;
    }
    
}

    
