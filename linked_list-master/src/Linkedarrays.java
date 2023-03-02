import java.util.Arrays;


public class Linkedarrays {
    public static void main(String[] args){
        int[] a = {1,2,3,3,4};
        int[] b = {44,25,3,53,45,5,5556,6};
        System.out.println(Arrays.toString(array_append(a,b)));
    }
    public static int[] array_append(int[] org, int[] tba){
        int tlen = org.length + tba.length;
        int[] tbr = new int[tlen];
        for(int i = 0; i <tlen; i++){
            if (i >= org.length) tbr[i] = tba[i-org.length];
            else tbr[i] = org[i];
        }
        return tbr;
    }
}
