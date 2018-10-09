import java.util.*;

public class MergeSort {
    public ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){

	ArrayList<Integer> out = new ArrayList<Integer>();
	while(a.size() != 0 && b.size() != 0){
	    int h = a.get(0);
	    int k = b.get(0);
	    if (h < k){
		out.add(h);
		a.remove(0);
	    } else {
		out.add(k);
		b.remove(0);
	    }
	}
	if (a.size() != 0){
	    out.addAll(a);
	} else out.addAll(b);
	return out;
    }

    public static void main (String[] args){
	ArrayList<Integer> c, d;
	c = new ArrayList<Integer>();
	d = new ArrayList<Integer>();
	for(int i = 1 ; i < 10 ; i++){
	    c.add(i);
	    d.add(i+2);
	}
	MergeSort m = new MergeSort();
	System.out.println(m.merge(c,d));
    }
}
