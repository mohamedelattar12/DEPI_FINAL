package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutPage {
    private Driver driver;

    By addressDetails = By.xpath("//ul[@class=\"address item box\"]");
    By reviewOrder = By.xpath("//tr[@class=\"cart_menu\"]");
    By textArea = By.xpath("//textarea[@class=\"form-control\"]");
    By placeOrderBtn = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    public CheckoutPage(Driver driver) {
        this.driver = driver;
    }

    public CheckoutPage CheckAddressDetailsIsDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(addressDetails));
        return this;
    }
    public CheckoutPage CheckReviewOrderIsDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(reviewOrder));
        return this;
    }

    public CheckoutPage fillInTextArea(){
        driver.element().fillField(textArea,"Blue Top");
        return this;
    }
    public PaymentPage clickOnPlaceOrderBtn(){
      driver.element().click(placeOrderBtn);
      return new PaymentPage(driver);
    }








}


