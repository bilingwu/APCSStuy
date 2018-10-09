import java.util.Random;
import java.util.*;
import java.io.*;

public class Driver {
    public static void main (String [] args){
        System.out.println("Welcome one and all to STUYABLO");
        System.out.println("Lets begin your journey of thrilling duels to the death and countless adventures with your character's   path");
        System.out.println("Are you a Priest or a Centurion?");
        
        
	    String fate = "";
	    Scanner a = new Scanner(System.in);
        fate = a.nextLine();
        
        if (fate.equals("Centurion")){
            System.out.println ( "What is your name, Centurion?");
            String name = "";
	        Scanner a1 = new Scanner(System.in);
            name = a1.nextLine();
            Centurion c1= new Centurion (name);
            Centurion c2= new Centurion ("enemy");
            System.out.println ("Hello, " + c1.getName()+ "! Welcome to Stuyablo!");
            
            System.out.println ("Let's begin the adventure with a walk");
            
            try {Thread.sleep(2000);} 
	        catch (InterruptedException e){e.printStackTrace();}
	        
            c1.Wonder();
            System.out.println ( "You enountered a wild monster!");
            c1.Attack(c2);
            
        }
        
        if (fate.equals("Priest")){
            System.out.println ( "What is your name, Priest?");
            String name = "";
	        Scanner a1 = new Scanner(System.in);
            name = a1.nextLine();
            Priest p1= new Priest (name);
            Priest p2= new Priest ("enemy");
            System.out.println ("Hello " + p1.getName() + "! Welcome to Stuyablo!");
            
            System.out.println ("Let's begin the adventure with a walk");
            
            try {Thread.sleep(2000);} 
	        catch (InterruptedException e){e.printStackTrace();}
	        
            p1.Wonder();
            System.out.println ( "You enountered a wild monster!");
            p1.Attack(p2);
        }
        
        
    }
}