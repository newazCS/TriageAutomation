package Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WeightWatch {
    public static void main(String[] args) {

        String[] zipCode = new String[3];
        zipCode[0] = "11218";
        zipCode[1] = "11218";
        zipCode[2] = "11218";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.mortgagecalculator.org/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Weight Watchers: Weight Loss & Welness Help";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title is match");
        }else{
            System.out.println("Doesn't match the title");
        }


    }
}
