import java.util.Random;

public class DLinkedList {
    int numb;
    DLinkedList next;
    DLinkedList prev;
    public static void main(String[] args){
        Main.dll = Dlistgenerator(10);
        DLinkedList ftest = new DLinkedList(200,null,null);
        Main.dll.removeDoubly(9);
        printout(Main.dll);
        System.out.println("-----");
        Main.dll.add(ftest);
        printout(Main.dll);
    }
    public DLinkedList(int item, DLinkedList after,DLinkedList before) {
        numb = item;
        next = after;
        prev = before;
    }
    public DLinkedList(int item) {
        numb = item;
        next = null;
        prev = null;
    }
    public int numb() {
        return this.numb;
    }
    public DLinkedList next() {
        return this.next;
    }
    public DLinkedList prev() {
        return this.prev;
    }
    public void append(DLinkedList b) {
        DLinkedList nxt = this;
        while (nxt.next != null) {
            nxt = nxt.next;
        }
        nxt.next = b;
    }
    public static DLinkedList Dlistgenerator(int n){
        Random rnd = new Random();
        DLinkedList tbr = new DLinkedList(0,null,null);
        for (int i = 1; i < n; i++)
            tbr.append(new DLinkedList(i,null,tbr));
        return tbr;
    }
    public void add(DLinkedList tba) {
        tba.next = Main.dll;
        tba.prev = null;
        Main.dll = tba;
    }
//    public void remove(int n){
//        DLinkedList nxt = this;
//        if(n == 0){
//            Main.dll = Main.dll.next;
//            Main.dll.prev = null;
//        }
//        for (int i = 0; i <= n && nxt.next != null; i++){
//            if (n == i){
//                nxt.next = nxt.next.next;
//                System.out.println("---");
//                printout(nxt);
//                System.out.println("---");
//                nxt.next.prev = nxt;
////                printout(nxt);
////                System.out.println("---");
//                break;
//            }
//            nxt = nxt.next;
//        }
//    }
    public void remove(int index) {
        DLinkedList nxt = this;
        int temp = 0;

        if(index == 0) {
            Main.dll = nxt.next;
            Main.dll.prev = null;
            return;
        }

        while(nxt.next != null) {
            temp++;
            if(temp == index) {
                nxt.next = nxt.next.next;
                nxt.next.prev = nxt;
                return;
            }
            nxt = nxt.next;
        }
    }

    public static void printout(DLinkedList a){
        while (a.next != null) {
            System.out.println(a.numb) ;
            a = a.next;
        }
        System.out.println(a.numb) ;
    }
    public void removeDoubly(int index) {
        DLinkedList removeFrom = this;
        if (index == 0) {
            Main.dll = Main.dll.next;
            Main.dll.prev = null;
        } else {
            for (int k = 0; k < index - 1; k++) {
                // traverse through the list
                removeFrom = removeFrom.next;
                removeFrom.prev = removeFrom.next.prev;
            }
            // remove last index
            if (removeFrom.next.next == null) {
                removeFrom.next = null;
                removeFrom.prev = null;
            }
            // remove index elsewhere
            else {
                removeFrom.next = removeFrom.next.next;
                removeFrom.next.prev = removeFrom;
            }
        }
    }
}



