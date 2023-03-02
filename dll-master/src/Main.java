import java.util.Random;

public class Main {
    public static LinkedList fll;
    public static DLinkedList dll;
    public static void main(String[] args) {
        int[] sizes = {100,200,400,800,1000,1600,3200,6400,12800};
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s\n", "n", "1st", "2nd");

        double templl = 0;
        double tempdll = 0;
        for (int n : sizes) {
            System.out.printf("%8d", n);
            fll = LinkedList.listgenerator(n);
            dll = DLinkedList.Dlistgenerator(n);

            int k = 1000;
            int[] sequence = new int[k];
            Random rnd = new Random();
            for (int i = 0; i < k; i++)
                sequence[i] = rnd.nextInt(n);
            double min;

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                LinkedList forll = new LinkedList(rnd.nextInt(n));
                long t0 = System.nanoTime();
                fll.add(forll);
                fll.remove(sequence[i]);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                templl += t;
//                if (t < min)
//                    min = t;
            }
            System.out.printf("%8.0f", (templl/k));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                DLinkedList fordl = new DLinkedList(rnd.nextInt(n));
                long t0 = System.nanoTime();
                dll.add(fordl);
                dll.remove(sequence[i]);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                tempdll += t;
//                if (t < min)
//                    min = t;
            }
            System.out.printf("%8.0f\n", (tempdll/k));
        }
    }

//    public static LinkedList listgenerator(int n){
//        Random rnd = new Random();
//        LinkedList tbr = new LinkedList(0,null);
//        for (int i = 1; i < n; i++)
//            tbr.append(new LinkedList(rnd.nextInt(n),null));
//        return tbr;
//    }
}