import java.io.*;
import java.util. *;

//future reference:this concept is analogous to the kids toy with the rings and the stick

public class myStack<E>{
    private Node<E> p,l;

    //make stack with dummy node, set pointer to dummy
    public myStack(){
	l= new Node<E>();
	p=l;
    }

    //add something to the top
    public void push(E data){
	Node<E> temp= new Node(data);
	l.setNext(temp);
	p=temp;
    }
    /*
    public E pop(){
        // remove and return the top item from the stack
    }

    public boolean empty(){

    }

    public E top() {
        // return the top item from the stack
    }
    */
    public String toString(){
	String s = "";
	Node<E> tmp;;
	for (tmp=l.getNext() ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	return s;
    }
}
