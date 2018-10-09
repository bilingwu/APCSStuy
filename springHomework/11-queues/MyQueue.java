import java.io.*;
import java.util.*;

public class MyQueue<E>{

    Node<E> n,first,last; //dummy node at front and back, and a pointer node
    
    public MyQueue(){
	n= new Node<E>();
	first= n;
	last =n;
	first.setNext(last);
    }
    
    public void enqueue(E data){
	Node<E> tmp= new Node<E>(data);
        n.setNext(tmp);
	n=n.getNext();
	last=n.getNext();
    }
    
    public E dequeue(){
	E tmp= first.getNext().getData();
        first.setNext(first.getNext().getNext());
	return tmp;
    }

    public boolean empty(){
	return first.getNext()==null; //assuming that the queue wont be null,null,something, null
    }

    public E head(){
	return first.getNext().getData();
    }
  
    public String toString(){
	String s = "";
	Node<E> tmp;;
	for (tmp=first ; tmp!=last ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s= s + "null";
	return s;
    }
}
