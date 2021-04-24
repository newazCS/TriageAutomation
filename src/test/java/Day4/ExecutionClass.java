package Day4;

import static Day4.ReusableMethods.multiNumber;

public class ExecutionClass {
    public static void main(String[] args) {
        ReusableMethods.addTwoNumber(10,20);
        ReusableMethods.subTwoNumber(20,10);
        int multi = multiNumber(20,2);
        System.out.println("The Result of multiplication = "+multi);

        ReusableMethods rm = new ReusableMethods(); // when method is not static
        rm.addAnother(30,10);
    }
}
