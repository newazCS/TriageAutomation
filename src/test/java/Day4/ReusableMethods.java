package Day4;

public class ReusableMethods {

    //create reusable method which will add two numbers and print out the statement
    public static void addTwoNumber(int num1, int num2) {
        System.out.println("My result is " + (num1 + num2));
    }

    public static void subTwoNumber(int num1, int num2) {
        System.out.println("My result is " + (num1 - num2));
    }


    public void addAnother(int value1, int value2) {
        System.out.println("My result is " + (value1 + value2));
    }

    public static int multiNumber(int num1, int num2) {
        int sum = num1 * num2;
        return sum;
    }


}// end of class
