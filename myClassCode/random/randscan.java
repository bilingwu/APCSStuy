import java.util.*;
import java.io.*;

public class randscan {
    public static void main(String[] args) {
	Random r = new Random();
	for (int i=0; i < 10 ; i++ ) {
	    // double d = Math.random();
	    // System.out.println(d);
	    // Math.random() returns a float -- between 0 & 1
	    // int j = (int)Math.random()*50;
	    // multiplying by 50 turns number into int
	    // System.out.println(j);
	    int d = r.nextInt(50);
	    System.out.println(d);
	}
	System.out.println();
	String s;
	Scanner sc = new Scanner(System.in);
	
	while (!s.equals("done")) {
	    System.out.print("Enter a line:" );
	    s=sc.nextLine();
	    System.out.println("You entered: "+s);
	

    }
}

