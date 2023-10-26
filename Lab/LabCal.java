package Lab;

import Project_1.LargeNumberCalculator;

public class LabCal {


    //It will take arguments as a LinkedList and return LinkedList
    // I will implement a toString method for LinkedList later
    public LinkedList addNumbers(LinkedList num1, LinkedList num2){
        Node head1 = num1.getHead();
        Node head2=  num2.getHead();
        LinkedList result= new LinkedList();
        int carry = 0;

        while(head1 != null || head2 != null){
           int digit1 = (head1 != null)? head1.getData() : 0;
           int digit2 = (head2 != null)? head2.getData() : 0;

           int sum = digit1 + digit2 + carry;

           carry = sum / 10 ;
           sum = sum % 10 ;

           Node newNode= new Node(sum);
           result.insertLast(newNode);

           if(head1 != null){
                head1 = head1.getNext();
           }
           if(head2 != null){
                head2 = head2.getNext();
           }
        }

        if( carry > 0){
            Node carryNode = new Node( carry);
            result.insertLast(carryNode);
        }


        return result;
    }


    public LinkedList subtractNumbers(LinkedList num1, LinkedList num2){
        Node head1 = num1.getHead();
        Node head2=  num2.getHead();
        LinkedList result= new LinkedList();
        int barrow = 0;

        while (head1 != null || head2 != null){
            int digit1 = (head1 != null)? head1.getData() : 0;
            int digit2 = (head2 != null)? head2.getData() : 0;
            int diff = digit1 - digit2 - barrow;

            if(0 > diff){
                diff += 10;
                barrow = 1;
            }else{
                barrow = 0;
            }

            Node diffNode = new Node(diff);
            result.insertLast(diffNode);

            if(head1 != null){
                head1 = head1.getNext();
            }
            if(head2 != null){
                head2 = head2.getNext();
            }
        }

        return result;
    }

    public LinkedList multiplyNumbers(LinkedList num1, LinkedList num2) {
        LinkedList result = new LinkedList(); 
    
        Node num2Digit = num2.getHead();
        int position = 0;
    
        
        while (num2Digit != null) {
            int carry = 0;
            LinkedList tempResult = new LinkedList(); 
    
            
            for (int i = 0; i < position; i++) {
                tempResult.insertFirst(new Node(0));
            }
    
            
            Node num1Digit = num1.getHead();
            while (num1Digit != null) {
                int product = (num2Digit.getData() * num1Digit.getData()) + carry;
                carry = product / 10;
                tempResult.insertLast(new Node(product % 10));
                num1Digit = num1Digit.getNext();
            }
    
            
            if (carry > 0) {
                tempResult.insertLast(new Node(carry));
            }
    
            
            result = addNumbers(result, tempResult);
            position++;
            num2Digit = num2Digit.getNext();
        }
    
        return result;
    }

    public LinkedList multiplyTest (LinkedList num1, LinkedList num2){
        LinkedList result = new LinkedList();
        int position = 0;
        Node num2digit = num2.getHead();

        while(num2digit != null){
            int carry = 0;
            LinkedList tempResult = new LinkedList();

            for (int i = 0; i<position; i++){
                tempResult.insertFirst(new Node(0));
            }

            Node num1digit = num1.getHead();
            while(num1digit != null){
                int product = (num1digit.getData() * num2digit.getData())+ carry;
                carry = product / 10;
                tempResult.insertLast(new Node(product % 10));
                num1digit = num1digit.getNext();
            }

            if ( carry>0){
                tempResult.insertLast(new Node(carry));
            }

            result = addNumbers(result, tempResult);
            position ++;
            num2digit = num2digit.getNext();
        }
        
        return result;
    }
    
    
    

    //function fot divide two large numbers
    //It will take arguments as a LinkedList and return LinkedList
    // I will implement a toString method for LinkedList later
    public LinkedList divideNumbers(LinkedList num1, LinkedList num2){
        //functions logic will br implemented to here
        return null;//Placeholder
    }



}