package Day3;

/*
*  A switch statement allows a variable to be tested for equality against a list of values. Each value is called a case
* and the variable being switched on is checked for each case.
* */
public class SwitchStatement {
    public static void main(String[] args) {
       // declare and define the variable for day
        String day ="Friday";

        switch(day){
            case "Monday":
                System.out.println("Today is Monday");
                break;
            case "Tuesday":
                System.out.println("Today is Tuesday");
                break;
            case "Wednesday":
                System.out.println("Today is Wednesday");
                break;
            case "Thursday":
                System.out.println("Today is Thursday");
                break;
            case "Friday":
                System.out.println("Today is Friday");
                break;
            default:
                System.out.println("Is not weekend");
        } //end of switch statement
    }// end of main method
}//end of class
