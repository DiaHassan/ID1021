import java.util.Random;
public class Benchmarking {
    public static void main(String[] args){
        Random rnd = new Random();
        int[] sizes = {100,200,400,800,1600,3200,6400,12800};
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s\n", "n", "1st","2nd","3rd");

        for (int n : sizes) {
            System.out.printf("%8d", n);

            int k = 1000;
            double min = Double.POSITIVE_INFINITY;


            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Firstsort.firstsort(unsorted(n));
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%8.0f", (min));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Secondsort.secondsort(unsorted(n));
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%8.0f", (min));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Merge.mergesort(unsorted(n));
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%8.0f\n", (min));
        }
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
