public class Final {
    public static void main(String[] args){


        long k = 10000;
        long t_total = 0;
        for(int i = 0; i < k; i++){
            Item item0 = new Item(ItemType.VALUE, 3);
            Item item1 = new Item(ItemType.VALUE, 4);

            Item item2 = new Item(ItemType.ADD, 0);
            Item item3 = new Item(ItemType.VALUE, 2);
            Item item4 = new Item(ItemType.VALUE, 4);
            Item item5 = new Item(ItemType.ADD, 0);
            Item item6 = new Item(ItemType.MUL, 0);

            Item[] bench = new Item[]{item0, item1, item2, item3, item4, item5, item6};

            Calculator Calculator = new Calculator(bench);

            long t0 = System.nanoTime();
            Calculator.run();
            long t1 = System.nanoTime();
            t_total += (t1 - t0);
        }
        System.out.println(t_total/k + "ns");




    }

}
