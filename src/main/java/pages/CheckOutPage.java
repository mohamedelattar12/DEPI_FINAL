package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckOutPage {
    private Driver driver;

    By addressDetails = By.xpath("(//h2[@class=\"heading\"])[1]");
    By reviewYourOrder = By.xpath("(//h2[@class=\"heading\"])[2]");
    By descriptionTextArea = By.xpath("//textarea[@class=\"form-control\"]");
    By placeOrder = By.xpath("//a[@href=\"/payment\"]");

    public CheckOutPage(Driver driver) {
        this.driver = driver;
    }

    /**********************************  Assertions  ****************************************/

    public CheckOutPage checkThatCheckOutPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/checkout"));
        Assert.assertTrue(driver.element().isDisplayed(addressDetails));
        Assert.assertTrue(driver.element().isDisplayed(reviewYourOrder));
        return this;
    }


    /**********************************  Actions  ****************************************/

    public CheckOutPage fillInDescriptionInCommentTextArea(String description) {
        driver.element().fillField(descriptionTextArea, description);
        return this;

    }

    public Payment clickOnPlaceOrderButton() {
        driver.element().click(placeOrder);
        return new Payment(driver);
    }



}
