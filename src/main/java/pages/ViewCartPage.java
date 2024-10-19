package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ViewCartPage {

    Driver driver;

    By productsTable = By.xpath("//div[@id=\"cart_info\"]");
    By addedProductDescription = By.xpath("//td[@class=\"cart_description\"]");
    By addedProductQuantity = By.xpath("//button[@class=\"disabled\"]");
    By proceedToCheckOutBtn = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    By registerLoginBtn = By.xpath("(//a[@href=\"/login\"])[2]");
    By ptcobtn = By.xpath("//a[@class=\"btn btn-default check_out\"]");

    By firstProductName = By.xpath("//a[@href=\"/product_details/1\"]");
    By firstProductPrice = By.xpath("(//td[@class=\"cart_price\"]/p)[1]");
    By firstProductQuantity = By.xpath("(//td[@class=\"cart_quantity\"]/button)[1]");
    By firstProductTotalPrice = By.xpath("(//P[@class=\"cart_total_price\"])[1]");
    By secondProductName = By.xpath("//a[@href=\"/product_details/2\"]");
    By secondProductPrice = By.xpath("(//td[@class=\"cart_price\"]/p)[2]");
    By secondProductQuantity = By.xpath("(//td[@class=\"cart_quantity\"]/button)[2]");
    By secondProductTotalPrice = By.xpath("(//P[@class=\"cart_total_price\"])[2]");
    By subscriptionTitle = By.xpath("//div[@class=\"single-widget\"]/h2");
    By footer = By.id("footer");
    By emailField = By.id("susbscribe_email");
    By submitEmailButton = By.id("subscribe");
    By SuccessMessage = By.id("success-subscribe");
    By removeProductBtn = By.xpath("//i[@class=\"fa fa-times\"]");
    By cartIsEmptyTitle = By.xpath("//*[@id=\"empty_cart\"]/p/b");



    public ViewCartPage(Driver driver) {
        this.driver = driver;
    }

    /**********************************  Assertions  ****************************************/

    @Step("Check that View Cart Page is loaded successfully")
    public ViewCartPage checkThatViewCartPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/view_cart"));
        Assert.assertTrue(driver.element().isDisplayed(productsTable));
        return this;
    }

    @Step("Check that product is added")
    public ViewCartPage checkThatProductIsAdded() {
        Assert.assertTrue(driver.element().isDisplayed(addedProductDescription));
        return this;
    }

    @Step("Check that product quantity is right")
    public ViewCartPage checkThatProductQuantityIsRight() {
        Assert.assertTrue(driver.element().isDisplayed(addedProductQuantity));
        return this;
    }

    @Step("Check That First And Second Products Are Added To The Cart Successfully")
    public ViewCartPage checkThatFirstAndSecondProductsAreAddedToTheCartSuccessfully() {
        Assert.assertTrue(driver.element().isDisplayed(firstProductName));
        Assert.assertTrue(driver.element().isDisplayed(secondProductName));
        Assert.assertEquals(driver.element().getTextOf(firstProductName), "Blue Top");
        Assert.assertEquals(driver.element().getTextOf(secondProductName), "Men Tshirt");
        Assert.assertTrue(driver.element().isDisplayed(firstProductPrice));
        Assert.assertTrue(driver.element().isDisplayed(firstProductQuantity));
        Assert.assertTrue(driver.element().isDisplayed(firstProductTotalPrice));
        Assert.assertTrue(driver.element().isDisplayed(secondProductPrice));
        Assert.assertTrue(driver.element().isDisplayed(secondProductQuantity));
        Assert.assertTrue(driver.element().isDisplayed(secondProductTotalPrice));
        return this;
    }


    @Step("Check Subscription Is Visible In Cart Page")
    public ViewCartPage checkSubscriptionIsVisibleInCartPage() {
        driver.element().scrollToElement(footer);
        Assert.assertTrue(driver.element().isDisplayed(subscriptionTitle));
        Assert.assertEquals(driver.element().getTextOf(subscriptionTitle), "SUBSCRIPTION");
        return this;
    }


    @Step("Check That Success Message Is Successfully Displayed")
    public ViewCartPage checkThatSuccessMessageIsSuccessfullyDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(SuccessMessage), "You have been successfully subscribed!");
        return this;
    }

    public ViewCartPage checkThatProductRemovedFromTheCartSuccessfully() {
        Assert.assertEquals(driver.element().getTextOf(cartIsEmptyTitle), "Cart is empty!");
        return this;
    }


    /*********************************  Actions  *****************************************************/

    @Step("Check that user can click on proceed to checkOut for non registered user")
    public ViewCartPage clickOnProceedToCheckOutForNonRegisteredUser() {
        driver.element().click(proceedToCheckOutBtn);
        return this;
    }

    @Step("Check that user can click on proceed to checkOut button for registered user")
    public CheckoutPage clickOnProceedToCheckOutButtonForRegisteredUser() {
        driver.element().click(ptcobtn);
        return new CheckoutPage(driver);
    }

    @Step("Check that user can click on Register Login Button")
    public LoginSignupPage clickOnRegisterLoginBtn() {
        driver.element().click(registerLoginBtn);
        return new LoginSignupPage(driver);
    }

    @Step("Check That User Can Fill Email Field")
    public ViewCartPage fillEmailField(String email) {
        driver.element().fillField(emailField, email);
        return this;
    }

    @Step("Check That User Can Click On Email Arrow Button")
    public ViewCartPage clickOnEmailArrowButton() {
        driver.element().click(submitEmailButton);
        return this;
    }

    public ViewCartPage clickOnremoveProductBtn(){
        driver.element().click(removeProductBtn);
        return this;
    }

}