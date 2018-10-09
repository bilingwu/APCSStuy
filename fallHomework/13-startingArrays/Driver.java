//---- Front 2----
//return first 2 elements of an array when given a larger array. 
//If the array length is <2 return the given list

public int[] frontPiece(int[] nums) {
    if (nums.length > 1) {
	int[] a = {nums[0], nums[1]};
	return a;
    }
    else {
	if (nums.length >0){
	    int[] a = {nums[0]};
	    return a;
	}
	else {
	    int[] a = {};
	    return a;
	}
    }
}

//----Sum 13----
//return the sumof numbers in an array excluding any 13's or any numbers following 13

public int sum13(int[] nums) {
    int sum = 0;
    if (nums.length > 0) {
	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] != 13) {
		sum = sum + nums[i];
	    }
	    else {
		i++;
	    }
	}
    }
    else {
	return sum;
    }
    return sum;
}