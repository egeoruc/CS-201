package Project_1;

public class LargeNumberCalculator {

    public LinkedList addNumbers(LinkedList num1, LinkedList num2) {
        Node head1 = num1.getHead();
        Node head2 = num2.getHead();
        LinkedList result = new LinkedList();
        int carry = 0;
    
        while (head1 != null || head2 != null) {
            int num1Digit = (head1 != null) ? head1.getData() : 0;
            int num2Digit = (head2 != null) ? head2.getData() : 0;
            int sum = num1Digit + num2Digit + carry;
            carry = sum / 10;
            sum = sum % 10;
            Node newNode = new Node(sum);
            result.insertLast(newNode); 

            if (head1 != null) {
                head1 = head1.getNext();
            }
            if (head2 != null) {
                head2 = head2.getNext();
            }
        }
    
        if (carry > 0) {
            Node carryNode = new Node(carry);
            result.insertLast(carryNode); 
        }
    
        return result;
    }
    
    //Function for subtract two large numbers
    public LinkedList subtractNumbers(LinkedList num1, LinkedList num2) {
        Node head1 = num1.getHead();
        Node head2 = num2.getHead();
        LinkedList result = new LinkedList();
        int borrow = 0;
    
        while (head1 != null || head2 != null) {
            int num1Digit = (head1 != null) ? head1.getData() : 0;
            int num2Digit = (head2 != null) ? head2.getData() : 0;
    
            int diff = num1Digit - num2Digit - borrow;
    
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
    
            Node newNode = new Node(diff);
            result.insertLast(newNode); 
    
            if (head1 != null) {
                head1 = head1.getNext();
            }
            if (head2 != null) {
                head2 = head2.getNext();
            }
        }
    
        return result;
    }
    
    
    

    //Function for multiply two large numbers
    public String multiplyNumbers(LinkedList num1, LinkedList num2){
        //Implementation goes here
        return "";  //Placeholder
    }

    //Function for divide two large numbers
    public String divideNumbers(LinkedList num1, LinkedList num2){
        //Implementation goes here
        return "";  //Placeholder
    }

    //Helper method to create a linked List to a string 
    private Node createLinkedList (String number){
        //Implementation goes here
        return null;    //Placeholder
    }


    public static void main(String[] args){
        //Test our methods here
        Node dig1Node= new Node(9);
        Node dig3Node = new Node(8);
        Node dig2Node= new Node(9);
        LinkedList num3= new LinkedList(980);
        LinkedList num4= new LinkedList(19);
        

            
        LargeNumberCalculator calculator = new LargeNumberCalculator();
        LinkedList result = calculator.subtractNumbers(num3, num4);
        System.out.println("Sum of num1 and num2: " + result.toStringReverse());
    }

}