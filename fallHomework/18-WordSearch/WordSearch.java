import java.io.*;
import java.util.*;

public class Wordsearch {
    /* ---------------------------------- Instance Variables -------------------------------- */
    private char[][] board,key;
    private int maxRows, maxCols;
    private ArrayList<String> words =  new ArrayList<String>();
    private ArrayList<String> inPuzzle = new ArrayList<String>();
    private Random rnd = new Random();
    /* ---------------------------------- Constructors -------------------------------- */
    public Wordsearch(){
	this(20,40);
    }
    public Wordsearch(int r, int c){
	Scanner sc = null;
	try {
	    sc = new Scanner(new File("words.txt"));
	} catch (Exception e){
	    System.out.println("Can't open word file");
	    System.exit(0);
	}

	while (sc.hasNext()){
	    words.add(sc.next());
	}

	board = new char[r][c];
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		board[i][j] = '.';
	    }
	}
	maxRows = r;
	maxCols = c;
    }
    /* ---------------------------------- Methods -------------------------------- */

    public String toString(){
	String output = "";
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		output+= board[i][j];
	    }
	    output+= "\n";
	}
	return output;
    }

    public boolean checkBounds(String w, int row, int col, int deltaRow, int deltaCol){
	boolean outofbounds = false;

	deltaRow = deltaRow*w.length();
	deltaCol = deltaCol*w.length();

	if ((deltaRow == 0) && (deltaCol == 0))
	    return outofbounds;
	if ((row + deltaRow <= 0) || (row + deltaRow >= board.length)) outofbounds = true;
	if ((col + deltaCol <= 0) || (col + deltaCol >= board[0].length)) outofbounds = true;
	return outofbounds;
    }

    public boolean checkIllegalOverlap(String w, int row, int col, int deltaRow, int deltaCol){
	int r = row;
	int c = col;
	boolean illegalOverlap = false;
	for (int i = 0; i < w.length(); i++){
	    if ((board[r][c] != '.') && (board[r][c] != w.charAt(i))){
		illegalOverlap = true;
		break;
	    }
	    r+= deltaRow;
	    c+= deltaCol;
	}
	return illegalOverlap;
    }

    public boolean addWord(String w){
	boolean output = false;

	int r = rnd.nextInt(maxRows);
	int c = rnd.nextInt(maxCols);
	int deltaR = rnd.nextInt(3) - 1;
	int deltaC = rnd.nextInt(3) - 1;
	boolean Bounds = checkBounds(w,r,c,deltaR,deltaC);
	if (Bounds){
	    output = false;
	}else{
	    boolean Illegal = checkIllegalOverlap(w,r,c,deltaR,deltaC);
	    if (!(Illegal)){
		addWord(w,r,c,deltaR,deltaC);
		output = true;
	    }
	    else{
		output = false;
	    }
	}
	return output;
    }
    // to add a word to a specified location with a specified direction
    public void addWord(String w, int row, int col, int deltaRow, int deltaCol){
	int r = row;
	int c = col;
	boolean checkBounds = checkBounds(w,r,c,deltaRow,deltaCol);
	if (!checkBounds){
	    boolean illegalOverlap = checkIllegalOverlap(w,r,c,deltaRow,deltaCol);
	    if (illegalOverlap){
		System.out.println("Illegal Overlap");
	    }
	    else {
		for (int i = 0; i < w.length(); i++){
		    board[r][c] = w.charAt(i);
		    r+= deltaRow;
		    c+= deltaCol;
		}
	    }
	}
    }
    public void makeKey() {
	key = new char[board.length][board[0].length];
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
		if (board[i][j] == '.') {
		    key [i][j] = '.';
		} else key[i][j] = board[i][j];		
	    }
	}
    }
    public String getKey(){
	String output = "";
	for (int i = 0; i < key.length; i++){
	    for (int j = 0; j < key[i].length; j++){
		output+= key[i][j];
	    }
	    output+= "\n";
	}
	System.out.println(inPuzzle);
	return output;
    }

    public void makePuzzle(int n){
	while (n > 0){
	    int wordIndex = rnd.nextInt(words.size());
	    String word = words.get(wordIndex);
	    if (addWord(word)) {
		n--;
		words.remove(wordIndex);
		inPuzzle.add(word);
	    }
	}
	makeKey();
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		if (board[i][j]=='.'){
		    String letters = "abcdefghijklmnopqrstuvwxyz";
		    char letter = letters.charAt(rnd.nextInt(letters.length()));
		    board[i][j]=letter;
		}
	    }
	}
    }
}