package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    By addToCartBtn= By.xpath("//button[@class=\"btn btn-default cart\"]");
    By viewCartBtn= By.xpath("(//a[@href=\"/view_cart\"])[2]");

    public FirstProductPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/
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
    /*********************************  Actions  *****************************************************/

    public FirstProductPage IncreaseProductQuantity() {
        driver.element().fillField(quantity, "4");
        return this;
    }
    public FirstProductPage ClickOnAddToCartbtn() {
        driver.element().click(addToCartBtn);
        return this;
    }
    public ViewCartPage ClickOnViewCartBtn() {
        driver.element().click(viewCartBtn);
        return new ViewCartPage(driver);
    }

}
