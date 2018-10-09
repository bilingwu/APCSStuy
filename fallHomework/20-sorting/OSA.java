import java.util.*;

public class OSA{
    //------------------instance variables--------------------------
    int[] data;
    int last;
    int minValIndex;
    Random rnd;
    //------------------- Constructors------------------------------
    public OSA() {
	this( 100 );
    }
    
    public OSA(int length){
    	data = new int[length];
	rnd = new Random();
    	for (int i = 0; i < length; i++){
	    data[i] = rnd.nextInt(100);
	}
	last = length - 1;
    }
    
    public OSA(int length, int[] list){
	data = new int[length];
	for (int i = 0; i < list.length; i++){
	    data[i] = list[i];
	}
    	last = list.length - 1;
    }
    
    //---------------------methody-----------------------------------
    
    public String toString(){
	String array = "";
	for (int i = 0; i < data.length; i++){
	    array+= data[i] + ", ";
	}
	return array;
    }
    
    
    public  void OrderPart(int newvalue, int templast){
        int i;
        for (i = templast; i > 0 && newvalue < data[i-1] ; i--) {
            data[i] = data[i-1];    
        }
        data[i]=newvalue;
    }
    public  void isort(){
        System.out.println("This is the start:");
        System.out.println(Arrays.toString(data));
        for (int i=0;i<data.length;i++){
            OrderPart(data[i],i );
        }
	System.out.println("This is the end:");
        System.out.println(Arrays.toString(data));
    }

    //for ssort weigh the benefits of using copyOfRange(int[] original, int from, int to) to make a subarray to compare the minimum

    public void MinValOfSubIndex (int [] arr, int startIndex){
        int minVal=arr[startIndex];
	minValIndex= startIndex;
	int i;
	//System.out.println("This is the list");
	//System.out.println(Arrays.toString(arr));
        for (i=startIndex;i<arr.length; i++){
            if (arr[i]< minVal){
                minVal=arr[i];
		minValIndex=i;
            }
        }
        //System.out.println("This is minIndex of Sublist after i="+ startIndex);
	//System.out.println(minValIndex);
    }
 
    public void ssort(){
	//System.out.println("This is before the sort");
	//System.out.println(Arrays.toString(data));
	for (int i=0; i<data.length; i++){
	    int temp= data[i];
	    MinValOfSubIndex(data,i);
	    data[i]=data[minValIndex];
	    data[minValIndex]=temp;
	    // System.out.println("This is i=" + i);
	    //System.out.println("This is minValIndex=" + minValIndex);

	}
	//System.out.println("This is after the sort");
	//System.out.println(Arrays.toString(data));
    }
 
    public static void main (String [] args){
	if (args.length > 0){
	    OSA osa= new OSA(Integer.parseInt(args[0]));
	    osa.ssort();
	    //int[] arr=  {2,3,0,5,1};
	    //osa.MinValOfSubIndex(arr,3);
	}
	else {System.out.println("you done goofed");}
    }
}
