public class Driver{
    public static void main(String[] args) {
	LList1 l = new LList1();
	l.add("hello");
	l.add("world");
	for (int i=0;i<5;i++){
	    l.add(""+i);
	}
	System.out.println(l);
	System.out.println(l.find(5));
	l.insert(0,"third index");
	System.out.println(l);
        
    }
}
