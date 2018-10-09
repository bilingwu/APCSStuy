import java.util.*;

public class  ArrayStuff {

    /*--------------------- Instance Variables --------------------*/ 

    private int[] a;
    Random rnd;

    /*--------------------- Constructors --------------------*/ 

    public ArrayStuff(int n){
	    rnd = new Random();
	    a = new int[n];
	    for (int i=0; i<a.length;i++){
	       a[i] = 75+rnd.nextInt(76);
	    }
    }


    /*--------------------- Methods --------------------*/ 

    public String toString(){
	    String s = "";
	    for (int i = 0; i < a.length; i++) {
	        s = s + a[i]+", ";
	    }
	    return s;
    }
    
    /*----------HOMEWORK SWAG-----------------*/
    
    public int find (int n){
        int i;;
        for (i=0; i < a.length; i++){
            if (a[i]== n){
                return i;
            } 
        }
        return -1;
    }
    
    public int maxVal (int [] arr){
        int out=arr[0];
        int i;
        for (i=0;i<arr.length; i++){
            if (arr[i]> out){
                out= arr[i];
            }
        }
        return out;
    }

    /*
    public int maxIndex (int [] arr){
        int out=0;
        for (int i=0;i<arr.length; i++){
            if (arr[i]> out){
                out= arr[i];
            }
        }
        return out;
    }
    */



    public int freq(int i){
	int out=0;
	int c;
	for (c=0; c<a.length;c++){
	    if (a[i]==a[c]){
		out+=1;
	    }
	}
	return out;
    }

    /*this method, while efficent for smaller data sets,
      it will be WILDLY inefficent for a LARGE data set
  
    public int mode(int[] a){
	int mode=a[0];
	int c=0;
	for (int i=0; i<a.length; i++){
	    if (freq(i)>c){
		mode= a[i];
		c=freq(i);
	    }
	}
	return mode;
    }
     */

    public int mode (int [] arr){
	int [] tally= new int [this.maxVal(arr) + 1];
	//java intialided the array such that all values are zero
	for (int i=0; i<arr.length; i++){
	    tally[arr[i]]+=1;
	}
	return this.maxVal(tally);
    }
    
    /*--------------------- Main --------------------*/ 

    public static void main(String[] args) {

	/*
	ArrayStuff a0 = new ArrayStuff();
	System.out.println("The array is:");
	System.out.println(a0);

	//find method testing
	System.out.println("Find Method:");
	System.out.println("Find 100:");
	System.out.println(a0.find(100));
	System.out.println("Find 52:");
	System.out.println(a0.find(52));
	System.out.println("Find 1:");
	System.out.println(a0.find(1));
	    
	//maxVal Testing 
	System.out.println("Max:");
        System.out.println(a0.maxVal());

	ArrayStuff a1 = new ArrayStuff(6);
	System.out.println("The array is:");
	System.out.println(a1);


	//freq testing
	System.out.println("Array Freq:");
	System.out.println(a1.freq(0));
	System.out.println(a1.freq(3));
	System.out.println(a1.freq(4));
	*/

	ArrayStuff a1 = new ArrayStuff(6);
	int[] foo={1,2,3,3,3,3,3,3,3,3,3,3, 9,90};
	//freq testing
	System.out.println("mode-y mode mode");
	System.out.println(a1.mode(foo));

    }
    
}


