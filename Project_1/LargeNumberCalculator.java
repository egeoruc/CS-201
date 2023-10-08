package Project_1;

public class LargeNumberCalculator {

    

    //Function for adding two numbers
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
            result.insertFirst(newNode);

            if (head1 != null) {
                head1 = head1.getNext();
            }
            if (head2 != null) {
                head2 = head2.getNext();
            }
        }

        if (carry > 0) {
            Node carryNode = new Node(carry);
            result.insertFirst(carryNode);
        }

        return result;
    }

    //Function for subtract two large numbers
    public String subtractNumbers(LinkedList num1, LinkedList num2){
        //Implementation goes here
        return "";  //Placeholder
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

    //helper method to convert linkedList to a string
    private String convertToString(LinkedList linkedList){
        //Implementation goes here
        return "";  //Placeholder
    }

    public static void main(String[] args){
        //Test our methods here
        LinkedList num1 = new LinkedList();
        num1.insertFirst(new Node(2));
        num1.insertFirst(new Node(4));
        num1.insertFirst(new Node(3));

        LinkedList num2 = new LinkedList();
        num2.insertFirst(new Node(5));
        num2.insertFirst(new Node(6));
        num2.insertFirst(new Node(4));
        LinkedList num3= new LinkedList("222");
        LinkedList num4= new LinkedList("333");
        


        LargeNumberCalculator calculator = new LargeNumberCalculator();
        LinkedList result = calculator.addNumbers(num3, num4);
        System.out.println("Sum of num1 and num2: " + result.toString());
    }

}