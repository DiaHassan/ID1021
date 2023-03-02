public class Main {
    public static void main(String[] args) {
        Map map = new Map("src\\trains.csv");
//        System.out.println(map.cities[map.hash("Stockholm")].name);
        int m = 0;
        for(int i = 0; i<map.cities.length; i++){
            if(map.cities[i] != null)
                System.out.println(i+" "+m+++" "+map.cities[i].name);
        }
    }
}