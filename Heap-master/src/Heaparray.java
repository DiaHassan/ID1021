import java.util.Arrays;

public class Heaparray {

    public static void main(String[] args){
        System.out.println("vvv Main vvv");
        Heaparray myheap = new Heaparray(7);
        myheap.add(12);
        myheap.add(7);
        myheap.add(6);
        myheap.add(10);
        myheap.add(8);
        myheap.add(20);
        myheap.add(10);


//        System.out.println(Arrays.toString(myheap.root));
        for(int i = 0; i < 7; i++){
            System.out.println(myheap.remove());
            System.out.println(Arrays.toString(myheap.root));

        }


    }
    Integer[] root;
    int size;
    int pos = 0;
//    int next_null = 0;
    public Heaparray(int len){
        root = new Integer[len];
        size = len-1;
    }

    public int get_parent(int pos){
        int tbr;
        if(pos % 2 == 0){
            if((pos-2)/2 >= 0){tbr = (pos-2)/2;}
            else {tbr = 0;}
        } else {tbr = (pos-1)/2;}
        return tbr;
    }
    public void add(Integer tba) {
        int holder;
        if(pos == size){return;}
        else if (root[0] == null){
            root[0] = tba;
            return;
        } else {
           holder = ++pos;
           root[pos] = tba;
        }
        while(holder>=0 && root[holder] < root[get_parent(holder)]){
                Integer temp_holder = root[holder];
                root[holder] = root[get_parent(holder)];
                root[get_parent(holder)] = temp_holder;
                holder = get_parent(holder);
        }
    }

    public Integer remove() {
        if (pos == 0){
            return null;
        }
        else{
            int value = root[0];
            root[0] = root[--pos];
            root[pos] = null;


            int p = 0,c1 = 1,c2 = 2,c_holder = 0;

            while ((root[c2] != null) && (root[p] > root[c1] || root[p] > root[c2])) {
                if(root[c1] > root[c2]){c_holder = c2;}
                else if(root[c1] >= root[c2]) {c_holder = c1;}

                Integer temp = root[c_holder];
                root[c_holder] = root[p];
                root[p] = temp;

                p++;
                c1 = 2 * p + 1;
                c2 = 2 * p + 2;
            }

            return value;
        }
    }
    
    private void sink() {
        int p = 0;
        int c1 = 2 * p + 1;
        int c2 = 2 * p + 2;
        int c_holder;
        while (((root[c2] != null && pos > 2) && root[c1] != null) && (root[p] > root[c1] || root[p] > root[c2])) {
                if(root[c1] > root[c2]){
                    c_holder = c2;
                } else {
                    c_holder = c1;
                }

                Integer temp = root[c_holder];
                root[c_holder] = root[p];
                root[p] = temp;

                p++;
                c1 = 2 * p + 1;
                c2 = 2 * p + 2;
        }
        if ((pos == 2 && root[c2] == null) && (root[p] > root[c1])){
            int tmp = root[c1];
            root[c1] = root[p];
            root[p] = tmp;
        }
    }

//    public Integer remove(){
//        Integer holder;
//        Integer p=0, c1 =1 , c2=2, c_holder;
//        if(pos == 0){return null;}
//        else {
//            holder = root[0];
//            root[0] = root[--pos];
//            root[pos] = null;
//
//
//            while ((root[p] > root[c1] || root[p] > root[c2])&& c2!=null){
//                if(root[c1] > root[c2]){
//                    c_holder = c2;
//                } else {
//                    c_holder = c1;
//                }
//
//                Integer temp = root[c_holder];
//                root[c_holder] = root[p];
//                root[p] = temp;
//
//                p++;
//                c1 = 2 * p + 1;
//                c2 = 2 * p + 2;
//            }
//
//            return holder;
//        }
//    }


//                    if (root[c1] > root[c2]) {
//        int temp = root[c2];
//        root[c2] = root[p];
//        root[p] = temp;
//
//        p++;
//        c1 = 2 * p + 1;
//        c2 = 2 * p + 2;
//
//    }
//                else{
//        int temp = root[c1];
//        root[c1] = root[p];
//        root[p] = temp;
//
//        p++;
//        c1 = 2 * p + 1;
//        c2 = 2 * p + 2;
//    }
//    public void add(Integer value) {
//        if(pos == size) {
//            System.out.println("root is full");
//            return;
//        }
//        else if(root[0] == null) {
//            root[0] = value;
//            return;
//        } else
//            root[++pos] = value;
//
//        Integer i = pos;
//        while(root[i] < root[get_parent(i)] && i >= 0) {
//            Integer temp = root[i];
//            root[i] = root[get_parent(i)];
//            root[get_parent(i)] = temp;
//            i = get_parent(i);
//        }
//    }

//    public void swap(int temp_pos, int pos, int temp_pos_holder){
//        if(temp_pos >= 0 && root[temp_pos]>root[pos]) {
//            Integer temp_holder = root[pos];
//            root[pos] = root[temp_pos];
//            root[temp_pos] = temp_holder;
////            int temp_pos_holder = pos;
//            pos = temp_pos;
//            add(root[pos]);
//        } else {
//            pos = ++temp_pos_holder;
//            return;
//        }
//    }
//    public void add(int tba){
//        int temp_pos;
//        int temp_pos_holder = pos;
//        if(pos >= 0){
//            if (root[pos] == null) {
//                root[pos] = tba;
//                if(pos%2 == 0){
//                   temp_pos =(pos-2)/2;
//                    this.swap(temp_pos,pos,temp_pos_holder);
//                    System.out.println(Arrays.toString(root));
//                } else {
//                    temp_pos = (pos-1)/2;
//                    this.swap(temp_pos,pos,temp_pos_holder);
//                    System.out.println(Arrays.toString(root));
//                }
//            } else {
//                if(pos%2 == 0){
//                    temp_pos =(pos-2)/2;
//                    this.swap(temp_pos,pos,temp_pos_holder);
//                    System.out.println(Arrays.toString(root));
//                } else {
//                    temp_pos = (pos-1)/2;
//                    this.swap(temp_pos,pos,temp_pos_holder);
//                    System.out.println(Arrays.toString(root));
//                }
//            }
//        } else {
//            return;
//        }
//    }

}
