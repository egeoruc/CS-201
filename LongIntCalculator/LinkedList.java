package LongIntCalculator;

import static java.lang.Character.getNumericValue;

public class LinkedList {

    protected Node head;
    protected Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public LinkedList(String number){
        for(int i = number.length()-1; i >= 0; i--  ){
            char digitChar = number.charAt(i);
            int digitInt = getNumericValue(digitChar);
            insertLast(new Node(digitInt));
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Node getHead(){
        return head;
    }

    public void insertFirst(Node newNode) {
        if (isEmpty()) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void insertLast(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public void insertMiddle(Node newNode, Node previous) {
        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
    }

    /**
     * @param value The value to be searched.
     * @return The node that has the data value. If no node exists, returns null.
     */
    public Node search(int value) {
        Node tmp = head;
        while (tmp != null) {
            if (value == tmp.getData()) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    public Node getNodeI(int i) {
        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            if (index == i){
                return tmp;
            }
            index++;
            tmp = tmp.getNext();
        }
        return null;
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

    public void deleteFirst(){
        head = head.getNext();
        if (isEmpty()){
            tail = null;
        }
    }

    public Node getPrevious(Node node){
        Node tmp = head;
        Node previous = null;
        while (tmp != node) {
            previous = tmp;
            tmp = tmp.getNext();
        }
        return previous;
    }

    public void deleteValue(int value){
        Node tmp = head;
        Node previous = null;
        while (tmp != null) {
            if (tmp.getData() == value){
                if (previous != null){
                    previous.setNext(tmp.next);
                    if (tmp.next == null){
                        tail = previous;
                    }
                } else {
                    head = tmp.next;
                    if (head == null){
                        tail = null;
                    }
                }
                break;
            }
            previous = tmp;
            tmp = tmp.getNext();
        }
    }

    public void deleteLast(){
        tail = getPrevious(tail);
        if (tail != null){
            tail.setNext(null);
        } else {
            head = null;
        }
    }

    public void deleteMiddle(Node node){
        Node previous;
        previous = getPrevious(node);
        previous.setNext(node.getNext());
    }
    public boolean isZero(){
        if(isEmpty()){
            return true;
        }
        Node currentDigit = head;
        while (currentDigit != null){
            if(currentDigit.getData()!= 0){
                return false;
            }
            currentDigit  = currentDigit.getNext();
        }

        return true;
    }

    public boolean isEqual( LinkedList num2){
        if(num2.numberOfElements() != numberOfElements()){
            return false;

        }
        Node digit1 = head;
        Node digit2 = num2.getHead();

        while (digit1 != null){
            if(digit1.getData() != digit2.getData()){
                return false;

            }
            digit1 = digit1.getNext();
            digit2 = digit2.getNext();
        }

        return true;
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

    public void Reversed(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current!= null){
            next = current.getNext();
            current.setNext(prev);

            prev = current;
            current = next;
        }

        head = prev;
        System.out.println(toString());

    }
}