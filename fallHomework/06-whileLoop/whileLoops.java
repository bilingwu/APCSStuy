// SOME MORE CODING BAT PROBLEMS (yey.)


// 1. Front Times. Repeat the first 3 chars of a given string a given n number of times.
// 5 minutes

public String frontTimes(String str, int n) {
  int i=0;
  String out = "";
  while (i<n) {
    if (str.length() < 3){
      out+=str;
      }
    else {
      out+=str.substring(0,3);
    }
  i+=1;
  }
  return out;
}

//2. String Bits. Return every other character in a given string.
// 8 minutes - 5 minutes of this time was dedicated to looking for the str.charAt(#) function

public String stringBits(String str) {
  String out="";
  int i=0;
  while (i < str.length()) {
    out += str.charAt(i); //adds character at i index.
    i += 2; //every OTHER letter
    }
  return out;
}

//3. Hack the YAK. Remove part of a given string with y_k.
// 12 minutes 

public String stringYak(String str) {
  int i=0;
  String out= "";
  while (i < str.length()) {
  //will check for y_k. If true, will move past y_k and not append to output string
    if (i+2<str.length() && str.charAt(i)== 'y' && str.charAt(i+2) == 'k'){
        i+=3;
    }
    else {
      out += str.charAt(i);
      i+=1;
    }
  }
  return out;
}

//4.Match Strings. Given two strings, find the amount of pairs that match in both index and content
//15 mins- Most of this was just tweeking mathmatical errors

public int stringMatch(String a, String b) {
  int i=0;
  int out=0;
  int len=0;

  //figure out the smaller length of the two strings
  if (a.length()<=b.length()){
    len = a.length();
    }
  else {
    len = b.length ();
    }

  //compare
  while (i<len-1){
    if (a.substring(i, i+2).equals(b.substring(i, i+2))){
      out +=1;
      i += 1;
      }
    else {
      i+=1;
      }
    }
  return out;
}