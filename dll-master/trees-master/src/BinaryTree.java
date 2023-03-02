import java.util.Random;
import java.util.Iterator;
public class BinaryTree implements Iterable<Integer> {
    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }
    public static void main(String[] args) {

    }

    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void add(Integer key, Integer value){
            Node current = this;
            if (key < current.key) {
                if(current.left  == null){
                    current.left = new Node(key, value);
                } else {
                    current = current.left;
                    current.add(key, value);
                }
            } else if (key > current.key) {
                if(current.right == null){
                    current.right = new Node(key, value);
                } else {
                    current = current.right;
                    current.add(key, value);
                }
            } else {current.value = value;}
        }
        public Integer lookup(Integer key){
            Node current = this;
            if (key < current.key) {
                if(current.left  == null){return null;}
                else {
                    current = current.left;
                    return current.lookup(key);
                }
            } else if (key > current.key) {
                if(current.right == null){return null;}
                else {
                    current = current.right;
                    return current.lookup(key);
                }
            }
            return current.value;
        }
        public void print() {
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                right.print();
        }
    }
    public void add (Integer key, Integer value){
        if (root == null){
            root = new Node(key, value);
        }
        else{
            root.add(key, value);
        }
    }
    static Node root;

    public void BinaryTree() {
        root = null;
    }
    public Node nodeGen(Integer key, Integer value, int n){
        Random rnd = new Random();
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node trad = bt.new Node(key,value);
        for (int i = 0; i< n; i++){
            trad.add(rnd.nextInt(n), rnd.nextInt(n*3));
        }
        return trad;
    }
    public Integer lookup(Integer key){
        return root.lookup(key);
    }

    public static BinaryTree generateRandom(int size){
        Random rnd = new Random();
        BinaryTree generated = new BinaryTree();

        for (int i = 0; i < size; i++) {
            generated.add(rnd.nextInt(size), rnd.nextInt(size));
        }
        return generated;
    }
    public static void bench(int tries, int size){

        Random rnd = new Random();

        BinaryTree myTree = generateRandom(size);

        double min = Double.POSITIVE_INFINITY;
        double max = 0;
        double sum = 0;


        for(int i = 0; i < tries; i++){
            double t0 = System.nanoTime();
            myTree.lookup(rnd.nextInt(size));
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if(time < min)
                min = time;
            if(time > max)
                max = time;

            sum += time;
        }
        System.out.printf("Size: %6d\t Min: %.2fns\t Avg: %.2fns\t Max: %.2fns\n", size, min, (sum/tries), max);
    }
}

