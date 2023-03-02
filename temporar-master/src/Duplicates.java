import java.util.Random;
public class Duplicates {
    public static void main(String[] args){
        Random rnd = new Random();
//        int[] keys = sorted(100);
//        int[] array = sorted(100);
//        System.out.println(duplicate_search(keys,array));

        int[] a = {1,2,4,20,23,32,48,72,80};
        int[] b = {1,5,6,20,21,35,48,63,80};
        System.out.println(duplicate_search_enhanced(a,b));
    }

    public static double duplicate_search(int[] keysarr, int[] arr){
        int counter = 0;
        long timeinitial = System.nanoTime();
        for (int i = 0; i < keysarr.length; i++)
            if(binary_search(arr,keysarr[i]))
                counter++;
        System.out.println(counter);
        return (double)System.nanoTime()-timeinitial;
    }

    //INCOMPLETE CODE
    public static int duplicate_search_enhanced(int[] keysarr, int[] arr){
       int p1 = 0;
       int p2 = 0;
       int counter = 0;
       while(!(p1 == keysarr.length || p2  == keysarr.length)){
           if (keysarr[p1] == arr [p2]){
               p1++;
               p2++;
               counter++;
           } else if (keysarr[p1] > arr[p2]) {
               p2++;
           } else if (keysarr[p1] < arr[p2]) {
               p1++;
           }
       }
       return counter;
    }
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;
        while (true) {
            int index = first + ((last - first) / 2);
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first) {
                last = index - 1;
                continue;
            }
            break;
        }
        return false;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

}
