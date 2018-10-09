public class DriverBox {
    public static void main (String[] args){
	Box boxy = new Box();
	System.out.println("expecting 3 rows and 3 columns");
	System.out.println(boxy.boxit(3,3));
	System.out.println("expecting 4 rows and 5 columns");
	System.out.println(boxy.boxit(4,5));	
	System.out.println("expecting 7 rows and 8 columns");
	System.out.println(boxy.boxit(7,8));
    }
}
