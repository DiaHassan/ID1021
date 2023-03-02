import java.util.Arrays;

public class Secondsort {
    public static void main(String[] args){
        int[] a = {27, 92, 4, 48, 62, 55, 9, 12, 15, 35, 22, 13, 1, 20, 79, 44, 65, 74, 5, 66};
        secondsort(a);
    }
    public static int[] secondsort(int[] array) {
        int holder = 0;
        for (int i = 0; i < array.length; i++) {
            holder = array[i];
            for (int j = i; j > 0 && array[j] < array[j-1] ; j--) {
                    array[j] = array[j - 1];
                    array[j - 1] = holder;
            }
        }
        return array;
    }
}
