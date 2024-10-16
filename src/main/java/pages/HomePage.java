package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
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
    By hoverOnFirstProductLink = By.xpath("(//div[@class=\"overlay-content\"])[1]");
    By clickOnFirstProductAddToCartButton = By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]");
    By viewCart = By.xpath("(//a[@href=\"/view_cart\"])[2]");
    By subscriptionTitle = By.xpath("//div[@class=\"single-widget\"]/h2");
    By emailField = By.id("susbscribe_email");
    By submitEmailButton = By.id("subscribe");
    By SuccessMessage = By.id("success-subscribe");
    By footer = By.id("footer");
    By viewProduct = By.xpath("//a[@href=\"/product_details/1\"]");
    By loggedInAsUser = By.xpath("//b");
    By cartLink = By.xpath("(//a[@href=\"/view_cart\"])[1]");
    By signupLoginBtn = By.xpath("//a[@href=\"/login\"]");
    By continueShopping = By.cssSelector("button.close-modal");
    By scrollUpArrow = By.xpath("//a[@href=\"#top\"]");
    By fullFledgedText = By.xpath("(//div[@class=\"col-sm-6\"])[3]/h2");
    By recommendedItemsTitle = By.xpath("//div[@class=\"recommended_items\"]/h2");
    By AddToCartBtnInRecommendedItems = By.cssSelector("#recommended-item-carousel > div > div.item.active > div:nth-child(2) > div > div > div > a");
    By ViewCartBtnInRecommendedItems = By.xpath("//a[@href=\"/view_cart\"]/u");


    public HomePage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check that Logout link should be displayed")
    public HomePage checkThatLogOutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        return this;
    }

    @Step("Check that Login Delete link should be displayed")
    public HomePage checkThatDeleteLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));
        return this;
    }

    @Step("Check that Login link should be displayed")
    public HomePage checkThatLoginLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(loginLink));
        return this;
    }

    @Step("Check that Home Page is loaded successfully")
    public HomePage checkThatHomePageIsLoadedSuccessfully() {
        Assert.assertEquals(driver.browser().getCurrentURL(), "https://automationexercise.com/");
        return this;
    }

    @Step("check that subscription is visible")
    public HomePage checkThatSubscriptionIsVisible() {
        driver.element().scrollToElement(footer);
        Assert.assertTrue(driver.element().isDisplayed(subscriptionTitle));
        return this;
    }


    @Step("Check that success message is displayed successfully")
    public HomePage checkThatSuccessMessageDisplayedSuccessfully() {
        Assert.assertEquals(driver.element().getTextOf(SuccessMessage), "You have been successfully subscribed!");
        return this;
    }

    @Step("Check that logged in as username is displayed")
    public HomePage checkThatLoggedInAsUsernameIsDisplayed(String userName) {
        Assert.assertTrue(driver.element().isDisplayed(loggedInAsUser));
        return this;
    }

    @Step("check that the page is scrolled up successfully")
    public HomePage checkThatThePageIsScrolledUpSuccessfully(){
        Assert.assertTrue(driver.element().isDisplayed(fullFledgedText));
        return this;
    }

    @Step("check that recommended items title is displayed")
    public HomePage checkThatRecommendedItemsTitleIsDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(recommendedItemsTitle), "RECOMMENDED ITEMS");
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that user can click on login link")
    public LoginSignupPage clickOnLoginLink() {
        driver.element().click(loginLink);
        return new LoginSignupPage(driver);
    }

    @Step("Check that user can click on logout link")
    public LoginSignupPage clickOnLogOutLink() {
        driver.element().click(logoutLink);
        return new LoginSignupPage(driver);
    }

    @Step("Check that user can click on Delete Account link")
    public AccountSuccessfulDeletion clickOnDeleteAccountLink() {
        driver.element().click(deleteAccountLink);
        return new AccountSuccessfulDeletion(driver);
    }

    @Step("Check that user can click on ContactUs link")
    public ContactUsPage clickOnContactUsLink() {
        driver.element().click(contactUsLink);
        return new ContactUsPage(driver);
    }

    @Step("Check that user can click on Test Case link")
    public TestCasePage clickOnTestCaseLink() {
        driver.element().click(testCaseLink);
        return new TestCasePage(driver);
    }

    @Step("Check that user can click on Products link")
    public ProductsPage clickOnProductsLink() {
        driver.element().click(productsLink);
        return new ProductsPage(driver);
    }

    @Step("Check that user can hover On first item")
    public HomePage hoverOnFirstItem() {
        driver.element().hoverOnItem(hoverOnFirstProductLink);
        return this;
    }

    @Step("Check that user can click On first add to Cart button")
    public HomePage clickOnFirstAddToCartButton() {
        driver.element().click(clickOnFirstProductAddToCartButton);
        return this;
    }

    @Step("Check that user can click On View Cart button")
    public ViewCartPage clickOnViewCartButton() {
        driver.element().click(viewCart);
        return new ViewCartPage(driver);
    }

    @Step("Check that user can fill Email field")
    public HomePage fillEmailField(String email) {
        driver.element().fillField(emailField, email);
        return this;
    }

    @Step("Check that user can click on email subscription button")
    public HomePage clickOnEmailSubscriptionButton() {
        driver.element().click(submitEmailButton);
        return this;
    }

    @Step("Check that user can click on view product button")
    public FirstProductPage clickOnViewProductButton() {
        driver.element().click(viewProduct);
        return new FirstProductPage(driver);
    }

    @Step("Check that user can click on Cart Link")
    public ViewCartPage clickOnCartLink() {
        driver.element().click(cartLink);
        return new ViewCartPage(driver);
    }
    @Step("Check that user can click on login signup button")
    public LoginSignupPage clickOnLoginSignupBtn() {
        driver.element().click(signupLoginBtn);
        return new LoginSignupPage(driver);
    }

    @Step("Check that user can click on continue shopping button")
    public HomePage clickOnContinueShoppingButton(){
        driver.element().click(continueShopping);
        return this;
    }

    @Step("Check that user can scroll down to bottom")
    public HomePage scrollDownToBottom(){
        driver.browser().scrollToBottom();
        return this;
    }
    @Step("Check that user can scroll up to top without arrow")
    public HomePage scrollUpToTopWithoutArrow(){
        driver.browser().scrollToTop();
        return this;
    }

    @Step("Check that user can scroll up to top with arrow")
    public HomePage scrollUpToTopWithArrow(){
        driver.element().click(scrollUpArrow);
        return this;
    }

    @Step("Check that user can click on add to Cart button in recommended items")
    public HomePage clickOnAddToCartBtnInRecommendedItems(){
        driver.element().click(AddToCartBtnInRecommendedItems);
        return this;
    }

    @Step("Check that user can click on view Cart button in recommended items")
    public ViewCartPage clickOnViewCartBtnInRecommendedItems(){
        driver.element().click(ViewCartBtnInRecommendedItems);
        return new ViewCartPage(driver);
    }
}
