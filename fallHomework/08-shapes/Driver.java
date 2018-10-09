public class Driver {
    public static void main (String [] args){
        Frame f=new Frame();
        System.out.println("expecting a 5 by 4 frame");
        System.out.println(f.frame(5,4));
        System.out.println("expecting 7 by 6");
        System.out.println(f.frame(7,6));
    }
}
