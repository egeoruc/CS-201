package Lab;

public class Test {
    public static void main (String[] args){
        //Here ı can try my methods and test them if it will be work or not?
        LinkedList number1 = new LinkedList("11");
        LinkedList number2 = new LinkedList("123");
        String num3 = "";

        for(int i = 0; i< 100; i++){
            num3 += "1";
        }

        LinkedList number3 = new LinkedList(num3);

            
        LabCal calculator = new LabCal();
        LinkedList result = calculator.multiplyTest(number1, number2);
        result.Reverse();   
        
    }
}
