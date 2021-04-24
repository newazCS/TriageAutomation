package Day2;

public class ActionItem01 {
    public static void main(String[] args) {

        //Declare the variable
        String zipCode[];
        int streetNumber[];

        zipCode = new String[4];
        zipCode[0] ="11218";
        zipCode[1] ="11219";
        zipCode[2] ="11220";
        zipCode[3] ="11220";

        streetNumber = new int[4];
        streetNumber[0] = 35;
        streetNumber[1] = 36;
        streetNumber[2] = 37;
        streetNumber[3] = 38;

        for(int i=0; i< zipCode.length; i++){
            System.out.println("My zip code is: "+zipCode[i] +"\n and my street number: "+streetNumber[i]);
        }


    }
}
