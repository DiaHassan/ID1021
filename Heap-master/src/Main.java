public class Main {
    public static void main(String[] args) {
//        List mylist = new List();
//        mylist.fast_add(5);
//        mylist.fast_add(9);
//        mylist.fast_add(2);
//        mylist.fast_add(6);
//        mylist.fast_add(7);
//        mylist.printout();
//        mylist.slow_remove();
//        System.out.println();
//        mylist.printout();

//        System.out.println();
//        System.out.println();
//        List mylistra = new List();
//        mylistra.slow_add(5);
//        mylistra.slow_add(9);
//        mylistra.slow_add(2);
//        mylistra.slow_add(6);
//        mylistra.slow_add(7);
//        mylistra.printout();
//        mylistra.fast_remove();
//        System.out.println();
//        mylistra.printout();

        Heap myheap = new Heap();
        myheap.add(5);
        myheap.add(4);
        myheap.add(3);
        myheap.add(10);
        myheap.add(7);
        myheap.add(2);
        System.out.println("     "+myheap.root.value);
        System.out.println("  "+myheap.root.left.value+"     "+myheap.root.right.value);
        System.out.println(myheap.root.left.left.value+" "+myheap.root.left.right.value+"  "+ myheap.root.right.left.value);
        System.out.println();

        myheap.push(4);

        System.out.println("     "+myheap.root.value);
        System.out.println("  "+myheap.root.left.value+"     "+myheap.root.right.value);
        System.out.println(myheap.root.left.left.value+" "+myheap.root.left.right.value+"  "+ myheap.root.right.left.value);
//        System.out.println(myheap.root.left.right.value);
//        System.out.println(myheap.root.right.value);
//        System.out.println(myheap.root.right.left.value);
        System.out.println();
//        System.out.println();
//        myheap.remove();
//        System.out.println(myheap.root.value);
//        System.out.println(myheap.root.left.value);
//        System.out.println(myheap.root.left.left.value);
////        System.out.println(myheap.root.left.right.value);
//        System.out.println(myheap.root.right.value);
//        System.out.println(myheap.root.right.left.value);
//        System.out.println();
//        myheap.remove();
//        System.out.println(myheap.root.value);
//        System.out.println(myheap.root.left.value);
//        System.out.println(myheap.root.left.left.value);
////        System.out.println(myheap.root.left.right.value);
//        System.out.println(myheap.root.right.value);
////        System.out.println(myheap.root.right.left.value);


    }
}