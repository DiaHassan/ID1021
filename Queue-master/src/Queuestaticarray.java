public class Queuestaticarray {
    Integer head = 0;
    Integer first_empty = 1;
    boolean overlapping = false;
    Integer length;
    Integer[] array;

    public void array(int n){
        length = n;
        array = new Integer[n];
    }
    public void add(Integer tba){
        if(first_empty == length && overlapping == false) {
            array[first_empty - 1] = tba;
            first_empty = 0;
            overlapping = true;
        } else if(overlapping == true) {
            if(first_empty < head)
                array[first_empty++] = tba;
            else{
                System.out.println("This is full get tf out");
                Integer[] new_arr = new Integer[length * 2];
                Integer temp;
                first_empty = 0;
                for (int i = 0; i < length ; i++){
                    temp = remove();
                    if (temp != null){
                        new_arr[i] = temp;
                        first_empty++;
                        System.out.println(new_arr[i]);
                    }
                }

                new_arr[first_empty] = tba;
                System.out.println(new_arr[first_empty++]);
                first_empty++;
                System.out.println(first_empty);
                head = 0;
                length = length*2;
                overlapping = false;
                array = new_arr;
                System.out.println(array[4]);

            }
//                System.out.println("This is full get tf out");
        }
        else {
            array[first_empty - 1] = tba;
            first_empty++;
        }
    }
    public Integer remove(){
        if(head == null )
            return null;

        if(head == length)
            head = 0;
        Integer tbr = array[head];
        array[head] = null;
        head++;
        if(head == first_empty){
            head = 0;
            first_empty = 1;
            overlapping = false;
        }
        return tbr;
    }
    public void printout(int n){
        for(int i = 0; i < n; i++){
            System.out.print(array[i]+" ");
        }
    }
}

//public class Queuestaticarray {
//    Integer head = 0;
//    Integer first_empty = 1;
//    Integer[] array;
//
//    public void array(int n){array = new Integer[n];}
//    public void add(Integer tba){
//        array[first_empty - 1] = tba;
//        first_empty++;
//    }
//    public Integer remove(){
//        if(head == null || head == first_empty || array[head] == null)
//            return null;
//        Integer tbr = array[head];
//        array[head] = null;
//        head++;
//        return tbr;
//    }
//    public void printout(int n){
//        for(int i = 0; i < n; i++){
//            System.out.print(array[i]+" ");
//        }
//    }
//}
