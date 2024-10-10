package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PaymentDone {
    private Driver driver;


    By downloadInVoice = By.xpath("//a[@href=\"/download_invoice/1500\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");
    By orderPlaced = By.xpath("//h2[@data-qa=\"order-placed\"]");

    public PaymentDone(Driver driver){this.driver=driver;}

    /**********************************  Assertions  ****************************************/


    public PaymentDone checkThatPaymentDonePageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/payment_done/1500"));
        Assert.assertTrue(driver.element().isDisplayed(orderPlaced));
        return this;
    }

    public PaymentDone checkThatInvoiceIsDownloadedSuccessfully(){

        return this;
    }

    /**********************************  Actions  ****************************************/


    public PaymentDone clickOnDownloadInVoiceButton(){
        driver.element().click(downloadInVoice);
        return this;
    }

    public HomePage clickOnContinueButton(){
        driver.element().click(continueButton);
        return new HomePage(driver);
    }



}
