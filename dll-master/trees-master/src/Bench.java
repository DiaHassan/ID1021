import java.util.Random;

public class Bench {
    public static void main(String[] args) {

        int[] sizes = {100,200,400,800,1000,1600,3200,3600,4000};
//        for(int i:sizes){
//            BinaryTree.bench(10000,i);
//        }


        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s\n", "n", "1st");
        BinaryTree bt = new BinaryTree();
        Random rnd = new Random();
        for (int n : sizes) {
            System.out.printf("%8d", n);

            int k = 1000;
            double min;

            min = 0;

            for (int i = 0; i < k; i++) {
                BinaryTree.Node trad = bt.nodeGen(n/2,100,n);
                long t0 = System.nanoTime();
                    trad.lookup(rnd.nextInt(n));
                long t1 = System.nanoTime();
                double t = (t1 - t0);
//                if (t < min)
//                    min = t;
                min += t;
            }

            System.out.printf("%8.0f\n", (min/k));
        }
    }
}
