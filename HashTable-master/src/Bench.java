import java.util.Random;

public class Bench {
    public static void main(String[] args) {
        int[] sizes = {100, 200, 400, 800, 1000, 1600, 3200, 6400, 12800};
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s%8s\n", "n", "1st", "2nd", "3rd", "4th");
        Random rnd = new Random();
        for (int n : sizes) {
            System.out.printf("%8d &", n);
            Zip test_zip = new Zip("C:\\Users\\hdia\\IdeaProjects\\HashTable\\src\\postnummer.csv");
            int k = 1000;
            double min;



//            min =  Double.MAX_VALUE;
            min =  0;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
//                Zip.Node test = test_zip.lookup(11115);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                min += t;
//                if(t< min){
//                    min = t;
//                }

            }
            System.out.printf("%8.0f &", (min/k));

//            min = Double.MAX_VALUE;
            min = 0;
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
//                Zip.Node test = test_zip.lookup(98499);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                min += t;
//                if(t< min){
//                    min = t;
//                }

            }
            System.out.printf("%8.0f \\\\ \n", (min/k) );

        }
    }
}


