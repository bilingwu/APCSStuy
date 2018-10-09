import java.io.*;
import java.util.*;

public class MakeLake {
    private int[][] Lake;
    private Random rnd = new Random();
    private int maxX, maxY;

    public MakeLake(){
	Lake= new int [][]
	    {{28, 25, 20, 32, 34, 36},
	     {27, 25, 20, 20, 30, 34},
	     {24, 20, 20, 20, 20, 30},
	     {20, 20, 14, 14, 20, 20}};

    }

    public MakeLake(int rows, int columns, int highestE){
	Lake= new int[rows][columns];
	for (int x=0; x <Lake.length;x++){
	    for (int y=0; y<Lake[x].length;y++){
		Lake[x][y]= rnd.nextInt(3 + highestE);
	    }
	}
    }


    public String toString(){
	String s= "";
	for (int y=0;y<Lake.length;y++){
		for (int x=0;x<Lake[y].length;x++){
		    s+= Lake[y][x] + "    ";
		}
		s=s+"\n";
	    }
	return s;
    }
 
    /*
      Method Stomp will take a row, column and dig 
      
      Precondition: 1<= row <= # of rows in lake - 2
                    1<= column <= # of column in lake - 2
		    1<= dig

      What Will Happen: bring the highest number of the 3X3 grid with the row and column as the coordinates of the top left hand corner down by dig units. Anything higher than the resulting number will also be brought down to that number
     */
   
    public void stomp(int row, int column, int dig){
	int R_s, C_s, highE;
	R_s = row-1;
	C_s = column -1;
	highE= 0;
	
	//finds highest value of the 3X3 starting from R_s and C_s
	
	for (int x=R_s; x <R_s+3; x++){
	    for (int y=C_s; y< C_s +3; y++){
		if (Lake[x][y] > highE){
		    highE = Lake[x][y];
		}
	    }
	}

	//the actual stomp
	for (int i=R_s; i <R_s+3; i++){
	    for (int j=C_s; j< C_s +3; j++){
		if (Lake[i][j] >= highE-dig){
		    Lake[i][j]=highE-dig;
		}
	    }
	}
	
    }

    /*
      Method finalElevation will take an int e , which is the desired finalelevation

      Precondition: 1<=e

      What it will do: find the total aggregated depth. Calculate the volume by multiplying by 6 feet x 6 feet = 72 inches x 72 inches
      
      
     */

    public int finalElevation(int e){
	int totalE=0;
	for (int x=0;x<Lake.length;x++){
	    for (int y=0;y<Lake[x].length;y++){
		if (Lake[x][y]<e){
		    totalE += e - Lake[x][y];
		}
	    }

	}
	
	return totalE * 72 *72;
    }
    
    public static void main (String[] args){
	MakeLake m = new MakeLake(4,6,32);
	System.out.println(1);
	System.out.println(m);
        m.stomp(1,4,4);
	System.out.println(2);
	System.out.println(m);
	System.out.println(m.finalElevation(22));
    }
}
