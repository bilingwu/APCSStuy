//Word Search by Justin Pacquing and Jeffrey Zou
import java.util.*;
import java.io.*;

public class WordSearch{
  private char[][] wordGrid;
  private ArrayList <String> hidden;
  private ArrayList <String> possible; //Optional
  
  //Default Constructor
  public WordSearch() {
    //Sets the grid to 10x10
    wordGrid = new char[10][10];
    for (int i=0;i<wordGrid.length;i++) 
      for (int j=0;j<wordGrid[i].length;j++) 
        wordGrid[i][j] ='-';
    hidden = new ArrayList<String>();
  }
  
  public WordSearch (int rows, int cols) {
    wordGrid = new char[rows][cols];
    for (int i=0;i<wordGrid.length;i++) 
      for (int j=0;j<wordGrid[i].length;j++) 
        wordGrid[i][j]='-';
    hidden = new ArrayList<String>();
  }
  
  public String toString() {
    String grid = "";
    for (int i = 0; i < wordGrid.length; i++) {
      for (int j = 0; j < wordGrid[i].length; j++) {
        grid += (wordGrid[i][j] + " ");
      }
      grid += "\n";
    }
    grid += ("\n" + "Words in Grid: \n");
    for (int k = 0 ; k < hidden.size(); k++) {
      grid += (hidden.get(k) + "\n");
    }

    return grid;
  }
  
  public boolean addWordH(int row, int col, String s) {
    // If enough space to go forward, check forward; If result is false, Check Backwards
    // If not enough space to go foward, check backwards; enough space, then whats in spaces
    if (row < 0 || col < 0 || row >= wordGrid.length || col >= wordGrid[0].length ) // does not allow un-reasonable indexes
      return false;
    boolean canAddFor = true;
    if (s.length() <= (wordGrid[row].length - col) ){ //Checks if enough "space" for String going forward
	for (int i = col, j = 0; i < (s.length() + col); i++, j++){ //j is index of String
	    if (wordGrid[row][i] != '-'){
		if (wordGrid[row][i] != s.charAt(j)){
		    canAddFor = false;
		}
	    }
	}
    }
    
    else
      canAddFor = false;
    
    if (canAddFor == true){ //If can add forward, won't check backwards
	hidden.add(s);
	for (int a = col, b = 0; b < s.length(); a++, b++)
	    wordGrid[row][a] = s.charAt(b);
	return true;
    }
    
    else{ //Backwards Check
      boolean canAddBack = true;
      if (s.length() <= (col + 1) ){ // Length Check
	  for (int x = col, y = 0; y < s.length(); x--, y++){
	      if (wordGrid[row][x] != '-'){
		  if (wordGrid[row][x] != s.charAt(y)){
		      canAddBack = false;
		      return false;
		  }
	      }
	  }
      }
      else
        return false;
      if (canAddBack = true){
	  hidden.add(s);
	  for (int m = col, n = 0; m>= (col + 1 - s.length()); m--, n++){
	      wordGrid[row][m] = s.charAt(n);
	  }    
	  return true;
      }
    }
    return false;
  }

  public boolean addWordV(int row, int col, String s) {
    if (row < 0 || col < 0 || row >= wordGrid.length || col >= wordGrid[0].length) 
	 return false;
    
    boolean canAddDown = true;  
    if (s.length() <= (wordGrid[col].length - row)) {
    	for (int i=row, j =0;i < s.length()+row;i++,j++)
      		if (wordGrid[i][col] != '-')
      			if (wordGrid[i][col] != s.charAt(j))
      				canAddDown = false;
    }
    else {
    	canAddDown = false;
    }
    
    if (canAddDown) {
    	hidden.add(s);
	for (int a =row, b = 0; b < s.length(); a++, b++)
    		wordGrid[a][col] = s.charAt(b);
    	return true;
    }
    
    else {
    	boolean canAddUp = true;
    	if (s.length() <= row + 1){
	    for (int p=row, q=0; q < s.length(); p--, q++){
		if (wordGrid[p][col] != '-'){
		    if (wordGrid[p][col] != s.charAt(q)){
			canAddUp = false;
			return false;
		    }
		}
	    }
	}
	else{
	    canAddUp = false;
	    return false;
	}
    	if (canAddUp) {
	    hidden.add(s);
	    for (int x = row, y = 0; y < s.length(); x--, y++){
		wordGrid[x][col] = s.charAt(y);
	    }
    	    return true;
    	}
    }
    return false;
  }

