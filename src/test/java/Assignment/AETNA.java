package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;

public class AETNA {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Essential
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1500);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        //Zip Code
        ArrayList<String> ZipCode = new ArrayList<String>();
        ZipCode.add("11218");
        ZipCode.add("11219");
        ZipCode.add("11220");

        //Miles Range
        ArrayList<Integer> milesRange = new ArrayList<Integer>();
        milesRange.add(60);
        milesRange.add(70);
        milesRange.add(20);


        for(int i=0; i<ZipCode.size();i++){

            //1. Navigate to Aetna Homepage
            try{
                driver.navigate().to("https://www.aetna.com/");
            }catch (Exception e){
                System.out.println("Unable to navigate "+ e);
            }

            //2.Verify homepage title is Health Insurance Plans | Aetna
            try{
                String expectedTitle ="Health Insurance Plans | Aetna";
                String actualTitle = driver.getTitle();
                if(actualTitle.equals(expectedTitle)){
                    System.out.println("Match the title: "+expectedTitle);
                }else {
                    System.out.println("Does not match the title: "+actualTitle);
                }
            }catch (Exception e){
                System.out.println("Unable to verify title "+ e);
            }

            //3. Click on shop for a plan
            try{
                driver.findElements(By.xpath("//button[text()='Shop for a plan']")).get(0).click();
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println("Unable to Click on shop for a plan "+ e);
            }

            //4. Click on Medicare link
            try{
                driver.findElements(By.xpath("//button[text()='Medicare']")).get(0).click();
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println("Unable to Click on Medicare link "+ e);
            }

            //5. On the right side click on Find a doctor
            try{
                driver.findElements(By.xpath("//a[text()='Find a doctor ']")).get(0).click();
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println("Unable to Click on Find a doctor link "+ e);
            }

            //6. On guest section click on 2021 Medicare plans your purchase yourself
            try{
                driver.findElements(By.xpath("//button[contains(@class,'primaryPurple')]")).get(1).click();
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println("Unable to Click  2021 Medicare plans "+ e);
            }

            //7. Clear and enter a zipcode
            try{
                WebElement zip = driver.findElement(By.xpath("//input[@id='medZip']"));
                zip.clear();
                zip.sendKeys(ZipCode.get(i));
                Thread.sleep(5000);
            }catch (Exception e){
                System.out.println("Unable to Clear and enter a zipcode "+ e);
            }

            //8. zipCode dropdown suggestion
            try{
                driver.findElement(By.xpath("//li[contains(@class,'active')]")).click();
                Thread.sleep(4000);
            }catch (Exception e){
                System.out.println("Unable to select from dropdown suggestion "+ e);
            }

            //9. Slide
            try{
                WebElement slide = driver.findElement(By.xpath("//span[@role='slider']"));
                Actions move = new Actions(driver);
                Action action = move.dragAndDropBy(slide, milesRange.get(i), 0).build();
                action.perform();
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println("Unable to Slide "+ e);
            }

            //10. Click on skip plan section
            try{
                driver.findElement(By.xpath("//button[text()='Skip plan selection*']")).click();
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println("Unable to  Click on skip plan section "+ e);
            }

            //11. click on Medical Doctors and specialists
            try{
                driver.findElements(By.xpath("//div[contains(@class,'search-block')]")).get(0).click();
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println("Unable to  click on Medical Doctors and specialists"+ e);
            }

            //12. Click on Doctor (Primary care)
            try{
                driver.findElements(By.xpath("//div[contains(@class,'search-block')]")).get(0).click();
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println("Unable to  Click on Doctor (Primary care) "+ e);
            }

            //13. Click on all primary care physicians
            try{
                driver.findElements(By.xpath("//div[contains(@class,'result-description')]")).get(0).click();
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println("Unable to  Click on all primary care physicians "+ e);
            }

            //14. Under provider/Facility information print out the first result for doctor's name and clinic address
            try {
                Thread.sleep(3000);
                ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//a[@class='providerNameDetails']")));
                String doctorNameInfo = links.get(0).getText();
                String []doctorNameArray = doctorNameInfo.split("column");
                String doctorName = doctorNameArray[1];
                System.out.println(doctorName);
                Thread.sleep(2000);
                String doctorAddress= driver.findElements(By.xpath("//span[contains(@class,'dataGridPadding')]")).get(0).getText();
                String doctorPhone= driver.findElements(By.xpath("//span[contains(@class,'dataGridPadding')]")).get(1).getText();
                System.out.println(doctorAddress);
                System.out.println(doctorPhone);

            }catch (Exception e){
                System.out.println("Index Out Of Bounds Exception "+e);
            }
            Thread.sleep(4000);
            System.out.println("----------------------");

        }
        driver.close();

    }
}
