public class Shapes{
	//20 mins
	public String tri1(int h){
		int row=0; //will count up
		String out=""; //output string
		while (row<=h){
			int column=1;
			while (row >= column){
				out+="*";
				column+=1;
			}
			out+="\n";
			row+=1;	
		}
        return out;
	}
	//15 mins
	public String tri2 (int h) {
		int row=0;
		
		String out= "";
		while (row <=h) {
			int column = 0;
			while (column <=h){
				if (column > h - row) {
					out+="*";
				}
				else {
					out += " ";
				}
				column +=1;
			}
			out += "\n";
			row +=1;
		}
        return out;
    }
<<<<<<< HEAD

    //PART 2

    public String tri3(int h){
	int c=0;
	out =""
	for (
    }
=======
    	public String tri3 (int h){
        	int star;
        	int row= 0;
        	int space;
        	String out= "";
        	while (row <= h-1){
        		 //the number of spaces in the front is the height - row #
        		 for (space= h - (row + 1); space >0; space--){
        		 	out+=" ";
        		 }
            		//# of stars in nth row is 2n+1 by Pascals Triangle
            		for (star= 1 + (2 * (row)) ; star >0; star --){
              			out += "*";
                
        		 }
        		 out +="\n";
        		 row += 1;
        	}
        return out;
    }
    
//not working method
	 public String diamond (int h){
	  	Shapes s= new Shapes();
        	String out = s.tri3(h/2 +1); //make top half of diamond
        	int row = h/2 +2;
        	int space;
        	int star;
        	while (row <=h){
            		for (space= (h/(2- row+1)); space>=0; space--){
                	out += " ";
        		 }
            		for (star = 1 + 2 *(h - row +1 - h%2); star >=0; star --){
                		out += "*";
            		}
            		out+="\n";
            		row +=1;
        	}
        	return out;
    	}
}
