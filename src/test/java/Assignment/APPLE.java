package Assignment;

import ReusableLibrary.AbstractClass;
import ReusableLibrary.ReusableActions;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class APPLE extends AbstractClass {

    @Test
    public void Apple() throws IOException, InterruptedException {
        driver.navigate().to("https://www.apple.com/");
        Thread.sleep(1000);
       ReusableActions.clickOnElement(driver,"//a[contains(@class,'iphone')]",logger,"iPhone");
        Thread.sleep(1000);
        ReusableActions.clickOnElement(driver,"(//a[contains(@class,'chapternav')])[2]",logger,"iphone12");
        Thread.sleep(1000);
        ReusableActions.clickOnElement(driver,"//a[text()='Buy']",logger,"Buy");
        Thread.sleep(1000);
        ReusableActions.clickOnElement(driver,"//label[@id='Item16_1inch_label']",logger,"iPhone 12");
        Thread.sleep(1000);
        ReusableActions.clickOnElement(driver,"//label[@id='Item2blue_label']",logger,"Blue Color");
        Thread.sleep(1000);
        ReusableActions.clickOnElement(driver,"//label[@id='Item40_label']",logger,"SIM-free");
        Thread.sleep(1000);
        ReusableActions.clickOnElement(driver,"//label[@id='Item5256gb_label']",logger,"256 GB");
        Thread.sleep(1000);
        ReusableActions.clickOnElement(driver,"//label[@for='noTradeIn']",logger,"Trade");
        Thread.sleep(1000);
        ReusableActions.clickOnElement(driver,"//label[@for='fullPrice']",logger,"One-time payment");
        Thread.sleep(2000);
        ReusableActions.clickOnElement(driver,"//button[@name='add-to-cart']",logger,"Add to Bag");
        Thread.sleep(2000);
        ReusableActions.clickOnElement(driver,"//button[@name='proceed']",logger,"Review Bag");
        Thread.sleep(2000);
        ReusableActions.clickOnElement(driver,"//button[@id='shoppingCart.actions.navCheckout']",logger,"Check Out");
        Thread.sleep(2000);
        ReusableActions.clickOnElement(driver,"//button[@id='signIn.guestLogin.guestLogin']",logger,"Continue as Guest");
        Thread.sleep(2000);
        ReusableActions.clickOnElement(driver,"//label[contains(@for,'ButtonGroup1')]",logger,"Continue as Guest");

        List<WebElement> locations = driver.findElements(By.xpath("//div[@class='form-selector-title']"));
        for(int i =0;i<locations.size();i++){
           String  LocationAvailable = ReusableActions.captureText(driver,"//div[@class='form-selector-title']",i,logger,"Available");
           logger.log(LogStatus.INFO,LocationAvailable);
            System.out.println(LocationAvailable);
        }
        Thread.sleep(5000);





    }
}
