public class Node {
    
    private int data;
    private Node rchild,lchild;

    public Node() {
    }

    public Node(int data) {
	this.data=data;
    }

    public int getData(){
	return data;
    }
   
    public void setRight(Node n) {
	rchild= n;
    }
    
    public Node getRight() {
	return rchild;
    }

    public void setLeft(Node n) {
	lchild= n;
    }
    
    public Node getLeft() {
	return lchild;
    }

    public void setData(int i){
	data=i;
    }

}
