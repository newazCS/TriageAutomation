package Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MortgageCalculator {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        // define the chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        options.addArguments("start-maximized");
        //set the driver to incognito (private)
        options.addArguments("incognito");
        //set it to headless
        //options.addArguments("headless");
        // define the web driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to yahoo page
        driver.navigate().to("https://www.mortgagecalculator.org/");
        String siteTitle = driver.getTitle();
        System.out.println(siteTitle);
        String expected = "Mortgage Calculator";

        if (siteTitle.equalsIgnoreCase(expected)) {
            System.out.println("The Title is Right");
        } else {
            System.out.println("The Title is Wrong");
        }

        WebElement HomeValue = driver.findElement(By.cssSelector("#homeval"));
        HomeValue.clear();
        HomeValue.sendKeys("100000");

        WebElement downPayment = driver.findElement(By.xpath("//input[@id='downpayment']"));
        downPayment.clear();
        downPayment.sendKeys("20000");

        WebElement loanPayment = driver.findElement(By.xpath("//input[@id='loanamt']"));
        loanPayment.clear();
        loanPayment.sendKeys("300000");

        WebElement InterestRate = driver.findElement(By.xpath("//input[@id='intrstsrate']"));
        InterestRate.clear();
        InterestRate.sendKeys("4.1");

        WebElement loanTerm = driver.findElement(By.xpath("//input[@id='loanterm']"));
        loanTerm.clear();
        loanTerm.sendKeys("40");

        WebElement monthsSelection = driver.findElement(By.name("param[start_month]"));
        Select months = new Select(monthsSelection);
        months.selectByValue("6");

        driver.findElement(By.xpath("//input[@id='start_year']")).sendKeys("2022");

        WebElement propertyTax = driver.findElement(By.xpath("//input[@id='pptytax']"));
        propertyTax.clear();
        propertyTax.sendKeys("3000");

        WebElement PMI = driver.findElement(By.xpath("//input[@id='pmi']"));
        PMI.clear();
        PMI.sendKeys("1.5");


        WebElement HOI = driver.findElement(By.xpath("//input[@id='hoi']"));
        HOI.clear();
        HOI.sendKeys("500");

        WebElement HOA = driver.findElement(By.xpath("//input[@id='hoa']"));
        HOA.clear();
        HOA.sendKeys("1000");


        WebElement LoanType = driver.findElement(By.name("param[start_month]"));
        Select LoanTypeSelect = new Select(LoanType);
        LoanTypeSelect.selectByValue("6");


        WebElement BuyorRefi = driver.findElement(By.xpath("//select[@name='param[milserve]']"));
        Select BORselect = new Select(BuyorRefi);
        BORselect.selectByValue("4");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String monthlyPayment = driver.findElement(By.xpath("(//div[@class='left-cell'])[1]")).getText();
        System.out.println("My monthly payment: "+monthlyPayment);

        Thread.sleep(10000);


        // if dropdown is not under select tag then you have to use click command twice
        //click on dropdown
        //BuyorRefi.click();
        // click on dropdown value by text
       // driver.findElement(By.xpath("//*[text()='VA']")).click();


    }
}
