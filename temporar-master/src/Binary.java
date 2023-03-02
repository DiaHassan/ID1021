import java.util.Random;
public class Binary {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] binary_array = sorted(100);
        boolean m;
        long time = System.nanoTime();
        m = binary_search(binary_array, 121);
        System.out.println(System.nanoTime() - time + "ns");
        System.out.println(m);
    }

    /**
     *
     * Binary search algoritm
     * @param array to be searched through, needs to be sorted
     * @param key to be found in array
     * @return true if found, false if not
     */
    public static boolean binary_search(int[] array, int key) {
//        long time =  System.nanoTime();
        int first = 0;
        int last = array.length - 1;

        while (true) {
            // jump to the middle
//            System.out.println(first+"f and l"+last);
            int index = first + ((last - first) / 2);
            if (array[index] == key) {
//                System.out.println(System.nanoTime() - time + "ns");
                return true;
            }
            if (array[index] < key && index < last) {
                // The index position holds something that is less than
                // what we're looking for, what is the first possible page?
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first) {
                // The index position holds something that is larger than
                // what we're looking for, what is the last possible page?
                last = index - 1;
                continue;
            }
            break;
            // Why do we land here? What shoudl we do?
        }
//        System.out.println(System.nanoTime() - time + "ns");
        return false;
    }
    /**
     *
     * sorted array
     * @param n is the number of items in the element
     * @return array with n amount of random values
     */
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