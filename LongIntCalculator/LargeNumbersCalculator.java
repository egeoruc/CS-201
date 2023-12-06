package LongIntCalculator;

public class LargeNumbersCalculator {


    /* this methods logic is starting from the first digit of the both numbers and
    * adding these two digits to each other and going for the next one.
    * While doing this it also considers the case that if the addition of these two numbers have more
    * than two digits. In that case it takes the first digit as a sum of digits and for next step
    * it also add the other digit ass a cary. */
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

    /*This methods logic it takes the first digit of both numbers and starts to substract them.
    If the first digit is bigger than the second number it subtract one from the next digit and
    add 10 to the first digit and keep doing the substraction with next nodes.
    * */
    public LinkedList subtractNumbers(LinkedList num1, LinkedList num2){
        Node head1 = num1.getHead();
        Node head2=  num2.getHead();
        LinkedList result= new LinkedList();
        int borrow = 0;

        while (head1 != null || head2 != null){
            int digit1 = (head1 != null)? head1.getData() : 0;
            int digit2 = (head2 != null)? head2.getData() : 0;
            int diff = digit1 - digit2 - borrow;

            if(0 > diff){
                diff += 10;
                borrow = 1;
            }else{
                borrow = 0;
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

    /*It takes the secon numbers digit and multiply it with the all the nodes in num1.
    Then it does the same thing for the other nodes of num2. But while doing it it also increasing
    position and at the and of the multiplication for that add the zeros according to position.
    At the end of it it adds all of the numbers.
    * */
    public LinkedList multiplyNumbers(LinkedList num1, LinkedList num2){
        LinkedList result = new LinkedList();
        int position = 0;
        Node digit2 = num2.getHead();

        while(digit2 != null){
            LinkedList tempResult= new LinkedList();
            int carry = 0;

            for(int i = 0; i < position; i++){
                tempResult.insertFirst(new Node(0));
            }

            Node digit1 = num1.getHead();
            while (digit1 != null){
                int product = (digit1.getData() * digit2.getData()) + carry;
                carry = product / 10;
                tempResult.insertLast(new Node(product % 10));
                digit1 = digit1.getNext();
            }

            if(carry > 0){
                tempResult.insertLast(new Node(carry));
            }

            result = addNumbers(result, tempResult);
            position ++;
            digit2 = digit2.getNext();
        }
        return result;
    }

    /*With using the help of multiplyNumbers method.
    I check is multiplying the result with num2 gives me the num1 if so this is the result I wnated.
    and If not it increases the result and check for that result value.
    * */
    public LinkedList divideNumbers(LinkedList num1, LinkedList num2){
        LinkedList result = new LinkedList("0");
        LinkedList  temp= new LinkedList("1");

        while(num1.isEqual(temp) == false){
            LinkedList one = new LinkedList("1");
            result = addNumbers(result, one);
            temp = multiplyNumbers(num2 , result);
        }

        return result;
    }

    public static void main (String[] args){
        //Here ı can try my methods and test them if it will be work or not?
        LargeNumbersCalculator test= new LargeNumbersCalculator();

        LinkedList number1_1 = new LinkedList("2");
        LinkedList number1_2 = new LinkedList("9");
        LinkedList number2_1 = new LinkedList("10");
        LinkedList number2_2 = new LinkedList("86");
        LinkedList number3_1 = new LinkedList("123456789");
        LinkedList number3_2 = new LinkedList("987949878");
        LinkedList number5_1 = new LinkedList("8484682");
        String long1 ="", long2 = "";

        for(int i=0; i<100; i++){
            long1 +="1";
            long2 +="2";
        }
        LinkedList number4_1= new LinkedList(long1);
        LinkedList number4_2= new LinkedList(long2);



        //addNumbers tests
        test.addNumbers(number2_1 ,number1_1).Reversed();
        test.addNumbers(number3_1 ,number4_2).Reversed();
        test.addNumbers(number4_1, number4_2).Reversed();


        //subtractNumbers tests
        test.subtractNumbers(number2_1 ,number1_2).Reversed();
        test.subtractNumbers(number4_1 ,number1_2).Reversed();
        test.subtractNumbers(number4_2, number4_1).Reversed();


        //multiplyNumbers tests
        test.multiplyNumbers(number2_1 ,number1_2).Reversed();
        test.multiplyNumbers(number3_1 ,number4_2).Reversed();
        test.multiplyNumbers(number4_1, number4_2).Reversed();

        //divideNumbers tests
        test.divideNumbers(number2_1,number1_1).Reversed();
        test.divideNumbers(number5_1, number1_1).Reversed();
        test.divideNumbers(number4_2, number4_1).Reversed();
        //Because of my division method my code doesn't work if number1 exactly multiple of number2

        int tested = 0 ;


    }

}