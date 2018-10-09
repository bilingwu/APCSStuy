// some coding bat problems

//1. Explosion of a given string

public class codingBat{
	public String stringSplosion(String str) {
  		int i;
  		String out ="";
  		for (i=1; i<=str.length();i++){
    			out += str.substring (0,i);
  		}
  		return out;
	}


// 2. X. Remove any X that is not in the 0th or last index from a given string
	public String stringX(String str) {
  		int i;
  		String out="";
  		for (i=0;i<str.length();i++){
    			if (i==0 || i == str.length()-1){
      				out += str.charAt(i);
    			}
    			else {
      				if (str.charAt(i)!='x'){
       					out+=str.charAt(i);
      				}
    			}
  		}
  		return out;
		}
	}
}