public class Paths {
    City[] path;
    int sp;
    public Paths() {
        path = new City[54];
        sp = 0;
    }
    public static void main(String[] args) {
        Map map = new Map("C:\\Users\\angry\\IdeaProjects\\Grafer\\src\\trains.csv");
        Paths path = new Paths();
        String from = "Malmö";
        String to = "Kiruna";
        Integer max = 1000;
        long t0 = System.nanoTime();
        Integer dist = path.shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");
    }



    private Integer shortest(City from_city, City to_city, Integer max) {
//        if (max < 0)
//            return null;
        if (from_city == to_city)
            return 0;

        for (int i = 0; i < sp; i++) {
            if (path[i] == from_city)
                return null;
        }
        path[sp++] = from_city;
        Integer shrt = null;
        for (int i = 0; i < from_city.neighbors.length; i++) {
            if (from_city.neighbors[i] != null) {
                Connection conn = from_city.neighbors[i];
                Integer distance = shortest(conn.city, to_city, max - conn.distance);
                if((distance != null) && ((shrt == null) || (shrt > distance + conn.distance)))
                    shrt = distance + conn.distance;
                if((shrt != null) && (max > shrt))
                    max = shrt;
            }
        }

        path[sp--] = null;
        return shrt;
    }

}