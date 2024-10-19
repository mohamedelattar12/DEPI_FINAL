package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PaymentPage {
    private Driver driver;
    By deleteAccountBtn = By.xpath("//a[@href=\"/delete_account\"]");

    By payment = By.className("heading");
    By nameOnCardField = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvcField = By.xpath("//input[@data-qa=\"cvc\"]");
    By expirationMonth = By.name("expiry_month");
    By expriationYear = By.xpath("//input[@name=\"expiry_year\"]");
    By payAndConfirmBtn = By.xpath("//button[@class=\"form-control btn btn-primary submit-button\"]");

    /*********************************  Assertions  *****************************************************/

    @Step("Check that Payment Page is loaded successfully")
    public PaymentPage checkThatPaymentPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/payment"));
        Assert.assertTrue(driver.element().isDisplayed(payment));
        return this;

    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that user can click on fill payment form")
    public PaymentPage fillPaymentForm() {
        driver.element().fillField(nameOnCardField, "esraa");
        driver.element().fillField(cardNumber, "123456789");
        driver.element().fillField(cvcField, "311");
        driver.element().fillField(expirationMonth, "03");
        driver.element().fillField(expriationYear, "2025");
        return this;
    }

    @Step("Check that user can click on Pay and Confirm button")
    public PaymentSuccessPage clickOnPayAndConfirmBtn() {
        driver.element().click(payAndConfirmBtn);
        return new PaymentSuccessPage(driver);
    }

    @Step("Check that user can click on Delete Account button")
    public AccountSuccessfulDeletion clickOnDeleteAccountBtn() {
        driver.element().click(deleteAccountBtn);
        return new AccountSuccessfulDeletion(driver);

    }


    public PaymentPage(Driver driver) {
        this.driver = driver;
    }


}
