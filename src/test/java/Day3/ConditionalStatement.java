package Day3;

/*
 * What is conditional statement?
 *   - Conditional statement allows you to execute a condition based on if an object exist or doesn't exit.
 *   There are three common conditions are used such as if condition, if else condition, if else if condition
 *   Conditional statement also open with {and ends with}.
 *
 * */

public class ConditionalStatement {
    public static void main(String[] args) {

        //Calling if method
        ifStatement();

        //Calling ifElse method
        ifElseStatement();

        //calling ifElseIf method
        ifElseIfStatement();


    } //end of main method

    //---------------------------------------------------------------//

    // Method for If Statement
    public static void ifStatement() {
        // Declare the integer variables
        int a = 2;
        int b = 3;

        // using if condition, verify that a is less then b
        if (a < b) {
            System.out.println("A is less than B");
        } //end of if condition
    } // end of ifStatement method

    //---------------------------------------------------------------//

    // Using if else condition, verify if a is less than b, else it is greater or equal to b
    // Method for ifElse Statement
    public static void ifElseStatement() {
        // Declare the integer variables
        int a = 4;
        int b = 3;

        // using if condition, verify that a is less then b
        if (a < b) {
            System.out.println("A is less than B");
        } else {
            System.out.println("A is greater than B");
        }//end of ifElse condition
    } // end of ifElseStatement method

    //---------------------------------------------------------------//

    // Method for ifElseIf Statement
    public static void ifElseIfStatement(){
        int a = 4;
        int b = 4;

        // using if condition, verify that a is less then b
        if (a < b) {
            System.out.println("A is less than B");
        } else if(a ==b){
            System.out.println("A & B are equal");
        }else {
            System.out.println("A is greater than B");
        }//end of ifElseIf condition

    }// end of ifElseIfStatement method



} //end of Java class
