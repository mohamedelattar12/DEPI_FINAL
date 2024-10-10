package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

public class ProductsPage {
    private Driver driver;


    By productsTitle = By.xpath("//h2[@class=\"title text-center\"]");
    By firstProductLink = By.xpath("//a[@href=\"/product_details/1\"]");
    By productSearchbar = By.id("search_product");
    By productSearchButton = By.id("submit_search");
    By searchedProductTitle = By.xpath("//h2[@class=\"title text-center\"]");
    By hoverOnFirstProductLink = By.xpath("(//div[@class=\"overlay-content\"])[1]");
    By clickOnFirstProductAddToCartButton = By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]");
    By continueShoppingButton = By.xpath("//button[@data-dismiss=\"modal\"]");
    By hoverOnSecondProductLink = By.xpath("(//div[@class=\"overlay-content\"])[2]");
    By clickOnSecondProductAddToCartButton = By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[3]");
    By viewCart = By.xpath("(//a[@href=\"/view_cart\"])[2]");





    public ProductsPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/
    public ProductsPage checkThatProductsPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/products"));
        Assert.assertTrue(driver.element().isDisplayed(productsTitle));
        Assert.assertEquals(driver.element().getTextOf(productsTitle), "ALL PRODUCTS");

        return this;
    }

    public ProductsPage checkThatSearchedProductIsLoadedSuccessfully() {
        Assert.assertTrue(driver.element().isDisplayed(searchedProductTitle));
        Assert.assertEquals(driver.element().getTextOf(searchedProductTitle), "SEARCHED PRODUCTS");
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/products?search="));

        return this;
    }



    /*********************************  Actions  *****************************************************/

    public FirstProductPage clickOnFirstProduct() {
        driver.element().click(firstProductLink);
        return new FirstProductPage(driver);
    }

    public ProductsPage searchForProduct(String X) {
        driver.element().searchBar(productSearchbar, X);
        return this;
    }

    public ProductsPage clickOnSearchButton() {
        driver.element().click(productSearchButton);
        return this;
    }

    public ProductsPage hoverOnFirstProduct() {
        driver.element().hoverOnItem(hoverOnFirstProductLink);
        return this;
    }

    public ProductsPage hoverOnSecondProduct() {
        driver.element().hoverOnItem(hoverOnSecondProductLink);
        return this;
    }

    public ProductsPage clickOnFirstAddToCartButton() {
        driver.element().click(clickOnFirstProductAddToCartButton);
        return this;
    }

    public ProductsPage clickOnContinueShoppingButton() {
        driver.element().click(continueShoppingButton);
        return this;
    }

    public ProductsPage clickOnSecondProductAddToCartButton() {
        driver.element().click(clickOnSecondProductAddToCartButton);
        return this;
    }

    public ViewCartPage clickOnViewCartButton() {
        driver.element().click(viewCart);
        return new ViewCartPage(driver);
    }
}
