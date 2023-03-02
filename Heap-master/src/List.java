public class List {
    Node head;
    Node rear;

    public class Node{
        int value;
        Node next;

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    public void fast_add(int newValue){
        if (head == null){
            head = new Node(newValue, null);

        } else {
            Node newHead = new Node(newValue, head);
            head = newHead;
        }
    }
    public void slow_add(int newValue){
        if (head == null){
            head = new Node(newValue, null);
        } else {
            if(head.value > newValue){
                Node temp = new Node(newValue,null);
                temp.next = head;
                head = temp;
            }else{
                Node current = head;
                Node temp = new Node(newValue, null);
                while (current.next != null) {
                    if (current.next.value > newValue) {
                        temp.next = current.next;
                        current.next = temp;
                        break;
                    }
                    current = current.next;
                }
                current.next = temp;
            }
        }
    }
    public Node fast_remove(){
        Node temp = head.next;
        Node tbr = head;
        head = null;
        head = temp;
        return tbr;
    }
    public Node slow_remove(){
        Node current = head, beforeMin = null, minNode = head;
        while(current.next != null){
            if (current.next.value < minNode.value) {
                beforeMin = current;
                minNode = current.next;
            }
            current = current.next;
        }
        if(minNode == head){
            head = head.next;
        }
        else {
            beforeMin.next = minNode.next;
        }
        return minNode;
    }

    public void printout(){
        Node current = head;
        while(current.next != null){
            System.out.print(current.value +" ");
            current = current.next;
        }
        System.out.print(current.value +" ");
    }

}
