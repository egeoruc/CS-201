package Project_1;

public class LinkedList {
    
    protected Node head;
    protected Node tail;

    public LinkedList(){
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }
    
    public Node getHead(){
        return head;
    }
    
    public int numberOfElements(){
        Node tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            result.append(tmp).append(" ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }

}
