package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage {
    private Driver driver;

    By productsList = By.xpath("//div[@class=\"features_items\"]");
    By productsTitle=By.xpath("//h2[@class=\"title text-center\"]");
    By firstProductLink=By.xpath("//a[@href=\"/product_details/1\"]");


    public ProductsPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/
    public ProductsPage checkThatProductsPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/products"));
        Assert.assertTrue(driver.element().isDisplayed(productsTitle));
        Assert.assertEquals(driver.element().getTextOf(productsTitle),"ALL PRODUCTS");

        return this;
    }


    /*********************************  Actions  *****************************************************/

    public FirstProductPage clickOnFirstProduct(){
        driver.element().click(firstProductLink);
        return new FirstProductPage(driver);
    }

}
