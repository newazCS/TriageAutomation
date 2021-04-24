package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;


public class Mouse {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1500);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.usps.com/");


        Actions mouseAction = new Actions(driver);
        WebElement send = driver.findElement(By.id("mail-ship-width"));
        mouseAction.moveToElement(send).perform();
        Thread.sleep(3000);
        WebElement zipcode = driver.findElement(By.xpath("//*[text()='Look Up a ZIP Code']"));
        mouseAction.moveToElement(zipcode).click().perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Find Cities by ZIP")).click();
        WebElement zip = driver.findElement(By.xpath("//input[@id='tZip' and @type='text']"));
        mouseAction.moveToElement(zip).click().sendKeys("10001").perform();
        driver.findElement(By.xpath("//a[@id='cities-by-zip-code']")).click();
        Thread.sleep(2000);
        String location = driver.findElement(By.xpath("//p[@class='row-detail-wrapper']")).getText();
        System.out.println("Recommended City Name: " + location.toLowerCase());
        Thread.sleep(3000);
        driver.quit();
    }
}