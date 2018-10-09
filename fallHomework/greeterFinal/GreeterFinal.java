import java.io.*;
import java.util.*;

public class GreeterFinal {
    private String greeting = new String ("Hello world");//private makes this string only accessiable by this method

    /*the word after public defines the return type of the emthod.
      In this case, we are returning a String value. If we don't want to return
      any vaue, we use the special type "void' */

    public Greeter(String s){
	greeting=s;
	    }
    public Greeter() {
	greeting = "Hello world!"
    }
    public void ungreet() {
	System.out.println("Peace out!");
    }
}
