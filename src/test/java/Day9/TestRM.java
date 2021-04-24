package Day9;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestRM {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = ReusableMethods.defineTheDriver();
        driver.navigate().to("https://www.google.com/");

        ReusableMethods.sendKeysMethod(driver,"//input[@title='Search']","Apple","Search Field");
        ReusableMethods.Submit(driver,"(//input[@value='Google Search'])[2]");

    }
}
