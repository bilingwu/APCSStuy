import java.io.*;
import java.util.*;

public class Strings{
	private String first,last; //instance variable
	private int space;
	//constructors 
	public Strings ( String name) {
		space= name.indexOf( ' ');
		first= name.substring (0, space);
		last= name.substring (space + 1, name.length())
	}
	public Strings() {
		first="none";
		last="none";
	}

	//method

	/*testing purposes 
	public int spaceOut() {
		return space;
	}
	*/
	public String firstName(){
		return first;
	}
	public String lastName(){
		return last;
	}
}
