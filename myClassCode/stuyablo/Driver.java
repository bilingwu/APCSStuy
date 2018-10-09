public class Driver {
    public static void main( String [] args){
	BaseChar b= new BaseChar();
	Warrior w = new Warrior ();
	Mage m= new Mage ();
	System.out.println(b.getHealth());
	System.out.println(w.getHealth());
	System.out.println(m.getManna());
    }
}

