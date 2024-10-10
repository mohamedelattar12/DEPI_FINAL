package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage {
    private Driver driver;

    By productsList = By.xpath("//div[@class=\"features_items\"]");
    By productsTitle = By.xpath("//h2[@class=\"title text-center\"]");
    By firstProductLink = By.xpath("//a[@href=\"/product_details/1\"]");
    By productSearchbar = By.id("search_product");
    By productSearchButton = By.id("submit_search");
    By searchedProductTitle=By.xpath("//h2[@class=\"title text-center\"]");



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
        Assert.assertEquals(driver.element().getTextOf(searchedProductTitle),"SEARCHED PRODUCTS");

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

}
