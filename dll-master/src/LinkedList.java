import java.util.Random;

public class LinkedList {
        public static void main(String[] args){
            Main.fll = listgenerator(10);
            LinkedList ftest = new LinkedList(200,null);
            Main.fll.add(ftest);
            printout(Main.fll);
            System.out.println("-----");
            Main.fll.remove(5);
            printout(Main.fll);
        }
        int numb;
        LinkedList next;


        public LinkedList(int item, LinkedList list) {
            numb = item;
            next = list;
        }
        public LinkedList(int item) {
            numb = item;
            next = null;
        }

        public int numb() {
            return this.numb;
        }
        public LinkedList next() {
            return this.next;
        }
        public void append(LinkedList b) {
            LinkedList nxt = this;
            while (nxt.next != null) {
                nxt = nxt.next;
            }
            nxt.next = b;
    }

        public static LinkedList listgenerator(int n){
            Random rnd = new Random();
            LinkedList tbr = new LinkedList(0,null);
            for (int i = 1; i < n; i++)
                tbr.append(new LinkedList(i,null));
            return tbr;
        }

        public void add(LinkedList tba) {
            tba.next = Main.fll;
            Main.fll = tba;
        }

        public void remove(int n){
            LinkedList nxt = this;
            if(n == 0){Main.fll = Main.fll.next;}
            for (int i = 0; i <= n && nxt.next != null; i++){
                if (n == i){
                    nxt.next = nxt.next.next;
                    break;
                }
                nxt = nxt.next;
            }
        }

        public static void printout(LinkedList a){
            while (a.next != null) {
                System.out.println(a.numb) ;
                a = a.next;
            }
            System.out.println(a.numb) ;
        }

}
