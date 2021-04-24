package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class ScrollByElement {
    public static void main(String[] args) throws InterruptedException, IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1500);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mortgagecalculator.org/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
         WebElement focus =  driver.findElement(By.xpath("//input[@value='Printer Friendly Page']"));
         jse.executeScript("arguments[0].scrollIntoView(true);",focus);
         Thread.sleep(2000);
          jse.executeScript("scroll(0,-2)");
    }
}
