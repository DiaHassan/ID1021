public class Naive {
    public static void main(String[] args) {
        Map map = new Map("C:\\Users\\angry\\IdeaProjects\\Grafer\\src\\trains.csv");
        String from = "Stockholm";
        String to = "Umeå";
        Integer max = 1000;
        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");
    }
    private static Integer shortest(City from_city, City to_city, Integer max) {
        if (max < 0)
            return null;
        if (from_city == to_city)
            return 0;
        Integer shrt = null;
        for (int i = 0; i < from_city.neighbors.length; i++) {
            if (from_city.neighbors[i] != null) {
                Connection connection = from_city.neighbors[i];
                Integer distance = shortest(connection.city, to_city, max - connection.distance);
                if((distance != null) && ((shrt == null) || (shrt > distance + connection.distance)))
                    shrt = distance + connection.distance;
                if((shrt != null) && (max > shrt))
                    max = shrt;
            }
        }
        return shrt;
    }
}


