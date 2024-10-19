package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FirstProductPage {
    private Driver driver;

    By productName = By.xpath("(//h2)[3]");
    By category = By.xpath("(//p)[3]");
    By price = By.xpath("(//span)[13]");
    By availability = By.xpath("(//P)[4]");
    By condition = By.xpath("(//P)[5]");
    By brand = By.xpath("(//P)[6]");
    By quantity = By.xpath("//input[@id=\"quantity\"]");
    By addToCartBtn = By.xpath("//button[@class=\"btn btn-default cart\"]");
    By viewCartBtn = By.xpath("(//a[@href=\"/view_cart\"])[2]");
    By reviewTitle = By.xpath("//a[@href=\"#reviews\"]");
    By reviewerName = By.id("name");
    By reviewerEmail = By.id("email");
    By reviewerReview = By.id("review");
    By reviewerSubmitBtn = By.id("button-review");
    By reviewSuccessMsg = By.xpath("//*[@id=\"review-section\"]/div/div/span");

    public FirstProductPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check that use navigate to First Product Page successfully")
    public FirstProductPage checkThatUseNavigateToFirstProductPageSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/product_details/1"));
        driver.element().isDisplayed(productName);
        driver.element().isDisplayed(category);
        driver.element().isDisplayed(price);
        driver.element().isDisplayed(availability);
        driver.element().isDisplayed(condition);
        driver.element().isDisplayed(brand);
        return this;
    }

    @Step("Check that write your review is visible")
    public FirstProductPage checkThatWriteYourReviewIsVisible() {
        Assert.assertEquals(driver.element().getTextOf(reviewTitle), "WRITE YOUR REVIEW");
        return this;
    }

    @Step("Check that success message for review is visible")
    public FirstProductPage checkThatSuccessMsgForReviewIsVisible() {
        Assert.assertEquals(driver.element().getTextOf(reviewSuccessMsg), "Thank you for your review.");
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that user can increase product quantity")
    public FirstProductPage IncreaseProductQuantity() {
        driver.element().fillField(quantity, "4");
        return this;
    }

    @Step("Check that user can click on Add To Cart button")
    public FirstProductPage ClickOnAddToCartBtn() {
        driver.element().click(addToCartBtn);
        return this;
    }

    @Step("Check that user can click on Reviewer Submit button")
    public FirstProductPage ClickOnReviewerSubmitBtn() {
        driver.element().click(reviewerSubmitBtn);
        return this;
    }

    @Step("Check that user can click on View Cart button")
    public ViewCartPage ClickOnViewCartBtn() {
        driver.element().click(viewCartBtn);
        return new ViewCartPage(driver);
    }

    @Step("Check that user can fill in reviewer name")
    public FirstProductPage fillInReviewerName(String name) {
        driver.element().fillField(reviewerName, name);
        return this;
    }

    @Step("Check that user can fill in reviewer email")
    public FirstProductPage fillInReviewerEmail(String email) {
        driver.element().fillField(reviewerEmail, email);
        return this;
    }

    @Step("Check that user can fill in reviewer review")
    public FirstProductPage fillInReviewerReview(String review) {
        driver.element().fillField(reviewerReview, review);
        return this;
    }

}
