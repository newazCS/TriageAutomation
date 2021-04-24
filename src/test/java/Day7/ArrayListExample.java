package Day7;

import java.util.ArrayList;

public class ArrayListExample {
    public static  void main(String[] args) {
        ArrayList<String> li = new ArrayList<String>();
        li.add("Brooklyn");
        li.add("Queens");
        li.add("Bronx");

        ArrayList<Integer> liNum = new ArrayList<Integer>();
        liNum.add(11218);
        liNum.add(11219);
        liNum.add(11220);


        for(int i=0; i<liNum.size(); i++){
            if(li.get(i).equals("Brooklyn") ||li.get(i).equals("Queens") )
            System.out.println(li.get(i) + " " + liNum.get(i));
        }




    }
}
