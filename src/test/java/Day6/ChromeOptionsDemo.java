package Day6;
/*
ChromeOptions: allow you to set multiple arguments before defining the WebDriver
ChromeOptions need to be called before defining the WebDriver
Take a look at the below syntax on how it is defined
ChromeOptions option = new ChromeOptions();
options.addArguments("start-maximized");


ChromeOptions can also be used to set other different arguments such as setting the browser to
private/incognito mode.
example: options.addArguments("start-maximized","incognito")

can also make browser headless which means without opening the browser you can execute your testing
example: options.addArguments("headless")
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDemo {
    public static void main(String[] args) {
        // set the path to the driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        // define the chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        options.addArguments("start-maximized");
        //set the driver to incognito (private)
        options.addArguments("incognito");
        //set it to headless
       // options.addArguments("headless");
        // define the web driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to yahoo page
        driver.navigate().to("https://www.yahoo.com/");
    }// end of main method
}// end of java class
