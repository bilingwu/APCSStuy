import java.util.Random;
import java.util.Arrays;

public class Searching{
    private Comparable[] a;
    // index of the last element in the list inside a
    private int last;
    
    public Searching(){
	this(100);
    }

    public Searching(int n){
	a = new Comparable[n];
	last = -1;
    }

    public String toString(){
	return Arrays.toString(a);
    }

    public void sort(){
	Arrays.sort(a);
    }

    public void grow(){
	Comparable[] newarray = new Comparable[a.length + (a.length / 2)];
	for (int i = 0; i < a.length; i++){
	    newarray[i] = a[i];
	}
	a = newarray;
    }
    
    public void additem(Comparable n){
	if (last == a.length - 1)
	    grow();
	a[last+1] = n;
	last++;
    }

    private boolean isEqual(Comparable a, Comparable b){
	return (a.compareTo(b) == 0);
    }

    public Comparable lsearch(Comparable item){
	Comparable output;
	for (int i = 0; i <= last; i++){
	    if (isEqual(a[i], item)){
		output = a[i];
		return output;
	    }
	}
	return null;
    }

    public Comparable bsearch(Comparable item){
	Arrays.sort(a);
	int high = last;
	int testindex = last / 2;
	int low = 0;
	while (high - low >= 1){
	    if ((isEqual(a[high], item)) 
		|| (isEqual(a[low], item))
		|| (isEqual(a[testindex], item))){
		return item;
	    }
	    if (a[testindex].compareTo(item) > 0)
		high = testindex - 1;
	    else
		low = testindex + 1;
	    testindex = (low + high) / 2;
	}
	return null;	
    }

    public Comparable rbsearch(Comparable item){
	return rbsearch(item, 0, last);
    }

    public Comparable rbsearch(Comparable item, int low, int high){
	Arrays.sort(a);
	// base case
	if (high - low <= 1){
	    if ((isEqual(a[low], item)) || (isEqual(a[high], item)))
		return item;
	    else
		return null;
	}
	// recursive
	else {
	    int testindex = (low + high) / 2;
	    if (isEqual(a[testindex], item))
		return a[testindex];
	    else if (a[testindex].compareTo(item) > 0)
		return rbsearch(item, low, testindex - 1);
	    else
		return rbsearch(item, testindex+1, high);
	}
	
    }

    public static void main(String[] args){
	Random r = new Random();
	Searching s = new Searching();
	for (int i = 0; i < 100; i++){
	    s.additem( r.nextInt(100) );
	}
	System.out.println(s);
	System.out.println("Search for int 5 linearly");
	System.out.println(s.lsearch(5));
	System.out.println("After sorting:");
	s.sort();
	System.out.println(s);
	System.out.println("Binary search for 67");
	System.out.println(s.bsearch(67));
	System.out.println("Recursive binary search for 67");
	System.out.println(s.rbsearch(67));
    }


}
