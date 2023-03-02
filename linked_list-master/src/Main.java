import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        LinkedList fixed = listgenerator(1000);

        int[] sizes = {100,200,400,800,1000,1600,3200,6400,12800};
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s%8s\n", "n", "1st", "2nd", "3rd", "4th");

        for (int n : sizes) {
            System.out.printf("%8d", n);

            int k = 1000;
            double min = Double.POSITIVE_INFINITY;

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                LinkedList fixed = listgenerator(1000);
                LinkedList newlist= listgenerator(n);
                long t0 = System.nanoTime();
                fixed.append(newlist);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%8.0f", (min));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                LinkedList fixed = listgenerator(1000);
                LinkedList newlist = listgenerator(n);
                long t0 = System.nanoTime();
                newlist.append(fixed);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%8.0f", (min));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                int[] fixed = unsorted(1000);
                int[] newlist = unsorted(n);
                long t0 = System.nanoTime();
                fixed = Linkedarrays.array_append(fixed, newlist);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%8.0f", (min));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                int[] fixed = unsorted(1000);
                int[] newlist = unsorted(n);
                long t0 = System.nanoTime();
                newlist = Linkedarrays.array_append(newlist,fixed);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%8.0f\n", (min));
        }
    }

    public static LinkedList listgenerator(int n){
        Random rnd = new Random();
        LinkedList tbr = new LinkedList(0,null);
        for (int i = 1; i < n; i++)
            tbr.append(new LinkedList(rnd.nextInt(n),null));
        return tbr;
    }

    public static int[] unsorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(n*5);
        }
        return array;
    }

}