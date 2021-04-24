package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class local {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Apple");
        driver.findElement(By.xpath("//input[contains(@data-ved,'A0')]")).submit();
        String text =  driver.findElement(By.id("result-stats")).getText();

        String textArray[] = text.split(" ");

        System.out.println("The search result "+textArray[1]);

        driver.close();

    }
}
