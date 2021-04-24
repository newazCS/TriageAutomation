package Day2;

public class WhileLoop {
    public static void main(String[] args) {

        String [] cities;
        cities = new String[5];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Bronx";
        cities[4] = "Staten Island";



        int i =0;
        while(i< cities.length){
            System.out.println(cities[i]);
            i++;
        }
    }
}
