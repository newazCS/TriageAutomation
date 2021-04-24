package Day14;

import GooglePageObject.Base_Class;
import ReusableLibrary.AbstractClass;
import org.testng.annotations.Test;

public class GoogleIndex extends AbstractClass {

    @Test
    public void googleSearch(){
        driver.navigate().to("https://www.google.com/");
        Base_Class.googleHomePage().GoogleSearch("Apple");
        Base_Class.googleHomePage().SearchButton();
    }
}
