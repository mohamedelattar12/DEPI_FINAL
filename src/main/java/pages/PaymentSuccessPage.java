package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PaymentSuccessPage {
    private Driver driver;
    By deleteAccountBtn = By.xpath("//a[@href=\"/delete_account\"]");
    By successPaymentMessage = By.xpath("(//p)[1]");
    By downloadInVoice = By.xpath("//a[@href=\"/download_invoice/500\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");


    public PaymentSuccessPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check that success message is displayed")
    public PaymentSuccessPage checkSuccessMessageIsDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(successPaymentMessage));
        return this;
    }

    @Step("Check that invoice is downloaded successfully")
    public PaymentSuccessPage checkThatInvoiceIsDownloadedSuccessfully() {
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that user can click on Delete Account button")
    public AccountSuccessfulDeletion clickOnDeleteAccountBtn() {
        driver.element().click(deleteAccountBtn);
        return new AccountSuccessfulDeletion(driver);
    }

    @Step("Check that user can click on download invoice button")
    public PaymentSuccessPage clickOnDownloadInVoiceButton() {
        driver.element().click(downloadInVoice);
        return this;
    }

    @Step("Check that user can click on continue button")
    public HomePage clickOnContinueButton() {
        driver.element().click(continueButton);
        return new HomePage(driver);
    }
}

