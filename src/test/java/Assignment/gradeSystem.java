package Assignment;

public class gradeSystem {
    public static void main(String[] args) {
        // Declare the integer variables
        String grade = "B";
        switch (grade) {
            case "A":
                System.out.println("Excellent");
                break;
            case "B":
                System.out.println("Well done");
                break;
            case "C":
                System.out.println("Satisfactory");
                break;
            case "D":
                System.out.println("Passed");
                break;
            case "F":
                System.out.println("Fail");
                break;
            default:
                System.out.println("Invalid Grade");
        }//end of SWITCH statement

    }//end of method
}//end of class
