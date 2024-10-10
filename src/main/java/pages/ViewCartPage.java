package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ViewCartPage {

    private Driver driver;

    By productsTable = By.xpath("//div[@id=\"cart_info\"]");
    By proceedToCheckOut = By.cssSelector("a.check_out");
    By registerLogin = By.xpath("(//a[@href=\"/login\"])[2]");

    public ViewCartPage(Driver driver) {
        this.driver = driver;
    }

    /**********************************  Assertions  ****************************************/

    public ViewCartPage checkThatViewCartPageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/view_cart"));
        Assert.assertTrue(driver.element().isDisplayed(productsTable));
        return this;
    }


    /**********************************  Actions  ****************************************/

    public ViewCartPage clickOnProceedToCheckOutButtonForNonRegisterUser(){
        driver.element().click(proceedToCheckOut);
        return new ViewCartPage(driver);
    }

    public CheckOutPage clickOnProceedToCheckOutButtonForRegisterUser(){
        driver.element().click(proceedToCheckOut);
        return new CheckOutPage(driver);
    }

    public LoginSignupPage clickOnRegisterLoginButton(){
        driver.element().click(registerLogin);
        return new LoginSignupPage(driver);
    }



}