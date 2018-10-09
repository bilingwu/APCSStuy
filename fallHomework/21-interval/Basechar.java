/* superclass for Priest and centurion */

import java.util.Random;
import java.util.*;
import java.io.*;

/* superclass for warrior (base class) and Mage */
public class Basechar implements Comaparable{
    private String name;
    protected int health = 100;
    //private int defense = 100;
    private int attack = 15;
    //private int level = 1;
    //private int exp = 0;
    //private int mana = 0;
    //private int armor = 0;

//----------name---------------
    public Basechar(String n) {
	    name=n;
    }
    public String getName(){
	    return name;
    }
    //---health---
    public void getHealth(){
        System.out.println("Your health is " + health);
    }

/* we were unable to incorporate these aspects of the game
//-----------DEFENSE------------
    public void setDefense(int d) {
	defense = d;
    }
    public int getDefense() {
	return defense;
    }
    
//------------ATTACK------------
    public void setAttack(int a) {
	attack = a;
    }
    public int getAttack() {
	return attack;
    }
//------------LEVEL-------------
    public void setLevel(int l) {
	level = l;
    }
    public int getLevel() {
	return level;
    }
//-------------EXP-------------
    public void setExp(int e) {
	exp = e;
    }
    public int getExp() {
	return exp;
    }
//------------MANA--------------
    public void setMana(int m) {
	mana = m;
    }
    public int getMana() {
	return mana;
    }
//------------ARMOR------------
    public void setArmor(int a) {
	armor = a;
    }
    public int getArmor() {
	return armor;
    }
*/
   
//-----------Interactions-----
    public void Delay(int x) {
	try {Thread.sleep(x);} 
	catch (InterruptedException e){e.printStackTrace();}
    }

    public String stringInput() {
	String s = "";
	Scanner a = new Scanner(System.in);
	s = a.nextLine();
	return s;
    }
	
    public void Wonder() {
	Random rand = new Random();
	for(int value = rand.nextInt(25)+1;value>0;value-=1){
	    System.out.println("Step" + "\n");
	    Delay(400);
	}	
	System.out.println("You have encountered a wild warrior!");
    }

    // attacking

    public int  Over9000(int range, Random rand) {
	return (rand.nextInt(range)+this.attack) - (rand.nextInt(range));
	    }
	
    //    public double Enemy9000(int range) {
    //	return (rand.nextInt(range)+other.attack-rand.nextInt(range) + 0.05*other.exp);
    //    }

    public void Attack(Basechar other) {	
	System.out.println("\n" + "Do you want to attack?");
        
	while (this.health > 0 || other.health > 0) {
	    String s = stringInput();
	    if (!(s.toLowerCase()).equals("yes") &&  !(s.toLowerCase()).equals("no")) {
		System.out.println("That is not a valid attack. Type 'Yes' or 'No'");
	    }
	    if ((s.toLowerCase()).equals("yes")) {
		System.out.println("You are attacking the monster!");
		Random rand = new Random();
		double damage = Over9000(8,rand);
		other.health -= damage;
		Delay(1000);
		System.out.println("The monster has taken " + damage + " damage");
		Delay(500);
		System.out.println("Monster HP: " + other.health + "\n");
		Delay(2000);
		
		System.out.println("The monster is attacking you!");
		Random rand1 = new Random();
		double CPUdamage = Over9000(8,rand1);
		this.health -= CPUdamage;
		Delay(1000);
		System.out.println("You took " + CPUdamage + " damage");
		Delay(500);
		System.out.println("Your HP: " + this.health + "\n");
		Delay(1000);
	      
		if (other.health <= 0) {
		    System.out.println("---------------------------------");
		    System.out.println("YOU WIN!");
		    System.out.println("---------------------------------");
		    Delay (1000);
		    System.out.println("To be continued");
		    break;
		}
		if (this.health <=  0) {
		    System.out.println("---------------------------------");
		    System.out.println("GAME OVER, You done goofed.");
		    System.out.println("---------------------------------");
		    break;
		}
		System.out.println("\n" + "Do you want to attack again?");
	    }

	    if ((s.toLowerCase()).equals("no")) {
		System.out.println("You have fled the fight");
		break;  
	    }
	}

    }

    public int compareTo(Object other){
	Centurion o = (Centurion)other;
        return this.getName().compareTo(o.getName());
    }
}	    
		    
    
