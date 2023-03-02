public class Firstsort {

    /**
     * @param array takes in the unsorted array
     * @return array returns the same array but is sorted
     * */
    public static int[] firstsort(int[] array) {
        int holder = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int cand = i;
            for (int j = i; j < array.length; j++)
                if  (array[j] < array[cand])
                    cand = j;
            holder =  array[i];
            array[i] = array[cand];
            array[cand] = holder;
        }
        return array;
    }
}
