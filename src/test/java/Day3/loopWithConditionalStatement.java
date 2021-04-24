package Day3;

public class loopWithConditionalStatement {
    public static void main(String[] args) {

        String countries[] =new String[4];
        countries[0] ="USA";
        countries[1] ="Canada";
        countries[2] ="Bangladesh";
        countries[3] ="India";

        //using for loop print only when country is USA OR CANADA
        for(int i=0; i<countries.length; i++){

            if(countries[i] ==  "USA"){
                System.out.println("Country is "+countries[i]);
            }else if(countries[i] =="Canada"){
                System.out.println("Country is "+countries[i]);

            }// end of conditional statement
        }// end of for loop

        for(int i=0; i<countries.length;i++){

            switch(countries[i]){
                case "USA":
                case "Canada":
                case "Bangladesh":
                    System.out.println("Country is "+countries[i]);
                    break;
            }
        }


    }// end of main method
} // end of class
