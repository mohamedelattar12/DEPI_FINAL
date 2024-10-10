package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ViewCartPage {

    Driver driver;

    By productsTable=By.xpath("//div[@id=\"cart_info\"]");
    By addedProductDescription = By.xpath("//a[@href=\"/product_details/1\"]");
    By addedProductQuantity = By.xpath("//button[@class=\"disabled\"]");
    By proceedToCheckOutBtn = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    By registerLoginBtn = By.xpath("(//a[@href=\"/login\"])[2]");
    By ptcobtn = By.xpath("//a[@class=\"btn btn-default check_out\"]");

    public ViewCartPage(Driver driver) {
        this.driver = driver;
    }

    /**********************************  Assertions  ****************************************/

    public ViewCartPage checkThatViewCartPageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/view_cart"));
        Assert.assertTrue(driver.element().isDisplayed(productsTable));
        return this;
    }
    public ViewCartPage checkThatProductIsAdded(){
        Assert.assertTrue(driver.element().isDisplayed(addedProductDescription));
        return this;
    }
    public ViewCartPage checkThatProductQuantityIsRight(){
        Assert.assertTrue(driver.element().isDisplayed(addedProductQuantity));
        return this;
    }

    /*********************************  Actions  *****************************************************/

    public ViewCartPage clickOnProceedToCheckOut(){
        driver.element().click(proceedToCheckOutBtn);
       return this;
    }
    public CheckoutPage clickonproceedtocheckoutbtn(){
        driver.element().click(ptcobtn);
        return new CheckoutPage(driver);
    }


    public LoginSignupPage clickOnRegisterLoginBtn(){
        driver.element().click(registerLoginBtn);
        return new LoginSignupPage(driver);
    }

}