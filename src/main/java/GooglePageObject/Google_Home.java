package GooglePageObject;

import ReusableLibrary.AbstractClass;
import ReusableLibrary.ReusableActionsPageObject;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google_Home extends AbstractClass{

    //declare a local logger so you can use it in your page class
    ExtentTest logger;

    public Google_Home(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = AbstractClass.logger;
    }//end of constructor class

    //define all the WebElement you need using @FindBy concept
    @FindBy(xpath = "//*[@name='q']")
    WebElement googleSearch;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googleSearchButton;

    //create a method for google search
    public void GoogleSearch(String userValue){
        ReusableActionsPageObject.sendKeysMethod(driver,googleSearch,userValue,logger,"Google Search");
    }//end of google search

    //create a method for google search button
    public void SearchButton(){
        ReusableActionsPageObject.Submit(driver,googleSearchButton,logger);
    }//end of google search



}