  public boolean addWordD(int row, int col, String s) {
    //Check avaiable spaces vertically and horizontally if each >= s.length()
    //Can only add if true for both axis
    if (row < 0 || row >= wordGrid.length || col < 0 || col >= wordGrid.length ) // Unreasonable Indexes
      return false;
    boolean canAddFor = true;
    if ( (wordGrid.length - row) >= s.length() && (wordGrid[row].length - col) >= s.length() ){ //Checks availabe forward space
	for (int i = row, j = col, k = 0; k < s.length(); i++, j++, k++){ // Checks spaces for value; restriction by checking horizontal length 
	    if (wordGrid[i][j] != '-' && wordGrid[i][j] != s.charAt(k)){
		canAddFor = false;
	    }
	}
    }
    else {
      canAddFor = false;
    }
    if (canAddFor == true) {
	hidden.add(s);
	for (int a = row, b = col, c = 0; c < s.length(); a++, b++, c++)
	    wordGrid[a][b] = s.charAt(c);
	return true;
    }
    else { 
      boolean canAddBack = true;
      if ( (row + 1 >= s.length()) && (col + 1 >= s.length()) ) { //Checks available backwards space
	  for(int x = col, y = row, z = 0; x >= (col - s.length() + 1); x--, y--, z++){
	      if( wordGrid[x][y] != '-' && wordGrid[x][y] != s.charAt(z)){
		  return false;
	      }
	  }
      }
      else {
        return false;
      }
      if (canAddBack == true) {
	  hidden.add(s);
	  for(int f = col, o = row, g = 0; g < s.length() ; f--, o--, g++)
              wordGrid[f][o] = s.charAt(g);
	  return true;
      }
    }
    return false;
  }
 
  public void fillGrid() {
    Random r = new Random();
    for (int i=0;i<wordGrid.length;i++) 
      for (int j=0;j<wordGrid[i].length;j++)
        if (wordGrid[i][j] == ('-')) {
          char[] alphabet ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	  char c = alphabet[r.nextInt(26)];
          wordGrid[i][j] = c;
        }
  }
    
    public ArrayList<String> loadDictionary() {
	String s = "zzz";
	ArrayList<String> dictionary = new ArrayList<String>();
	
	try {
	    FileReader f = new FileReader("wordlist.txt");
	    BufferedReader b = new BufferedReader(f);
	    
	    while( s != null ) {
		s = b.readLine();
		if ( s != null )
		    dictionary.add(s);
            }
        }
	catch (IOException e) {}
	
	return dictionary;
    }   
    
    public void addWords(int n){
	Random r = new Random();
	ArrayList<String> diction = loadDictionary();
	while (hidden.size() < n){
		boolean addedYet = false;
		while (addedYet == false){
			String possWord = (diction.remove(r.nextInt(diction.size()))).toLowerCase();
			for (int row = 0; row < wordGrid.length && addedYet == false; row++){
				for(int col = 0; col < wordGrid[row].length && addedYet == false; col++){
					if (addWordH(row, col, possWord)) {
					    addedYet = true;
					}
					else if (addWordD(row, col, possWord)){
					    addedYet = true;
					}
					else if (addWordV(row,col,possWord)) {
					    addedYet = true;
					}
				}
			}
		}
	}
    }	
		     
  
  public static void main(String[] args){
      WordSearch ws = new WordSearch(); 
      
      /*
      //working horizontal words
      ws.addWordH(0, 0, "hello");
      ws.addWordH(2, 4, "batman");
      ws.addWordH(5, 1, "apple");
      
      //Horizontal index error checkingh
      ws.addWordH(-2, 4, "joker");
      ws.addWordH(10, 4, "unicorn");  
      ws.addWordH(3, -1, "cowboys");
      ws.addWordH(5, 8, "dogs");
      
      //horizontal collision checking
      ws.addWordH(5, 3, "plow");
      ws.addWordH(2, 0, "neato");
      
      
      // working vertical words
      ws.addWordV(1, 0, "nice");
      ws.addWordV(4, 9, "yankee");
      ws.addWordV(4, 4, "old");
      
      //Verical index error checking
      ws.addWordV(-2, 4, "joker");
      ws.addWordV(7, 4, "unicorn");   
      ws.addWordV(3, -1, "cowboys");
      ws.addWordV(5, 20, "dogs");
      
      //vertical collision checking
      ws.addWordV(0, 4, "ores");
      ws.addWordV(4, 9, "goober");
      
      
      //working diagonal words
      ws.addWordD(7, 0,  "cat");
      ws.addWordD(0, 0, "home");
      ws.addWordD(0, 3, "loam");
      //Diagonal index error checking
      ws.addWordD(-2, 0,  "cat");
      ws.addWordD(3, -1,  "whelm");
      ws.addWordD(7, 7,  "after");    
      
      //Diagonal collision checking
      ws.addWordD(0, 4, "ores");
      ws.addWordD(4, 4, "oats");
      */
      
     
      System.out.println(ws);
      ws.addWords(10);
      System.out.println(ws);
 
      ws.fillGrid();
      System.out.println(ws); 
  }
}
