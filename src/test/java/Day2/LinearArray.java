package Day2;

public class LinearArray {
    public static void main(String[] args) {
        //Linear Array

        //Declare the variable
        String [] cities;
        int [] streetNumber;

        cities = new String[]{"Brooklyn","Queens","Manhattan","Bronx","Staten Island"};
        streetNumber = new int[]{111,222,333,444,555};

        //I want to print Bronx
        System.out.println("My city is "+cities[3] +" and number "+streetNumber[3]);

    }
}
