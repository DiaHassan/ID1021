import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    City[] cities;
    private final int mod = 541;
    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] div = line.split(",");
                City frist_city = lookup(div[0]);
                City second_city = lookup(div[1]);
                Integer dis = Integer.valueOf(div[2]);
                frist_city.newConnection(second_city,dis);
                second_city.newConnection(frist_city,dis);

            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }
    public Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }
    public City lookup(String city_name){
        Integer hash_code = hash((city_name));
        while(true) {
            if (cities[hash_code] == null) {
                break;
            }
            if (cities[hash_code].name.equals(city_name)) {
                return cities[hash_code];
            }
            hash_code = hash_code + 1 % mod;
        }
        City temp = new City(city_name);
        cities[hash_code] = temp;
        return temp;
    }

}
