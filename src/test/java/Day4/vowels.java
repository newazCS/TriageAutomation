package Day4;
//find all the vowels from word - a ,e i o u
public class vowels {

    public static void main(String[] args) {
        String []country = {"B","A","N","G","L","A","D","E","S","H"};

        for(int i=0; i<country.length;i++){

            if(country[i]=="A" ||country[i]=="E"||country[i]=="I"||country[i]=="O"||country[i]=="U" ){
                System.out.println("Vowels from Bangladesh: "+country[i]);
            }
        }

    }
}
