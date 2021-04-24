package Day2;

public class DynamicArray {

    public static void main(String[] args) {
        String dyArray[];
        int numArray[];

        dyArray =new String[5];
        dyArray[0] = "Brooklyn";
        dyArray[1] = "Queens";
        dyArray[2] = "Manhattan";
        dyArray[3] = "Bronx";
        dyArray[4] = "Staten Island";

        System.out.println(dyArray[0]);

        numArray = new int[5];
        numArray[0] = 1;
        numArray[1] = 2;
        numArray[2] = 3;
        numArray[3] = 4;
        numArray[4] = 5;
        System.out.println(numArray[1]);

        System.out.println("My city is "+dyArray[0] +" and rank is "+ numArray[0]);
        System.out.println("******************************************************");

        for(int i = 0; i<5;i++){
            System.out.println("City name: " +dyArray[i] + "\nThe Rank: "+ numArray[i]);
        }



    }
}
