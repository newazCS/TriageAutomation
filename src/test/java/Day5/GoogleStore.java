package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleStore {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.google.com/");
        driver.findElements(By.xpath("//*[@class='MV3Tnb']")).get(1).click();
        driver.findElement(By.xpath("//img[@title='Fitbit versa 3']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[@type='button'])[6]")).submit();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//button[@jsaction='vcwKh'])[1]")).click();

        //driver.findElements(By.cssSelector(".button.primary.transaction.async-cta")).get(2).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
