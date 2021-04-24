package Day3;

public class multipleCondition {
    public static void main(String[] args) {

        multiCondition();
    }

    public static void multiCondition(){
        // using multiple conditional statement
        int a, b, c;
        a =2;
        b =2;
        c =4;

        //verify either a+b >c, a+b =c

        if(a+b > c){
            System.out.println(" A & B is greater than C");
        }else if (a+b < c){
            System.out.println(" A & B is less than C");
        } else {
            System.out.println(" A & B is is equal to C");
        }
    }
}
