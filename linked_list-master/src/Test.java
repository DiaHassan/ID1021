
public class Test {
    public static LinkedList m = lister(5);

    public static void main(String[] args){
        LinkedList.printout(m);
        System.out.println("-------");
//        m.pop();
//        m.pop();
//        m.pop();
//        m.push( 10);
//        m.push( 11);

        LinkedList.printout(m);

    }
    public static LinkedList lister(int n){
        LinkedList tbr = new LinkedList(0,null);
        for (int i = 1; i < n; i++)
            tbr.append(new LinkedList(i,null));
        return tbr;
    }
}
