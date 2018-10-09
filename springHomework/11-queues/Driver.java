import java.util.*;
import java.io.*;

public class Driver{
    public static void main (String [] args){
	MyQueue<Integer> mq= new MyQueue<Integer>();
	mq.enqueue(1);
	mq.enqueue(2);
	System.out.println(mq);

	System.out.println(mq.dequeue());
	System.out.println(mq);

	System.out.println(mq.empty());

	System.out.println(mq.head());
    }
}
