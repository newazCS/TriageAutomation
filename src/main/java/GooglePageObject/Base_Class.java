package GooglePageObject;


import ReusableLibrary.AbstractClass;

public class Base_Class extends AbstractClass {


    //this page class is a static reference for the page object classes
    //so I can use it on my test class
    public static Google_Home googleHomePage(){
        Google_Home googleHomePage = new Google_Home(driver);
        return  googleHomePage;
    }//end of googleHomePage method


}
