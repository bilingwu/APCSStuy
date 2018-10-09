import java.util.Random;

public class KnightsTour{
    
    private int[][] board;
    private int knightmoves;
    private int squares;
    private int[] startloc;
    private Random rnd = new Random();
    private boolean solved;

    public KnightsTour(){
	this(9,9);
    }

    public KnightsTour(int x, int y){
	board = new int[x][y];
	setup();
    }


    private void setup(){
	squares = (board.length - 4)*(board.length - 4);
	for(int i = 0 ; i < board.length ; i++){
	    for(int j = 0 ; j < board[i].length ; j++){
		if(i <= 1 ||
		   j <= 1 ||
		   i >= board.length-2 ||
		   j >= board.length-2){
		    board[i][j] = -1;
		}
	    }
	}
	startloc = new int[2];
        startloc[0] = rnd.nextInt(5) + 2;
        startloc[1] = rnd.nextInt(5) + 2;
	knightmoves = 0;
	solved = false;
    }

    public void delay(int time){
	try{
	    Thread.sleep(time);
	}catch (Exception e) {}
    }

    public void print(){
	System.out.println(knightmoves + "\n");
	for(int x = 2 ; x < board.length - 2; x++){
	    for(int y = 2 ; y < board[x].length - 2; y++){
	        int i = board[x][y];
		String s = String.format("%4d",i);
		System.out.printf(s);
	    }
	    System.out.println("\n");
	}
    }

    public void solve(){
	knightsTour(startloc[0],startloc[1]);
    }

    public void knightsTour(int x, int y){
	if(solved)
	    return;
	if(knightmoves >= squares){
	    solved = true;
	    print();
	    return;
	}
	if(board[x][y] != 0)
	    return;
	
	delay(100);
	knightmoves++;
	board[x][y] = knightmoves;
        print(); 
	
	//Now we test this branch in all 8 directions.
	knightsTour(x+2,y+1);
	knightsTour(x+2,y-1);
	knightsTour(x-2,y+1);
	knightsTour(x-2,y-1);
	knightsTour(x+1,y+2);
	knightsTour(x+1,y-2);
	knightsTour(x-1,y+2);
	knightsTour(x-1,y-2);

	board[x][y] = 0;
	knightmoves--;
	return;
    }

    public static void main(String[] args){
	KnightsTour k = new KnightsTour();
	k.solve();
    }

}
