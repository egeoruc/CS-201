    package Project_1;

    public class LinkedList {
        
        protected Node head;
        protected Node tail;

        public LinkedList(){
            head = null;
            tail = null;
        }
        public LinkedList(String number) throws IllegalArgumentException {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("Invalid input: " + number + ". Input must be a numeric string.");
            }
    
            for (int i = number.length() - 1; i >= 0; i--) {
                char digitChar = number.charAt(i);
                int digit = Character.getNumericValue(digitChar);
                insertFirst(new Node(digit));
            }
        }

        public boolean isEmpty(){
            return head == null;
        }

        public void insertFirst(Node newNode) {
            if (isEmpty()) {
                tail = newNode;
            }
            newNode.setNext(head);
            head = newNode;
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
