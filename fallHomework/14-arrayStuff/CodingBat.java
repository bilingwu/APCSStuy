public class CodingBat{
    public int sum67 (int[] nums) {
	int total = 0;
	boolean adding = true;
  	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] == 6) {
		adding = false;
	    }
	    else if (nums[i] == 7) {
		adding = true;
	    }
	    else if (adding) {
		total = total + nums[i];
	    }
	}
	return total;
    }

    public boolean more14 (int [] nums){
	int onec=0;
	int fourc=0;
	for (int i=0;i<nums.length;i++){
	    if (nums[i]==1) onec++;
	    else if (nums[i]==4) fourc++;
	}
	if (onec>fourc) return true;
        else return false;
    }

    public int[] tenRun (int[] nums){
	if (nums.length==0) return nums;//arrays length 0
	int[] out = new int[nums.length];
	int put=nums[0];
	for (int i=0; i<nums.length;i++){
	    if ((nums[i]%10)==0){
		put=nums[i];
	    }
	    else if ((nums[i]%10)!=0 && put % 10 !=0)
		{put=nums[i];}
	    out[i]= put;
	} 
	return out;
    }

    public static boolean tripleUp (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
	    if ((i - 1) != -1 && (i + 1) != nums.length) {		
	         if (((nums[i - 1] + 1) == nums[i]) && ((nums[i + 1] - 1) == nums[i])) {
		       return true;
		 }
	    }
	}
	    return false;
    }

    public boolean canBalance (int[] nums){
	for (int i=0; i<nums.length; i++){
	    int l=0; int r =0; //left and right side sums
	    for (int addend=0; addend<nums.length; addend++){
	         if (addend<=i){
	             l+= nums[addend];
	         }
	         else{
	             r+= nums [addend];
	         }
	    }
	    if (l==r) return true;
	}
	    
	return false;
    }

    public int[] seriesUp(int n) {
	int c=0;
	int[] out = new int[(n*(n+1)/2)];
	for(int i=1; i<=n; i++){
	    for(int ic=1; ic<=i; ic++){
		out[c]=ic;
		c++;
	    }
	}
	return out;
    }
}
