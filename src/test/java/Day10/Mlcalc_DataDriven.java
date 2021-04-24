package Day10;

import Day9.ReusableMethods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Mlcalc_DataDriven {
    public static void main(String[] args) throws IOException, InterruptedException, BiffException, WriteException {
        // set the driver using reusable method
        WebDriver driver = ReusableMethods.defineTheDriver();


        //Step1: locate the path for readable  file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/mlcalc.xls"));

        //Step2: Accessing the excel sheet to read the data
        //Sheet readableSheet = readableBook.getSheet("Sheet1");

        //Step3: create writeable workbook that will mimic the data from readable
        WritableWorkbook writeableWorkbook = Workbook.createWorkbook(new File("src/main/resources/mlcalcResult.xls"),readableBook);

        //read everything  from writeable sheet
        WritableSheet writeableSheet = writeableWorkbook.getSheet("Sheet1");
        //Step4: get the row count - |
        int rowCount = writeableSheet.getRows();

        // Loop will start to iterate through excel data

        for(int i =1; i<rowCount; i++){

            // Columns are hard coded and row is dynamic (i) - --
            String pPrice = writeableSheet.getCell(0,i).getContents();
            String dPayment = writeableSheet.getCell(1,i).getContents();
            String mMortgage = writeableSheet.getCell(2,i).getContents();
            String iInterest = writeableSheet.getCell(3,i).getContents();
            String  sMonth = writeableSheet.getCell(4,i).getContents();
            String  sYear = writeableSheet.getCell(5,i).getContents();

            //navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(3000);
            //enter the purchase price
            ReusableMethods.sendKeysMethod(driver,"//input[@id='ma']",pPrice,"Purchase Price");
            //enter the down payment
            ReusableMethods.sendKeysMethod(driver,"//input[@id='dp']",dPayment,"Down Payment");
            //enter mortgage term
            ReusableMethods.sendKeysMethod(driver,"//input[@id='mt']",mMortgage,"Mortgage Term");
            //enter interest rate
            ReusableMethods.sendKeysMethod(driver,"//input[@id='ir']",iInterest,"Interest Rate");
            //select start month
            ReusableMethods.dropdownByText(driver,"//select[@name='sm']",sMonth,"Start Month");
            //select start year
            ReusableMethods.dropdownByText(driver,"//select[@name='sy']",sYear,"Start Year");
            //click on Calculate
            ReusableMethods.clickOnElement(driver,"//input[@value='Calculate']","Calculate");

            //capture monthly payment
            String monthlyPayment = ReusableMethods.captureText(driver,"//td[@class='big']",0,"Monthly Payment");

            //create a label so you can add it to a cell
            Label label = new Label(6,i,monthlyPayment);
            //add the label back to the sheet
            writeableSheet.addCell(label);
        }//end of loop

        //outside of the cell write back to writable workbook
        writeableWorkbook.write();
        //close it
        writeableWorkbook.close();



    }
}
/*

//set the driver using reusable method
WebDriver driver = Reusable_Methods.defineTheDriver();

//Step1: locate the path for readable file that we created in excel
Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/Mlcalc_DataDriven.xls"));

//Step 2: create a writable workbook that will mimic the data from readable
WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/Mlcalc_DataDriven_Result.xls"),readableBook);

//Ste3 : read everything from writable sheet
WritableSheet writableSheet = writableWorkbook.getSheet(0);

//Step 4: get the row count
int rowCount = writableSheet.getRows();

//this is where the for loop will start to iterate through your excel data
for(int i =1; i <rowCount; i++){

    //columns are hard coded and row is dynamic(i)
    String pPrice = writableSheet.getCell(0,i).getContents();
    String dPayment = writableSheet.getCell(1,i).getContents();
    String mTerm = writableSheet.getCell(2,i).getContents();
    String iRate = writableSheet.getCell(3,i).getContents();
    String stMonth = writableSheet.getCell(4,i).getContents();
    String stYear = writableSheet.getCell(5,i).getContents();

    //navigate to mlcalc
    driver.navigate().to("https://www.mlcalc.com");
    Thread.sleep(3000);
    //enter the purchase price
    Reusable_Methods.sendKeysMethod(driver,"//input[@id='ma']",pPrice,"Purchase Price");
    //enter the down payment
    Reusable_Methods.sendKeysMethod(driver,"//input[@id='dp']",dPayment,"Down Payment");
    //enter mortgage term
    Reusable_Methods.sendKeysMethod(driver,"//input[@id='mt']",mTerm,"Mortgage Term");
    //enter interest rate
    Reusable_Methods.sendKeysMethod(driver,"//input[@id='ir']",iRate,"Interest Rate");
    //select start month
    Reusable_Methods.dropdownByText(driver,"//select[@name='sm']",stMonth,"Start Month");
    //select start year
    Reusable_Methods.dropdownByText(driver,"//select[@name='sy']",stYear,"Start Year");
    //click on Calculate
    Reusable_Methods.clickOnElement(driver,"//input[@value='Calculate']","Calculate");

    //capture monthly payment
    String monthlyPayment = Reusable_Methods.captureText(driver,"//td[@class='big']",0,"Monthly Payment");

    //create a label so you can add it to a cell
    Label label = new Label(6,i,monthlyPayment);
    //add the label back to the sheet
    writableSheet.addCell(label);
}//end of loop

//outside of the cell write back to writable workbook
writableWorkbook.write();
//close it
writableWorkbook.close();


* */
