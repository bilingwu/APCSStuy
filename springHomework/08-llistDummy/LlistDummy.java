public class LlistDummy{
    private Node l= null;
    private Node dummy= new Node("1");
    private int len= 1;

    public void add (String s){
	Node temp= new Node (s);
	temp.setNext(l);
	dummy.setNext(temp);
	l=temp;
    }

    public String toString(){
	String s = "";
	Node tmp;;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }
}

  
