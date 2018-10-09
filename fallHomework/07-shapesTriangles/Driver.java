public class Driver{
	public static void main(String[] args){
		Shapes s = new Shapes();
		System.out.println("expecting 4 height");
		System.out.println(s.tri1(4));
		System.out.println("expecting 5 height");
		System.out.println(s.tri1(5));
		System.out.println("expecting 4 height");
		System.out.println(s.tri2(4));
		System.out.println("expecting 5 height");
		System.out.println(s.tri2(5));
    }
}
