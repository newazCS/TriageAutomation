package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class GoogleSearchResult {
    public static void main(String[] args) {
        //set the property to the Chrome Driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Define the webDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the Window
        driver.manage().window().maximize();

        // Wait 10 seconds to load the webpage
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Navigate to Google Home
        driver.navigate().to("https://www.google.com/");

        // Enter a keyword on google search field
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("amazon");

        //Enter the search button
        driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).submit();

        //Get the result from search
        String searchResult = driver.findElement(By.id("result-stats")).getText();

        // Split the value to get specific number
        String[] searchResultArray = searchResult.split(" ");

        //Get the right value using index
        String result = searchResultArray[1];

        //Print out the result
        System.out.println("The search result: " + result);

        //Exit from the browser
        driver.quit();
    }
}
