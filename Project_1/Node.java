package Project_1;

public class Node {

    protected int data;
    protected Node next;

    public Node(int data){
        this.data= data;
        this.next = null;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    
    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }
}
