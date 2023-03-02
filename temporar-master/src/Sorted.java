import java.util.Random;
public class Sorted {
    public static void main(String[] args){
        Random rnd = new Random();
//        int[] sorted_array = sorted(1000);
//        int rnd_nb = rnd.nextInt(1000);
//        System.out.println(search_sorted(sorted_array,rnd_nb));
//        System.out.println(search_unsorted(sorted_array,rnd_nb));
        bench(10,100);
        bench(100,1000);
        bench(1000,10000);
        bench(10000,100000);


    }
    public static boolean search_sorted(int[] array, int key) {
        long time =  System.nanoTime();
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
//                System.out.println(System.nanoTime() - time + "ns");
                return true;
            }
            if (array[index]>key)
                break;
        }
//        System.out.println(System.nanoTime() - time + "ns");
        return false;
    }
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
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

    public static void bench(int tries, int size){
        int[] testArray = new int[size];
        Random rnd = new Random();

        for(int  i = 0; i < size; i++){
            testArray[i] = rnd.nextInt(size*10);
        }
        int[] sortedArray = sorted(size);

        double min = Double.POSITIVE_INFINITY;
        double sum = 0;

        for(int i = 0; i < tries; i++){
            double t0 = System.nanoTime();
            search_sorted(sortedArray, rnd.nextInt(tries*10));
            double t1 = System.nanoTime();
            double time = t1 - t0;
            if(time < min)
                min = time;

            sum += time;
        }
        System.out.printf("Size: %6d\t Min: %.2fns\t Avg: %.2fns\n", size, min, (sum/tries) );
    }
}
