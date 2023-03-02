import java.util.Random;
public class Unsorted {
    public static void main(String[] args) {
//        Random rnd = new Random();
//        int[] unsorted_array = new int[100000];
//        for (int i = 0; i < unsorted_array.length ; i++)
//            unsorted_array[i] = rnd.nextInt(9999);
////        System.out.println(search_unsorted(unsorted_array,67));
//        bench(100,1000,unsorted_array);
        int[] sizes = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s\n", "n", "unsorted", "binary", "duplicates");

        for (int n : sizes) {

            int loop = 10000;

            int[] array = sorted(n);
            int[] arrayb = sorted(n);
            int[] indx = keys(loop, n);

            System.out.printf("%8d", n);

            int k = 1000;

            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linear(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min / loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                binary(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min / loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Duplicates.duplicate_search(array, arrayb);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%8.0f", (min / n));

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Duplicates.duplicate_search_enhanced(array, arrayb);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%8.0f\n", (min / n));

        }
    }
    public static boolean search_unsorted(int[] array, int key) {
        long time =  System.nanoTime();
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
//                System.out.println(System.nanoTime() - time + "ns");
                return true;
            }
        }
//        System.out.println(System.nanoTime() - time + "ns");
        return false;
    }
    private static void linear(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            search_unsorted(array, indx[i]);
        }
    }


    private static void binary(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            Binary.binary_search(array, indx[i]);
        }
    }


    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);

        for (int i = 0; i < n ; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1 ;
        }
        return array;
    }


    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop ; i++) {
            indx[i] = rnd.nextInt(n*5);
        }
        return indx;
    }


//    public static void bench(int tries, int size, int[] arrtest){
//        int[] testArray = new int[size];
//        Random rnd = new Random();
//
//        for(int  i = 0; i < size; i++){
//            testArray[i] = rnd.nextInt(size*10);
//        }
//        int[] sortedArray = arrtest;
//
//        double min = Double.POSITIVE_INFINITY;
//        double sum = 0;
//
//        for(int i = 0; i < tries; i++){
//            double t0 = System.nanoTime();
//            search_unsorted(sortedArray, rnd.nextInt(tries*10));
//            double t1 = System.nanoTime();
//            double time = t1 - t0;
//            if(time < min)
//                min = time;
//
//            sum += time;
//        }
//        System.out.printf("Size: %6d\t Min: %.2fns\t Avg: %.2fns\n", size, min, (sum/tries) );
//    }

}
