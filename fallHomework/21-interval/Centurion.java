import java.util.Random;
import java.util.*;
import java.io.*;

public class Centurion extends Basechar {
    //---name---
    //MUST try to switch these into void methods
    public Centurion(String n){
        super(n);
    }
    public String getName(){
        return super.getName();
    }
    //---health---
    
    public void getHealth(){
        super.getHealth();
    }
    
    //---wonder---
    public void Wonder () {
        super.Wonder ();
    }
    
    //---attack---
    //public void Attac
    
    /*
    Contents of this block would be the beginnings of special attacks. At first, we thought we had
    enough time to make a function that would take string params that would be the special attacks.
    However, we were proven wrong. Hopefully, as we learn more tools this will become simpler,
    and more time managable. But for the time being, we were not able to do so. 
    
    
    //input
    public String stringInput() {
	    String s = "";
	    Scanner a = new Scanner(System.in);
	    s = a.nextLine();
	    return s;
    }
    
    public int  Over9000(int range, Random rand) {
	    return (rand.nextInt(range)+this.attack) - (rand.nextInt(range));
	}
	//attack
	public void Attack(Basechar other){
	    System.out.println("\n" + "Do you want to attack?");
	    while (this.health > 0 || other.health > 0) {
	        String s = stringInput();
	        if (!(s.toLowerCase()).equals("yes") &&  !(s.toLowerCase()).equals("no")) {
		        System.out.println("That is not a valid attack. Type 'Yes' or 'No'");
	        }
	        if ((s.toLowerCase()).equals("yes")) { 
	            System.out.println("Would you like to Slash or Punch?");
	            String s1 = stringInput();
	            if ((s1.toLowerCase()).equals("slash")){
	                double damage= Over9000(8,rand);
	                other.health-= damage;
	                System.out.println ("HP is");
	                other.getHealth();
	            }
                if ((s1.toLowerCase()).equals("punch")){
	                double damage1= Over9000(5,rand);
	                other.health-= damage1;
	                System.out.println ("HP is"); 
	                other.getHealth();
	            }
	            
	        }
	       
	        
	    }
    
    }
*/
}

