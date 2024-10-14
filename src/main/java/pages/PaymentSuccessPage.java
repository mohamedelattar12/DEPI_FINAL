package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PaymentSuccessPage {
    private Driver driver;
    By deleteAccountBtn = By.xpath("//a[@href=\"/delete_account\"]");
    By successPaymentMessage = By.xpath("(//p)[1]");
    By downloadInVoice = By.xpath("//a[@href=\"/download_invoice/500\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");


    public PaymentSuccessPage (Driver driver){
        this.driver = driver;
    }
/*********************************  Assertions  *****************************************************/
    public PaymentSuccessPage checkSuccessMessageIsDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(successPaymentMessage));
        return this;
    }

    public PaymentSuccessPage checkThatInvoiceIsDownloadedSuccessfully(){

        return this;
    }
/*********************************  Actions  *****************************************************/

    public AccountSuccessfulDeletion clickOnDeleteAccountBtn(){
        driver.element().click(deleteAccountBtn);
        return new AccountSuccessfulDeletion(driver);

    }
    public PaymentSuccessPage clickOnDownloadInVoiceButton(){
        driver.element().click(downloadInVoice);
        return this;
    }

    public HomePage clickOnContinueButton(){
        driver.element().click(continueButton);
        return new HomePage(driver);
    }
}

