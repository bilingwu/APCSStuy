//1. Are the second and third letters of the word i and x in that order?
public boolean mixStart(String str) {
	if (str.length() <3) { //has to have at least the three letters to accomadate the problem
		return false;
      	}
	else {
   		String s= str.substring(1);
   		return s.startsWith("ix");
	}
}

//2. Encase a word in out (out will alawys be 4 characters)

public String makeOutWord(String out, String word) {
	String out1= out.substring(0,2);
	String out2= out.substring(2,4); //could have been out.substring(2) by function
	return out1 + word + out2;
}

//3. Given a string of even length, retrun the first half of the string
public String firstHalf(String str) {
	int halfLength = (str.length() / 2 );
	return str.substring(0, halfLength);
}
