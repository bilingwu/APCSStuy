public class ArrayStuff{
    private int[] a = new int[100];
    // private final int x=123;
    //by making x fianl, we can set it once but never change it again
    
    public String toString (){
	String s= ""+a.length;
	//this is invalid because c is declared to be final --> x=321
	s=s+" "+x;
	return s;
    }
    public static void main (String[] args){
	ArrayStuff as= new ArrayStuff();
	System.out.println(as);
    }
    /*
    public int[] hunnaints (int [] nums) {
	System.out.println(a.length);
    }
    */
}
	
