import java.io.*;
import java.util.*;

public class DriverFinal{
    public static void main (String [] args) {
	/*GreeterFinal g1 =new GreeterFinal ();
	GreeterFinal g2 =new GreeterFinal();
	String s= g1.setGreeting("Sup!");
	String p= g2.setGreeting("Howdy");
	System.out.println("g1's greeting is" + s);
	System.out.println("g2's greeting is" + p);*/
	GreeterFinal g2= new Greeter ("Hi there");
	System.out.println(g2.greet())

    }
}
