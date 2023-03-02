public class Main {
    public static void main(String[] args) {
//        Zip test_zip = new Zip("C:\\Users\\angry\\IdeaProjects\\Hash Table\\src\\postnummer.csv");
        Zip test_zip = new Zip("C:\\Users\\hdia\\IdeaProjects\\HashTable\\src\\postnummer.csv");
//        Zip.Node temp = test_zip.lookup("111 15");
//        Zip.Node test = test_zip.linear_search("111 15");
//        int bstest = Zip.binary_search(test_zip.data,0,test_zip.data.length, 11140);
//        System.out.println(bstest);
//        System.out.println(test.code+" "+temp.code);
//        System.out.println(test_zip.keys[9674]);
//        test_zip.collisions(12345);

//        test_zip.mod = 5431;
//        test_zip.fill_bucket();
//        System.out.println(44195 % test_zip.mod);
//        System.out.println(test_zip.buckets[747].code);
//        System.out.println(test_zip.buckets[747].nxt.code);
//        System.out.println(test_zip.buckets[747].nxt.nxt.code);
//
//        System.out.println(test_zip.lookup(44195));
//        test_zip.lookup();
//        test_zip.lookup(11120);

        test_zip.mod = 10000;
        test_zip.fill_bucket();
        System.out.println(62368 % test_zip.mod);
        System.out.println(test_zip.lookup(62368));
//        System.out.println(test_zip.buckets[747].code);
//        System.out.println(test_zip.buckets[747].nxt.code);
//        System.out.println(test_zip.buckets[747].nxt.nxt.code);



//        Zip.Node bs_test = test_zip.lookup(99499);

//        System.out.println(bs_test);
    }
}