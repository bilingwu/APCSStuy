import java.util.*;
import java.io.*;

public class DepthMaze {

    private char[][] board;
    private int maxX, maxY;

    private char path= '#';
    private char wall= ' ';
    private char me = 'Z';
    private char exit = '$';
    private char visited = '.';
    private boolean solved = false;
    private int[][] neighbors = { {1,0} , {0,1} , {-1,0} , {0,-1} }; //idea from Dillon Zhang
    
    private MyStack frontier;
    private Node end;

    public void delay(int n) {
	try {
	    Thread.sleep(n);
	} catch (Exception E) {
	    
	}
    }

    public DepthMaze() {
	maxX = 40;
	maxY = 20;
	board = new char[maxX][maxY];
	
	try {
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j = 0;
	    while (sc.hasNext()) {
		String line = sc.nextLine();
		for (int i = 0; i < maxX; i++) {
		    board[i][j] = line.charAt(i);
		}
		j++;
	    }
	} catch (Exception e) {
	    System.out.println("FAIL");
	}
    }

    public String toString() {
	String s = "[2J\n";
	for (int i = 0; i < board[0].length; i++) {
	    for (int j = 0; j < board.length; j++) {
		s += board[j][i];
	    }
	    s += "\n";
	}
	return s;
    }
    //------------------DEPTH FIRST SEARCH--------------------------

    public void DFS(Node n){
	if (board[n.getX()][n.getY()] == exit) {
	    solved = true;
	    end = n;
	}

	if (solved) {
	    return;
	}

		System.out.println(this);

	board[n.getX()][n.getY()] = visited;

	delay(100);

	for (int i = 0 ; i < neighbors.length ; i++ ) {
	    char location = board[n.getX() + neighbors[i][0]][n.getY() + neighbors[i][1]];
	    if (location == path || location == exit) {
		Node temp = new Node(n.getX() + neighbors[i][0], n.getY() + neighbors[i][1]);
		temp.setPrevious(n);
		frontier.push(temp);
	    }
	} 
	DFS(frontier.pop());
    }

    public String findPath(Node temp) {
	frontier=new MyStack();

	DFS(temp);

	String path = "";
	temp = end;
	while (temp != null) {
	    path = "(" + temp.getX() + ", " + temp.getY() + ") --> " + path;
	    temp = temp.getPrevious();
	}
	return path + "$";
    }

    //-----------------------------------------------------------------
    public static void main(String[] args){
	DepthMaze z = new DepthMaze();
	//System.out.println (z);
	
	Node n= new Node(2,1);
	String s= z.findPath(n);
	

	System.out.println(s);
	
	
    }

}