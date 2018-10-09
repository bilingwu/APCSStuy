import java.util.*;

public class Driver{
    public static ArrayList<Integer> randPerm (ArrayList<Integer> a){
        ArrayList<Integer> outy= new ArrayList<Integer>(a.size());
        for (int m= 0; m<a.size(); m++){
            outy.add(m);
        }
       // System.out.println("this is what the initial outy");
       // System.out.println(outy);
	    Random r = new Random();
        for(int i=0;i<a.size();i++){
            int rndIndex = r.nextInt(a.size());
            while (outy.get(rndIndex) == a.get(i)){
                rndIndex = r.nextInt(a.size());
            }
            /* Debugging is fun!-_-'
            System.out.println("yey degugging");
            System.out.println("num:"+i);
            System.out.println("index:" +rndIndex);
            System.out.println("end debug");
            */
            outy.set(rndIndex, a.get(i));
        }
        System.out.println("this is the final outy");
        return outy;
            
    }
    
    
    public static void main (String[] args) {
        ArrayList <Integer> test= new ArrayList<Integer>();
        
        for ( int i =0; i<1000; i++){
            test.add(i);
        }
        
        //System.out.println("this is your tesy arraylist");
        //System.out.println(test);
       System.out.println(randPerm(test));
    }
}
