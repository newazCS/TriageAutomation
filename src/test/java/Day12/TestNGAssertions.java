package Day12;

import Day9.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TestNGAssertions {

    @Test
    public void assertions() throws IOException, InterruptedException {
        WebDriver driver = ReusableMethods.defineTheDriver();
        driver.navigate().to("https://www.google.com");

        //using hard assert verify the google title
     //   Assert.assertEquals("Google",driver.getTitle());

        //using soft assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Google",driver.getTitle());

        //Enter something on google search
        ReusableMethods.sendKeysMethod(driver,"//*[@name='q']","car","searchBox");
        ReusableMethods.Submit(driver,"//input[@value='Google Search']");

        //AssertAll should be the last step on  test
        softAssert.assertAll();
        driver.close();

    }
}
