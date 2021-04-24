package Day12;

import ReusableLibrary.AbstractClass;
import ReusableLibrary.ReusableActions;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class GoogleSearchHTMLReport extends AbstractClass {
    @Test
    public void SearchForACar() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2500);
        //search for a car
        ReusableActions.sendKeysMethod(driver,"//*[@name='q']","cars",logger,"Search Field");
        //submit on google search button
        ReusableActions.Submit(driver,"//*[@name='btnK']",logger);
        Thread.sleep(3000);
    }//end of test 1

    @Test(dependsOnMethods = "SearchForACar")
    public void getSearchNumber(){
        String result = ReusableActions.captureText(driver,"//*[@id='result-stats']",0,logger,"Google Search Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.INFO,"My search number is " + arrayResult[1]);
    }//e
}
