package Day5;
/*

iterate through multiple on google search and print the number each time


 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SearchingCities {
    public static void main(String[] args) {

        String [] cities = new String[5];
        cities[0] ="Brooklyn";
        cities[1] ="Queens";
        cities[2] ="Manhattan";
        cities[3] ="Staten Island";
        cities[4] ="Bronx";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        for (String city : cities) {
            driver.navigate().to("https://www.google.com/");
            driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(city);
            driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).submit();
            String searchResult = driver.findElement(By.id("result-stats")).getText();
            String[] searchResultArray = searchResult.split(" ");
            String result = searchResultArray[1];
            System.out.println("The city " + city + " and the search result: " + result);
        }

        driver.quit();
    }
}
