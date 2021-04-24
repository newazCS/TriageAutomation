package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTestNG {

    // Capture search result from google
    WebDriver driver;
    @BeforeSuite
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void TestCases1(){
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("amazon");
        driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).submit();

    }
    @Test(priority = 2)
    public void TestCases2(){
        String searchResult = driver.findElement(By.id("result-stats")).getText();
        String[] searchResultArray = searchResult.split(" ");
        String result = searchResultArray[1];
        System.out.println("The search result: " + result);
    }


    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }

}
