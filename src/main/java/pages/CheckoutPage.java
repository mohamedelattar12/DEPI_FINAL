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
    By yourDeliveryAddressTitle = By.xpath("//ul[@id=\"address_delivery\"]");
    By yourDeliveryAddressFirstLastName = By.xpath("//ul[@id=\"address_delivery\"]/li[2]");
    By yourDeliveryAddressAddress1Address2 = By.xpath("//ul[@id=\"address_delivery\"]/li[4]");
    By yourDeliveryAddressCityStatePostcode = By.xpath("//ul[@id=\"address_delivery\"]/li[6]");
    By yourDeliveryAddressCountry = By.xpath("//ul[@id=\"address_delivery\"]/li[7]");
    By yourDeliveryAddressPhone = By.xpath("//ul[@id=\"address_delivery\"]/li[8]");
    By yourBillingAddressTitle = By.xpath("//ul[@id=\"address_invoice\"]");
    By yourBillingAddressFirstLastName = By.xpath("//ul[@id=\"address_invoice\"]/li[2]");
    By yourBillingAddressAddress1Address2 = By.xpath("//ul[@id=\"address_invoice\"]/li[4]");
    By yourBillingAddressCityStatePostcode = By.xpath("//ul[@id=\"address_invoice\"]/li[6]");
    By yourBillingAddressCountry = By.xpath("//ul[@id=\"address_invoice\"]/li[7]");
    By yourBillingAddressPhone = By.xpath("//ul[@id=\"address_invoice\"]/li[8]");
    By deleteAccountBtn = By.xpath("//a[@href=\"/delete_account\"]");


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

    @Step("Verify that the delivery address is same address filled")
    public CheckoutPage verifyThatDeliveryAddressSameAsAddressFilled() {
        Assert.assertTrue(driver.element().isDisplayed(yourDeliveryAddressTitle));
        Assert.assertEquals(driver.element().getTextOf(yourDeliveryAddressFirstLastName),". "+"Mariam"+" "+"Beshara");
        Assert.assertEquals(driver.element().getTextOf(yourDeliveryAddressAddress1Address2),"Alex");
        Assert.assertEquals(driver.element().getTextOf(yourDeliveryAddressCityStatePostcode),"Alex"+" "+"Alex"+" "+"123456");
        Assert.assertEquals(driver.element().getTextOf(yourDeliveryAddressCountry),"Canada");
        Assert.assertEquals(driver.element().getTextOf(yourDeliveryAddressPhone),"01236985214");
        return this;
    }

    @Step("Verify that the billing address is same address filled")
    public CheckoutPage verifyThatBillingAddressSameAsAddressFilled() {
        Assert.assertTrue(driver.element().isDisplayed(yourBillingAddressTitle));
        Assert.assertEquals(driver.element().getTextOf(yourBillingAddressFirstLastName),". "+"Mariam"+" "+"Beshara");
        Assert.assertEquals(driver.element().getTextOf(yourBillingAddressAddress1Address2),"Alex");
        Assert.assertEquals(driver.element().getTextOf(yourBillingAddressCityStatePostcode),"Alex"+" "+"Alex"+" "+"123456");
        Assert.assertEquals(driver.element().getTextOf(yourBillingAddressCountry),"Canada");
        Assert.assertEquals(driver.element().getTextOf(yourBillingAddressPhone),"01236985214");
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

    @Step("Check that user can click on Delete Account button")
    public AccountSuccessfulDeletion clickOnDeleteAccountBtn() {
        driver.element().click(deleteAccountBtn);
        return new AccountSuccessfulDeletion(driver);
    }


}


