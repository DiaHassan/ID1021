public class Main {
    public static void main(String[] args) {
//        BinaryTree bt = new BinaryTree();
//        BinaryTree.Node trad = bt.new Node(8,0);
//        trad.add(11,1);
//        trad.add(10,2);
//        trad.add(13,3);
//        trad.add(9, 4);
//        trad.add(4, 5);
//        trad.add(6, 6);
//        trad.add(5, 7);
//        trad.add(2, 8);
////        System.out.println(trad.key+" "+trad.value);
//
//        System.out.println(trad.right.key +" "+trad.right.value);
//        System.out.println(trad.right.left.key +" "+trad.right.left.value);
//        System.out.println(trad.right.left.left.key +" "+trad.right.left.left.value);
//        System.out.println(trad.right.right.key +" "+trad.right.right.value);
//
//        System.out.println(trad.left.key);
//        System.out.println(trad.left.left.key);
//        System.out.println(trad.left.right.key);
//        System.out.println(trad.left.right.left.key);
//
//
//        System.out.println(trad.lookup(11));
//        System.out.println(trad.lookup(10));
//        System.out.println(trad.lookup(9));
//        System.out.println(trad.lookup(13));
//        System.out.println(trad.lookup(4));
//        System.out.println(trad.lookup(6));
//        System.out.println(trad.lookup(5));
        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);
        tree.root.print();
//        System.out.println(tree.root.key);
        for (int i : tree)
            System.out.println("next value " + i);
        tree.root.print();

    }
}