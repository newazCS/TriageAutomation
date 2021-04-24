package Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchResult {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("apple");

       driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[3]/center/input[1]")).click();
        String result = driver.findElement(By.id("result-stats")).getText();
        String[] resultArray =  result.split(" ");
        System.out.println("The result is "+ resultArray[1]);
        driver.close();
    }
}
