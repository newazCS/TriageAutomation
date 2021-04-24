package Day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ReusableMethods {

    //Create a reusable method for navigate to a page
    public static WebDriver defineTheDriver() throws IOException, InterruptedException {
        // Kill all chrome instances that are open
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1500);
        //set the path of the driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
       //define the chrome options argument
        ChromeOptions options = new ChromeOptions();
        // maximized windows
        options.addArguments("start-maximized");
        //set the driver to incognito - private
        options.addArguments("incognito");
        //set it to headless
        //options.addArguments("headless");

        // define the webdriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;

    }// end of defineTheDriver method

    // method to click on any web element by explicit wait

    public static void clickOnElement(WebDriver driver, String xpathLocator, String elementName){
        // define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
        }catch (Exception e){
            System.out.println("Unable to click on element "+elementName+ " "+ e);
        }
    }// end of click method


    public static void sendKeysMethod(WebDriver driver, String xpathLocator,String userValue, String elementName){
        // define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //use try catch to locate an element and click on it
        try{
           WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
           element.clear();
           element.sendKeys(userValue);
        }catch (Exception e){
            System.out.println("Unable to click on element "+elementName+ " "+ e);
        }
    }// end of  sendKeysMethod


    public static void Submit(WebDriver driver, String xpathLocator){
        // define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        //use try catch to locate an element and click on it
        try{
            WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            element.submit();
        }catch (Exception e){
            System.out.println("Unable to click on element "+ e);
        }
    }// end of submit method


    public static void dropdownByText(WebDriver driver,String xpath,String userValue,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(userValue);
        } catch (Exception e) {
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
    }//end of dropdown by text

    public static String captureText(WebDriver driver,String xpath,int index,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }
        return result;
    }//end of dropdown by text

    //house action

    public static void hoverAction(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions mouseAction = new Actions(driver);

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(element).perform();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Unable to Hover on element " + elementName + " " + e);
        }

    }// end of hover action


    public static void clickMultiElement(WebDriver driver,String xpath,int index,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);

        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();

        } catch (Exception e) {
            System.out.println("Unable to select a value from " + elementName + " " + e);
        }

    }



}//end of class
