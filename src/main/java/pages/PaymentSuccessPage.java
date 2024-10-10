package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PaymentSuccessPage {
    private Driver driver;
    By deleteAccountBtn = By.xpath("//a[@href=\"/delete_account\"]");
    By successPaymentMessage = By.xpath("(//p)[1]");


    public PaymentSuccessPage (Driver driver){
        this.driver = driver;
    }
/*********************************  Assertions  *****************************************************/
    public PaymentSuccessPage checkSuccessMessageIsDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(successPaymentMessage));
        return this;
    }
/*********************************  Actions  *****************************************************/

    public AccountSuccessfulDeletion clickOnDeleteAccountBtn(){
        driver.element().click(deleteAccountBtn);
        return new AccountSuccessfulDeletion(driver);

    }
}

