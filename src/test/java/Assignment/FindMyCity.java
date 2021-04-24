package Assignment;

public class FindMyCity {
    public static void main(String[] args) {

        //Dynamic Array
        String cities[] = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Staten";

        for (int i = 0; i < cities.length; i++) {

            if (cities[i] == "Brooklyn") {
                System.out.println("City is " + cities[i]);
            } else if (cities[i] == "Manhattan") {
                System.out.println("City is " + cities[i]);

            }// end of condition
        }//end of for loop
    }//end of method
}//end of class
