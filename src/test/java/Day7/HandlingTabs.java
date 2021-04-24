package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.ArrayList;

/*
*
* Handling tabs
* To handle two or more tabs we need to use ArrayList<String> with getWindowHandles() command.
* Take a look at the following statements
*
* // Store all currently open tabs in tabs (custom name) variable
* ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
*
* // Switch newly open tab. After switching put like a second or two wait  statement for browser process
* driver.switchTo().window(tabs.get(1));
*
* //close newly open tab after performing some operations. "Do not quit or else it will end the entire section"
* driver.close();
*
* Switch to old(Parent) tab
* driver.switchTo().window(tabs.get(0));
*
* */

public class HandlingTabs {
    public static void main(String[] args) throws InterruptedException, IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1500);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.oxhp.com/");
        driver.findElement(By.xpath("//*[contains(@onmouseover,'/images/home/members_hm_on')]")).click();
        Thread.sleep(2000);

       driver.findElement(By.xpath("//*[contains(text(),'Find a Physician')]")).click();

        //using Arraylist we can switch to new tab(1)
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab 2
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);

        System.out.println(driver.getTitle());

        try {
            //driver.findElement(By.linkText("Metro")).submit();
            driver.findElement(By.xpath("(//font[@color='blue'])[4]")).submit();
        } catch (Exception e) {
            System.out.println("Unable to click on Metro link. " + e);
        }

        //close the new tab
        driver.close();
        //switch back to old tab
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());



    }
}


























