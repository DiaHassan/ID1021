public class Queueadv {
    Node head;
    Node rear;

    public class Node {
        public BinaryTree.Node item;
        public Node tail;

        public Node(BinaryTree.Node item, Node list) {
            this.item = item;
            this.tail = list;
        }
        public void Nodes(Integer item, Node list) {
            item = item;
            tail = list;
        }
        public void printout(){
            Node current = this;
            System.out.print(" "+ current.item.value + " ");
            if(current.tail != null) {
                current = current.tail;
                current.printout();
            }
        }
    }

//    public Queueadv(Node fh) {head = fh;}
    public Queueadv(BinaryTree.Node fih) {
        head = new Node(fih, null);
    }
    public void add(BinaryTree.Node item) {
        if (head.tail == null) {
            rear = new Node(item, head);
            head.tail = rear;
        }
        else {
            Node temp = rear;
            rear = new Node(item,null);
            temp.tail = rear;
        }
    }

    public Integer remove() {
        Node tbr = head;
        Node tbh = head.tail;
        BinaryTree.Node tbreturned = tbr.item;
        tbr = null;
        head = tbh;
        return tbreturned.value;
    }

}

//public class Queueadv {
//    Node head;
//    Node rear;
//
//    public class Node {
//        public Integer item;
//        public Node tail;
//
//        public Node(Integer item, Node list) {
//            this.item = item;
//            this.tail = list;
//        }
//        public void Nodes(Integer item, Node list) {
//            item = item;
//            tail = list;
//        }
//        public void printout(){
//            Node current = this;
//            System.out.print(" "+ current.item + " ");
//            if(current.tail != null) {
//                current = current.tail;
//                current.printout();
//            }
//        }
//    }
//
//    //    public Queueadv(Node fh) {head = fh;}
//    public Queueadv(Integer fih) {
//        head = new Node(fih, null);
//    }
//    public void add(Integer item) {
//        if (head.tail == null) {
//            rear = new Node(item, head);
//            head.tail = rear;
//        }
//        else {
//            Node temp = rear;
//            rear = new Node(item,null);
//            temp.tail = rear;
//        }
//    }
//
//    public Integer remove() {
//        Node tbr = head;
//        Node tbh = head.tail;
//        Integer tbreturned = tbr.item;
//        tbr = null;
//        head = tbh;
//        return tbreturned;
//    }
//
//}
