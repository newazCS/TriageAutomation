package Day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;

public class Scroll {
    public static void main(String[] args) throws InterruptedException, IOException {
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1500);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.yahoo.com/");
        Thread.sleep(2000);
        driver.findElement(By.name("p")).sendKeys("cars");
        driver.findElement(By.id("ybar-search")).submit();
        Thread.sleep(2000);
        //Scroll to the bottom of the page to capture the search result
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Scroll to the bottom by pixels
        jse.executeScript("scroll(0,5000)");
        Thread.sleep(2000);
        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();
        String[] arrayResult = result.split("Next");
        String[] arrayNumber = arrayResult[1].split("result");
        System.out.println("Search result: " + arrayNumber[0]);
        jse.executeScript("scroll(0,-5000)");
        driver.findElement(By.id("ysignin")).click();
        System.out.println("Title of sign in page: " + driver.getTitle());
        driver.findElement(By.linkText("Create an account")).click();
        driver.findElement(By.id("usernamereg-firstName")).sendKeys("Newaz");
        driver.findElement(By.id("usernamereg-lastName")).sendKeys("Newaz");
        driver.findElement(By.id("usernamereg-yid")).sendKeys("NewazNoman");
        driver.findElement(By.id("usernamereg-password")).sendKeys("NewazNoman123");
        driver.findElement(By.id("usernamereg-phone")).sendKeys("9293938584");
        Thread.sleep(2000);
        driver.quit();
    }
}
