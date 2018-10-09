import java.io.*;
import java.util.*;

public class Driver2 {

    public static void main(String[] args){
	Greeter g1;
	Greeter g2,g3; //Assign two variables at a time
	g2 = new Greeter ();
	g3=g2; //g3 is assigned the value and location of g2
	
	g1 = new Greeter();
	System.out.println("Before");
	System.out.println("g1 is at" + g1);
	System.out.println("g2 is at" + g2);
	System.out.println("g3 is at" + g3); //same chiz as 2

	g2=new Greeter();
	System.out.println("After");
	System.out.println("g1 is at" + g1);
	System.out.println("g2 is at" + g2);
	System.out.println("g3 is at" + g3);//g3 is not changed

	/*Garabage collection clears up memory we're not using anymore
	  but IT CAUSES DELAY */
    }
}
