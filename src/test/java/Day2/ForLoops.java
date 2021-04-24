package Day2;

public class ForLoops {
    public static void main(String[] args) {

        String[] cities;
        cities = new String[5];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Bronx";
        cities[4] = "Staten Island";

        int numArray[];
        numArray = new int[5];
        numArray[0] = 1;
        numArray[1] = 2;
        numArray[2] = 3;
        numArray[3] = 4;
        numArray[4] = 5;

        //set your iteration to loop through all the values from cities
        for (int i = 0; i < cities.length; i++) {
            //print out all values in one print statement
            System.out.println("City in NYC:" + cities[i] +" \n The Rank: " +numArray[i]);
        } //end of loop
    }//end of main
}//end of class
