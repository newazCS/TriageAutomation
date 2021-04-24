package Assignment;

import Day9.ReusableMethods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class express {
    public static void main(String[] args) throws IOException, InterruptedException, BiffException, WriteException {
        WebDriver driver = ReusableMethods.defineTheDriver();

        // locate the path for readable  file that we created in excel
        Workbook readableBook = Workbook.getWorkbook(new File("src/main/resources/exp.xls"));

        //create writeable workbook that will mimic the data from readable
        WritableWorkbook writeableWorkbook = Workbook.createWorkbook(new File("src/main/resources/expResult.xls"), readableBook);

        //read everything  from writeable sheet
        WritableSheet writeableSheet = writeableWorkbook.getSheet("ex");

        //get the row count - |
        int rowCount = writeableSheet.getRows();

        // Loop will start to iterate through excel data
        for (int i = 1; i < rowCount; i++) {

            // Columns are hard coded and row is dynamic (i)
            String size = writeableSheet.getCell(0, i).getContents();
            String quantity = writeableSheet.getCell(1, i).getContents();
            String firstName = writeableSheet.getCell(2, i).getContents();
            String lastName = writeableSheet.getCell(3, i).getContents();
            String email = writeableSheet.getCell(4, i).getContents();
            String phone = writeableSheet.getCell(5, i).getContents();
            String streetAddress = writeableSheet.getCell(6, i).getContents();
            String zipcode = writeableSheet.getCell(7, i).getContents();
            String city = writeableSheet.getCell(8, i).getContents();
            String state = writeableSheet.getCell(9, i).getContents();
            String ccNumber = writeableSheet.getCell(10, i).getContents();
            String expMonth = writeableSheet.getCell(11, i).getContents();
            String expYear = writeableSheet.getCell(12, i).getContents();
            String cvvCode = writeableSheet.getCell(13, i).getContents();

            //1. Navigate to express website
            driver.navigate().to("https://www.express.com/");

            // Delete all the cookies
            driver.manage().deleteAllCookies();

            //Handle popup window
            ReusableMethods.clickOnElement(driver, "//button[@id='closeModal']", "popup");
            Thread.sleep(2000);

            //2. Hover over to Men Tab
            ReusableMethods.hoverAction(driver, "//a[text()='Men']", "Men Tab");

            //3. Clothing section click on sweaters
            ReusableMethods.clickOnElement(driver, "(//a[text()='Sweaters'])[2]", "Sweaters");
            Thread.sleep(2000);

            //4. Click on First sweater
            ReusableMethods.clickOnElement(driver, "(//div[@class='_3TJgM'])[1]", "First Sweaters");

            //5. Click on size
            ReusableMethods.clickOnElement(driver, "//button[@value='" + size + "']", size);
            Thread.sleep(2000);

            //6. Click on add to Bag
            ReusableMethods.clickOnElement(driver, "//button[text()='Add to Bag']", "Size M");
            Thread.sleep(2000);

            //7. Click on view Bag - Hover
            ReusableMethods.hoverAction(driver, "(//button[@aria-label='shopping bag'])[2]", "Shopping Bag");
            Thread.sleep(2000);

            // Click on view Bag
            ReusableMethods.clickOnElement(driver, "//a[text()='View Bag & Check Out']", "View Bag");
            Thread.sleep(2000);

            //8. Change the quantity
            ReusableMethods.dropdownByText(driver, "//select[@id='qdd-0-quantity']", quantity, "Quantity");
            Thread.sleep(2000);

            //9. Checkout to the right section of the page
            ReusableMethods.clickOnElement(driver, "//button[text()='Checkout']", "Checkout");
            Thread.sleep(2000);
            //10. Pop Up click on continue as Guest
            ReusableMethods.clickOnElement(driver, "//button[text()='Checkout as Guest']", "Checkout");
            Thread.sleep(2000);

            //11. Enter first name
            ReusableMethods.sendKeysMethod(driver, "//input[@name='firstname']", firstName, "FirstName");
            Thread.sleep(2000);

            //12. Enter last name
            ReusableMethods.sendKeysMethod(driver, "//input[@name='lastname']", lastName, "LastName");
            Thread.sleep(2000);

            //13. Enter email
            ReusableMethods.sendKeysMethod(driver, "(//input[@name='email'])[1]", email, "email");
            Thread.sleep(2000);

            //14. Re-enter email to confirm
            ReusableMethods.sendKeysMethod(driver, "(//input[@name='confirmEmail'])[1]", email, "Confirm email");

            //15. Enter phone number
            ReusableMethods.sendKeysMethod(driver, "(//input[@name='phone'])[1]", phone, "Phone");

            //16. Click on continue
            ReusableMethods.clickOnElement(driver, " //button[contains(@class,'btn _9yfmt')]", "Continue");
            Thread.sleep(2000);

            // Select country
            ReusableMethods.dropdownByText(driver, "//select[@name='shipping.countryCode']", "United States", "Country");

            //17. Enter street address
            ReusableMethods.sendKeysMethod(driver, "//input[@name='shipping.line1']", streetAddress, "Address");

            //Enter APT#
            ReusableMethods.sendKeysMethod(driver, "//input[@name='shipping.line2']", "apt 2", "Address");

            //18. Enter a valid zipcode
            ReusableMethods.sendKeysMethod(driver, "//input[@name='shipping.postalCode']", zipcode, "postalCode");

            //19. Enter a city
            ReusableMethods.sendKeysMethod(driver, "//input[@name='shipping.city']", city, "City");

            //20. Select a state
            ReusableMethods.dropdownByText(driver, "//select[@name='shipping.state']", state, "State");

            //21. Click on continue button
            ReusableMethods.clickOnElement(driver, "//button[contains(@class,'btn _9yfmt')]", "Continue");
            Thread.sleep(2000);

            // Click on continue again
            ReusableMethods.clickOnElement(driver, " //button[contains(@class,'btn _9yfmt')]", "Continue");
            Thread.sleep(2000);

            //22.  Enter fake credit card
            ReusableMethods.sendKeysMethod(driver, "//input[@id='creditCardNumberInput']", ccNumber, "Credit Card");

            //23. Select an expiration date
            ReusableMethods.dropdownByText(driver, "//select[@name='expMonth']", expMonth, "exp Month");

            //24. Select an expiration year
            ReusableMethods.dropdownByText(driver, "//select[@name='expYear']", expYear, "exp Year");

            //25. Enter CVV Code
            ReusableMethods.sendKeysMethod(driver, "//input[@name='cvv']", cvvCode, "CVV");
            Thread.sleep(2000);

            //26. Click on place order
            ReusableMethods.clickOnElement(driver, "//span[text()='Place Order']", "Place order");

            //capture the error message
            String errorMsg = ReusableMethods.captureText(driver, "//div[contains(@class,'notification')]", 0, "Error Message");

            // Write back to excel
            Label label = new Label(14, i, errorMsg);
            writeableSheet.addCell(label);

        } //end of loop
        //outside of the cell write back to writable workbook
        writeableWorkbook.write();

        //close it
        writeableWorkbook.close();
    } // end of main method
}// end of class
