package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutPage {
    private Driver driver;

    By addressDetails = By.xpath("//ul[@class=\"address item box\"]");
    By reviewOrder = By.xpath("//div[@class=\"table-responsive cart_info\"]");
    By textArea = By.xpath("//textarea[@class=\"form-control\"]");
    By placeOrderBtn = By.xpath("//a[@class=\"btn btn-default check_out\"]");

    public CheckoutPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check that CheckOut Page is loaded successfully")
    public CheckoutPage checkThatCheckOutPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/checkout"));
        Assert.assertTrue(driver.element().isDisplayed(addressDetails));
        Assert.assertTrue(driver.element().isDisplayed(reviewOrder));
        return this;
    }

    @Step("Check address details is displayed")
    public CheckoutPage checkAddressDetailsIsDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(addressDetails));
        return this;
    }

    @Step("Check review order is displayed")
    public CheckoutPage checkReviewOrderIsDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(reviewOrder));
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that user can fill in text area")
    public CheckoutPage fillInTextArea() {
        driver.element().fillField(textArea, "Blue Top");
        return this;
    }

    @Step("Check that user can click on Place Order button")
    public PaymentPage clickOnPlaceOrderBtn() {
        driver.element().click(placeOrderBtn);
        return new PaymentPage(driver);
    }


}


