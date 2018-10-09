import java.util.*;

public class Driver{

    private static ArrayList<Integer> al= new ArrayList<Integer>();
    
    public static void remove(){
	for (int i = 0; i<al.size()-1; i++){
	    if ( al.get(i).equals(al.get(i+1))){
		al.remove(i);
		i--;//REMEMBER THIS LINE! OTHERWISE THE METHOD WILL ONLY REMOVE EVERY OTHER REPEAT
	    }
	}
    }

    public static void main (String[] args){

	Random r = new Random();
	for (int i = 0; i < 20; i++) {
	    al.add(r.nextInt(2));
	}

	System.out.println(al);

        remove();

	System.out.println(al);

    }
}
