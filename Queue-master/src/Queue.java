public class Queue {
    Node head;
    public class Node {
        public Integer item;
        public Node tail;

        public Node(Integer item, Node list) {
            this.item = item;
            this.tail = list;
        }
        public void printout(){
            Node current = this;
            System.out.print(" "+ current.item + " ");
            if(current.tail != null) {
                current = current.tail;
                current.printout();
            }
        }
    }

    public Queue() {}
    public Queue(Integer fih) {
        head = new Node(fih, null);
    }
    public void add(Integer item) {
        Node current = head;
        while(current.tail != null)
            current = current.tail;
        current.tail = new Node(item,null);
    }

    public Integer remove() {
        Node tbr = head;
        Node tbh = head.tail;
        Integer tbreturned = tbr.item;
        tbr = null;
        head = tbh;
        return tbreturned;
    }

}
