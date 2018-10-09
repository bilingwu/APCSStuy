public class Driver {
    public static void main(String[] args){
	Wordsearch w = new Wordsearch();
	w.makePuzzle(50);
	System.out.println("This is your Puzzle");
	System.out.println(w);
	System.out.println("This is the Answer Key");
	System.out.println(w.getKey());
    }
}