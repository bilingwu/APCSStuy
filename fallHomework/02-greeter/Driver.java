import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args){
	/*
	  we are declaring g to be a local
	  variable of type Greeter (which is the
	  class we defined). In java
	  we jave to say what type of stuff variables
	  hold 
	*/
	Greeter g;
	/*New does the following
	   1. allocate the memory for a new Greeter instance
	   2. Do whatever's needed to setup/ initialize the 
	      memory to be a greeter
	   3. Return the memory address (location) for it
	   4. Store that address in g

	   g now stores a reference to the greeter
	   that is, the address of the greeter.
	   The greater isn't actually stuffed into g.
	*/
	g = new Greeter();
	//this prints out the memory location of Greeter g
	//System.out.println(g);

	g.greet();
	g.ungreet();
    }

}
