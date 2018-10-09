public class Box {
    public String boxit (int a, int b){
	int row=1;
	int column=1; 
	String box="";
        while (a>=row){
	    if (b>=column){
		box+="*";
		column+=1; 
	    }
	    else {
		box += "\n";
		column=1;
		row +=1;
	    }
	}
	return box;
    }
}
