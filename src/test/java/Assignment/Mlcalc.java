package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class Mlcalc {
    public static void main(String[] args) throws InterruptedException {

        String [] loanAmount = new String[3];
        loanAmount[0]="250000";
        loanAmount[1]="150000 ";
        loanAmount[2]="100000";

        String [] loanTerm = new String[3];
        loanTerm[0]="5";
        loanTerm[1]="10";
        loanTerm[2]="15";

        String []interestRate = new String[3];
        interestRate[0]="2.5";
        interestRate[1]="4.6";
        interestRate[2]="5.3";

        String [] startMonth = new String[3];
        startMonth[0]="Oct";
        startMonth[1]="Nov";
        startMonth[2]="Dec";

        String [] startYear = new String[3];
        startYear[0]="2022";
        startYear[1]="2023";
        startYear[2]="2024";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);



        for(int i = 0; i<loanAmount.length;i++){

            //1. Navigate
            driver.navigate().to("https://www.mlcalc.com/");
            String actualTitle = driver.getTitle();
            String expectedTitle = "Auto Loan Calculater";

            //2. Verify the title: Auto Loan Calculater
            if(actualTitle.equals(expectedTitle)){
                System.out.println("Match the title ");
            }else {
                System.out.println("Don't match the title ");
            }

            //3. Clear and enter the loan amount
            WebElement LoanAmount = driver.findElement(By.xpath("//input[@id='la']"));
            LoanAmount.clear();
            LoanAmount.sendKeys(loanAmount[i]);

            //4. Clear and enter the Loan term
            WebElement LoanTerm = driver.findElement(By.xpath("//input[@id='lt']"));
            LoanTerm.clear();
            LoanTerm.sendKeys(loanTerm[i]);

            //5. Clear and enter the interest rate
            WebElement InterestRate = driver.findElement(By.xpath("//input[@id='lir']"));
            InterestRate.clear();
            InterestRate.sendKeys(interestRate[i]);

            Thread.sleep(1000);
            //6.Select a start month from the dropdown
            WebElement StartDate = driver.findElements(By.xpath("//*[@id='fpdd']")).get(2);
            Select dropdownDate = new Select(StartDate);
            Thread.sleep(1000);
            dropdownDate.selectByVisibleText(startMonth[i]);
            // dropdownDate.selectByIndex(6);

            Thread.sleep(1000);
            //7. Select start year from the dropdown
            WebElement StartYear = driver.findElements(By.xpath("//*[@id='fpdy']")).get(2);
            Select dropdownYear = new Select(StartYear);
            dropdownYear.selectByVisibleText(startYear[i]);
            // StartYear.click();
            Thread.sleep(1000);
            //  driver.findElement(By.xpath("(//option[text()='2021'])[1]")).click();

            Thread.sleep(2000);
            //8. Click on calculate button
            driver.findElements(By.xpath("//input[@type='submit']")).get(2).click();

            //9. Wait few seconds
            Thread.sleep(3000);

            //10. Capture monthly payment and print out the monthly payment
            String monthlyPayment = driver.findElements(By.xpath("//td[@class='big']")).get(0).getText();
            System.out.println("The loan amount is $"+ loanAmount[i] +"\n and loan term is "+loanTerm[i]+ "years "+" with the Interest rate of  "+ interestRate[i] + "%.\n The start date "+startMonth[i]+ " "+ startYear[i] +"."+"\nThe monthly payment "+monthlyPayment);
            System.out.println("---------------------------");
        }
        driver.close();


    }
}
