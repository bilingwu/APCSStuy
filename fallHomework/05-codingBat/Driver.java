// 1. NonStart: concatenate everything but the first character of each given string

public String nonStart(String a, String b) {
	return a.substring(1) + b.substring(1)
}

//2. MakeAbba: concatenate the given strings 
//	in a specific order: first, second, second, first

public String makeAbba(String a, String b) {
	return a + b + b+ a;
}

//3. Difference of 21: Given an int n, return the absolute difference between n and 21, 
//	except return double the absolute difference if n is over 21

public int diff21(int n) {
	if (n> 21) {
		return 2 * (Math.abs ( 21 - n));
	}
	else {
		return Math.abs ( 21 - n);
	}
}
