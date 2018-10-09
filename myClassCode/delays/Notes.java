public class Notes{
    public static void main (String [] args){
	String s=" " + 12345; // points s to the String "12345"
	int i= Integer.parseInt("12345"); //converts String to int
	double d= Double.parseDouble("123.45"); //converts String to double

	System.out.println(s);
	System.out.println(i);
	System.out.println(d);

	System.out.println("You are attacked by the demon");

	try {
	    Thread.sleep(2000);
	} catch (Exception e){}

	System.out.println ("It hits");

	try {
	    Thread.sleep(4000);
	} catch (Exception e){}

	System.out.println ("And it does a huge amount of damage");
}
}
