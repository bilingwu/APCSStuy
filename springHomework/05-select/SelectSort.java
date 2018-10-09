/* will include the method Select(int[] A, K, L, H)
   l and h are the limits fot the election similar to the binary search
   it strarts with them at 0 and at A.length-1 and l or h change in each recursive call

1.select a pivot value (you should select A[L] or A[K])
2. swap A[H] and A[P_i] 
3. L_i = L; H_i= H-1
3.5 while H_i > L_i
4. if A[L_i]<P 
       L_i ++
  else
       swap A[L_i], A[H_i]
       H_i --
  if A[L_i]>P
       swap A[L_i], A[P_i]
  else 
       swap A[Li++], A[P_i]

  if K==P 
       done
  else 
  either select (A,K,L,P_i-1) 
         or 
	 select (A,K,P_i ++, H)
 */

public class Selection{

    public int Select(int[]A, int k, int s, int e){ //(A)rray, (k)th smallest number, (s)tarting index, (e)nding index
	int pivot = A[k];
	int l = s; int h = e;
	int temp; //used for swapping elements

	System.out.println("array: "+printA(A)+"  l: "+l+"  h: "+h+"  pivot: "+pivot);


	A[k] = A[e];
	A[e] = pivot;

	while (l < h){
	    System.out.println("array: "+printA(A)+"  l: "+l+"  h: "+h+"  pivot: "+pivot);
	    if (A[l] < pivot){
		l++;
	    } else {
		h--;
		temp = A[l];
		A[l] = A[h];
		A[h] = temp;
	    }
	}

	System.out.println("array: "+printA(A)+"  l: "+l+"  h: "+h+"  pivot: "+pivot);

	A[e] = A[h];
	A[h] = pivot;

	System.out.println("array: "+printA(A)+"  l: "+l+"  h: "+h+"  pivot: "+pivot);

	if (l == k){
	    return A[l-1];
	} else if (k > l){ //if k is beyond the index of the pivot
	    System.out.println("Loop"); 
	    return Select(A, k, l, e);
	} else {
	    System.out.println("Loop");
	    return Select(A, k, s, l);
	}
    }

    public String printA(int[] In){
	String s = "";
	for (int i: In){
	    s = s + i + " ";
	}
	return s;
    }
    public static void main(String[] args){
	int[] arr = {5, 7, 9, 8, 10, 1, 4};
	Selection q = new Selection();

	System.out.println(q.Select(arr, 3, 0, arr.length-1));
    }
}