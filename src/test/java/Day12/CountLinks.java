package Day12;

import Day9.ReusableMethods;
import ReusableLibrary.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class CountLinks extends AbstractClass {

    @Test
    public void linkCount() throws IOException, InterruptedException {
      //  WebDriver driver = ReusableMethods.defineTheDriver();
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3000);


        //store the arraylist with class attribute for the links
        ArrayList<WebElement> linkCount = new ArrayList(driver.findElements(By.xpath("//*[contains(@class,'_yb_12gb1')]")));
        //print out the count of the links
        System.out.println("Link count is " + linkCount.size());

        //I want to click on each link and navigate back to the home page
        for (int i = 0; i < linkCount.size(); i++) {
            driver.navigate().to("https://www.yahoo.com");
            Thread.sleep(3500);
            linkCount = new ArrayList(driver.findElements(By.xpath("//*[contains(@class,'_yb_12gb1')]")));
            linkCount.get(i).click();
            System.out.println(driver.getTitle());
            Thread.sleep(2000);
        }
    }
}
