public class LinkedList {
    int head;
    LinkedList tail;

    public LinkedList(int item, LinkedList list) {
        head = item;
        tail = list;
    }
    public LinkedList(int item) {
        head = item;
        tail = null;
    }
    public int head() {
        return this.head;
    }
    public LinkedList tail() {
        return this.tail;
    }
    public void append(LinkedList b) {
        LinkedList nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

//    public static int pop(LinkedList tbr) {
//        LinkedList nxt = tbr;
//        int tabr = nxt.head;
//        nxt = nxt.tail;
////        printout(nxt);
//        System.out.println("-------");
//        Test.m = nxt;
//        return tabr;
//    }
//
//    public static void push(LinkedList tbr,int n) {
//        LinkedList nxt = new LinkedList(n,null);
//        nxt.tail = tbr;
//        System.out.println("-------");
//        Test.m = nxt;
//    }
//    public int pop() {
//        LinkedList nxt = this;
//        while (nxt.tail.tail != null)
//            nxt = nxt.tail;
//        int tabr = nxt.head;
//        nxt.tail=null;
////        System.out.println("-------");
//        return tabr;
//    }

//    public void push(int n) {
//        LinkedList nxt = this;
//        while (nxt.tail != null)
//            nxt = nxt.tail;
//        nxt.tail = new LinkedList(n);
////        System.out.println("-------");
//    }
    public static void printout(LinkedList a){
        while (a.tail != null) {
            System.out.println(a.head) ;
            a = a.tail;
        }
        System.out.println(a.head) ;
    }
}
