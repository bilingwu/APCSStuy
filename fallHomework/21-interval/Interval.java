import java.util.Random;
import java.util.Arrays;

public class Interval implements Comparable{

    private int low, high;
    private static Random rand= new Random();
    //the static will allow for the rand to have the same number generator

    public void setup(int l, int h){
	high =h;
	low = l;
    }
    
    public Interval(){
        high = 1+ rand.nextInt(100);
	low = rand.nextInt(high);
	setup(low,high);
    }

    public Interval(int l, int h){
	setup(l,h);
    }
    
    public String toString(){
	return "[" + low + "," + high + "]";
    }

    //--------------homework------------------

    public int compareTo(Object other){ //twinsies signatures
	Interval o= (Interval)other;
	if (low == o.low){
	    return this.high - o.high;
	} else {
	    return this.low - o.low;
	}
    }

    //-----------------------------------------

    

    public static void main(String[] args){
	Interval i = new Interval();
	Interval s = new Interval(10,11);
	System.out.println(i.toString());
	System.out.println(s.toString());
	System.out.println(i.compareTo(s));
	
	int[] arr= new int[10];	
	for (int io=0;io<arr.length; io++){
	    arr[io]= rand.nextInt(100);
	}
	System.out.println (Arrays.toString(arr));

	String[] sa = {"frog","toad","igauna","komodo dragon","bearded lizard"};
	System.out.println(Arrays.toString(sa));
	Arrays.sort(sa);
	System.out.println(Arrays.toString(sa));

	int[] ia = {20,1,55,100,33,201,24,17,78};
	System.out.println(Arrays.toString(ia));
	Arrays.sort(ia);
	System.out.println(Arrays.toString(ia));
				
    }
    
}
