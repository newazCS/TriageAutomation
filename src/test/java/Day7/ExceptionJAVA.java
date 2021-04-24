package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

/*
*
* What is exception?
* - Is an event, which occurs during the execution of a program, where any issue which makes your test case stop in between
* the execution is an exception
*
* Try & Catch exception
* We can also use try and catch exception when performing actions in a webpage to handle any error.
* try is the start of the block and catch is at the end of try block to handle exceptions.
*
* The syntax is followed:
* try{
* //Some code
* }catch(Exception e){
* // code for handling exception
* }
*
* example:
* try{
* Driver.element(By.id("xyz")).click()
*
* }catch(Exception e){
* System.out.println("Unable to click on element "+e);
* }
*
* */
public class ExceptionJAVA {
    public static void main(String[] args) throws InterruptedException, IOException {


        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1500);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        //navigate to bing home page
        driver.navigate().to("https://www.bing.com/");
        Thread.sleep(2000);

        // enter a keyword on search field
        try{
            driver.findElement(By.name("q")).sendKeys("Java Selenium");
        }catch(Exception e){
            System.out.println("Unable to enter keyword on search field"+e);
        }

        //click search icon

        try{
            driver.findElement(By.xpath("//label[@for='sb_form_go']")).click();
        }catch(Exception e){
            System.out.println("Unable to click search iCon"+e);
        }
    }
}






























