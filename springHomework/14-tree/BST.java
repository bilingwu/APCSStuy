import java.io.*;
import java.util.*;
public class BST{

    private Node root;
    
    public BST(){
	root=null;
    }

    public BST(Node n){
	root= n;
    }
    public Node search(Node t, int i){
	if (t==null || t.getData()==i)
	    return t;
	else if (t.getData() < i)
	    return search(t.getRight(),i);
	else
	    return search(t.getLeft(),i);	
    }

    public String search(int i){
	Node retval = search(root,i);
	if (retval==null)
	    return "Not Found";
	else
	    return ""+retval;
    }

    public void insert(int i){
	Node n = new Node(i);
	Node t2=null;
	Node t = root;
	if (root==null){
	    root=n;
	    return;
	}
								
	while (t!=null){
	    t2 = t;
	    if (t.getData()==i)
		return;
	    else if (t.getData() < i)
		t=t.getRight();
	    else if (t.getData() > i)
		t=t.getLeft();
	    else
		return;
	}

				
	if (i>t2.getData())
	    t2.setRight(n);
	else
	    t2.setLeft(n);
    }

    public String traverse(Node t){

	Node tmp = t;
	if ( tmp == null ) {
	    return "";
	} else {
	    return traverse(t.getLeft()) +
		t.getData() + ", " +
		traverse(t.getRight());
	}


    }
    public String toString(){
	return traverse(root);
    }

    public void remove(int i){
	Node t = root;
	Node before=null;
	while (t!=null){
	    Integer holder=new Integer(t.getData());
	    Integer holder2=new Integer(i);
	    int c = holder.compareTo(holder2);
	    if (c==0){
		break;
	    }
	    if (c>0){
		before=t;
		t=t.getLeft();
	        
	    }
	    else {
		before=t;
		t=t.getRight();
	        
	    }
	}

	if (t.getRight()==null && before.getData()>i){
	    before.setLeft(t.getLeft());
	}
	else if (t.getRight()==null && before.getData()<i){
	    before.setRight(t.getLeft());
	}
	else if(t.getLeft()==null && before.getData()<i){
	    before.setRight(t.getRight());
	}
	else if(t.getLeft()==null && before.getData()>i){
	    before.setLeft(t.getRight());
	}
	else {
	    Node l=t.getLeft();
	    while (l.getRight()!=null){
		l=l.getRight();
	    }
	    
	    this.remove(l.getData());
	    t.setData(l.getData());
	}
    }



    public static void main(String[] args){
	BST t = new BST();
	Random r = new Random();
	for (int i = 0; i < 20; i ++){
	    int z = r.nextInt(100);
	    //System.out.println(z);
	    t.insert(z);
	}
	System.out.println(t);
	//				t.insert(30);
	System.out.println(t.search(30));
    }


}
