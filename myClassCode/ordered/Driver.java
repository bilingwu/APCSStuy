public class Driver{
    int[] a;
    
    public static void addNewVal(int n){
	for (int i=last; i>0 && a[i-1] > n; i--){
	    a[i]=a[i-1];
	}
	a[i]=n;
    }
    public static void main (String[] args){
	
    }
}
