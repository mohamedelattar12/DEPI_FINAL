package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage {

    private Driver driver;


    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");
    By testCaseLink = By.xpath("(//a[@href=\"/test_cases\"])[1]");
    By productsLink = By.xpath("//a[@href=\"/products\"]");
    By hoverLink = By.xpath("(//div[@class=\"overlay-content\"])[1]");
    By clickAddToCartButton = By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]");
    By viewCart = By.xpath("(//a[@href=\"/view_cart\"])[2]");
    By subscriptionTitle = By.xpath("//div[@class=\"single-widget\"]/h2");
    By emailField = By.id("susbscribe_email");
    By submitEmailButton = By.id("subscribe");
    By SuccessMessage = By.id("success-subscribe");
    By footer = By.id("footer");

    public HomePage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    public HomePage checkThatLogOutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        return this;
    }

    public HomePage checkThatDeleteLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));
        return this;
    }

    public HomePage checkThatLoginLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(loginLink));
        return this;
    }

    public HomePage checkThatHomePageIsLoadedSuccessfully() {
        Assert.assertEquals(driver.browser().getCurrentURL(), "https://automationexercise.com/");
        return this;
    }

    public HomePage checkThatSubscriptionIsvIsVisible() {
        driver.element().scrollToElement(footer);
        Assert.assertTrue(driver.element().isDisplayed(subscriptionTitle));
        return this;
    }

    public HomePage checkThatSuccessMessageDisplayedSuccessfully() {
        Assert.assertEquals(driver.element().getTextOf(SuccessMessage), "You have been successfully subscribed!");
        return this;
    }

    /*********************************  Actions  *****************************************************/

    public LoginSignupPage clickOnLoginLink() {
        driver.element().click(loginLink);
        return new LoginSignupPage(driver);
    }

    public LoginSignupPage clickOnLogOutLink() {
        driver.element().click(logoutLink);
        return new LoginSignupPage(driver);
    }

    public AccountSuccessfulDeletion clickOnDeleteAccountLink() {
        driver.element().click(deleteAccountLink);
        return new AccountSuccessfulDeletion(driver);
    }

    public ContactUsPage clickOnContactUsLink() {
        driver.element().click(contactUsLink);
        return new ContactUsPage(driver);
    }

    public TestCasePage clickOnTestCaseLink() {
        driver.element().click(testCaseLink);
        return new TestCasePage(driver);
    }

    public ProductsPage clickOnProductsLink() {
        driver.element().click(productsLink);
        return new ProductsPage(driver);
    }

    public HomePage hoverOnFirstItem() {
        driver.element().hoverOnItem(hoverLink);
        return this;
    }

    public HomePage clickOnFirstAddToCartButton() {
        driver.element().click(clickAddToCartButton);
        return this;
    }

    public ViewCartPage clickOnViewCartButton() {
        driver.element().click(viewCart);
        return new ViewCartPage(driver);
    }

    public HomePage fillEmailField(String email) {
        driver.element().fillField(emailField, email);
        return this;
    }

    public HomePage clickOnEmailSubscriptionButton() {
        driver.element().click(submitEmailButton);
        return this;
    }
}
