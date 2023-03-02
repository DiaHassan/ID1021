public class City {
    String name;
    final int final_size = 7;
    Connection[] neighbors = new Connection[final_size];

    public City(String city_name){
        name = city_name;
    }
    public void newConnection(City the_city, Integer dis){
        for(int i = 0; i<final_size;i++)
            if(neighbors[i] == null){
                neighbors[i] = new Connection(the_city,dis);
                break;
            }
    }


}
