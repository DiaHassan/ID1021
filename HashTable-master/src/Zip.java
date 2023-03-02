import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
    int max;
    Integer mod;
    Integer[] keys;

    Node[] buckets;
    public class Node {
        Integer code;
        String name;
        Integer pop;
        Node nxt;



        public Node (Integer cde, String nme, Integer pp){
            code = cde;
            name = nme;
            pop = pp;
        }
    }
    public Zip(String file) {
        data = new Node[10000];
        keys = new Integer[10000];
        buckets = new Node[20000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer key = Integer.valueOf(row[0].replaceAll("\\s",""));
                keys[i] = key;
                data[i++] = new Node(key, row[1], Integer.valueOf(row[2]));

            }
            max = i-1;
//            System.out.println("Worked");
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

//    public Node lookup(Integer key) {
//        if(data[key] !=null) return data[key];
//        else return null;
//    }

    public Node binary_search(Integer tbf){
        int low = 0,high = 9675;
        while(low<=high) {
            int mid = low + (high - low) / 2;
            if(data[mid].code.equals(tbf)){return data[mid];}
            if(data[mid].code.compareTo(tbf) == -1 && mid < high){
                low = mid + 1;
                continue;
            }
            if(data[mid].code.compareTo(tbf) == 1 && mid > low){high = mid - 1;}
        }
        System.out.println("didnt work");
        return null;
    }
    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }


    public void add_bucket(Node ipt){
        int hash_code = ipt.code % mod;
        if(buckets[hash_code] == null)
            buckets[hash_code] = ipt;
        else {
            while (buckets[hash_code+1] != null) {
                hash_code++;
            }
            buckets[++hash_code] = ipt;
        }
    }
    public void fill_bucket(){
        for (int i = 0; i < 9675; i++)
            add_bucket(data[i]);
    }
    public Integer lookup(Integer zipcode){
        int hash_code = zipcode % mod;
        if(buckets[hash_code] == null){
            return null;
        } else if(buckets[hash_code].code.equals(zipcode)) {
            return buckets[hash_code].code;
        } else {
            while (buckets[hash_code+1] != null) {
                if (!buckets[hash_code].code.equals(zipcode)) {
                    hash_code++;
                }else{
                    return buckets[hash_code].code;
                }
            }
            return buckets[hash_code].code;
        }
    }

//    public void add_bucket(Node ipt){
//        int hash_code = ipt.code % mod;
//        if(buckets[hash_code] == null)
//            buckets[hash_code] = ipt;
//        else {
//            Node current = buckets[hash_code];
//            while (current.nxt != null) {
//                current = current.nxt;
//            }
//            current.nxt = ipt;
//        }
//    }
//    public void fill_bucket(){
//        for (int i = 0; i < 9675; i++)
//            add_bucket(data[i]);
//    }
//    public Integer lookup(Integer zipcode){
//        int hash_code = zipcode % mod;
//        if(buckets[hash_code] == null){
//            return null;
//        } else {
//            Node current = buckets[hash_code];
//            while (current.nxt != null){
//                System.out.println("In while is reached");
//                System.out.println(current.code);
//                if (current.code.equals(zipcode))
//                    return  current.code;
//                current = current.nxt;
//            }
//            if (current.code.equals(zipcode)) {
//                System.out.println("this is reached");
//                return current.code;
//            }else
//                System.out.println("not found");
//                return null;
//        }
//    }

}
