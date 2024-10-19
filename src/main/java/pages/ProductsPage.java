package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

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
    By viewProduct = By.xpath("//a[@href=\"/product_details/1\"]");
    By brands = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-3 > div > div.brands_products > h2");
    By poloBrandName = By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-3 > div > div.brands_products > div > ul > li:nth-child(1) > a");
    By poloBrandTitle = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
    By madameBrandName = By.cssSelector("body > section > div > div.row > div.col-sm-3 > div > div.brands_products > div > ul > li:nth-child(3) > a");
    By madameBrandTitle = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");

    public ProductsPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/
    public ProductsPage checkThatAllTheProductsRelatedToSearchAreVisible(String searchedProduct) {
        // Find multiple elements using a class name
        List<WebElement> elements = driver.get().findElements(By.className("productinfo"));
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertTrue(elements.get(i).getText().toLowerCase().contains(searchedProduct.toLowerCase()));
        }
        return this;
    }

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

    public ProductsPage checkThatBrandsAreVisibleOnLeftSideBar() {
        Assert.assertTrue(driver.element().getTextOf(brands).contains("BRANDS"));
        return this;
    }

    public ProductsPage checkThatuserIsNavigatedToPoloBrandPage() {
        Assert.assertTrue(driver.element().getTextOf(poloBrandTitle).contains("POLO PRODUCTS"));
        Assert.assertTrue(driver.browser().getCurrentURL().contains("brand_products/Polo"));
        return this;
    }

    public ProductsPage checkThatuserIsNavigatedToMadameBrandPage() {
        Assert.assertTrue(driver.element().getTextOf(madameBrandTitle).contains("MADAME PRODUCTS"));
        Assert.assertTrue(driver.browser().getCurrentURL().contains("brand_products/Madame"));
        return this;
    }

    /*********************************  Actions  *****************************************************/
    public ProductsPage addAllProductsInThePageToCart() {
        // Find multiple elements using a class name
        List<WebElement> elements = driver.get().findElements(By.className("add-to-cart"));
        for (int i = 0; i < elements.size(); i = i + 2) {
            System.out.println(i);
            System.out.println(elements.get(i).getText());
            elements.get(i).click();
            driver.element().click(continueShoppingButton);
        }
        return this;
    }

    public ProductsPage clickOnSearchBar() {
        driver.element().click(productSearchbar);
        return this;
    }

    public FirstProductPage clickOnFirstProduct() {
        driver.element().click(firstProductLink);
        return new FirstProductPage(driver);
    }

    public ProductsPage clickOnPoloBrandName() {
        driver.element().click(poloBrandName);
        return this;
    }

    public ProductsPage clickOnMadameBrandName() {
        driver.element().click(madameBrandName);
        return this;
    }

    public ProductsPage searchForProduct(String X) {
        driver.element().searchBar(productSearchbar, X);
        return this;
    }

    public ProductsPage clickOnSearchButton() {
        driver.element().click(productSearchButton);
        return this;
    }

    @Step("Check That User Can Hover On First Product")
    public ProductsPage hoverOnFirstProduct() {
        driver.element().hoverOnItem(hoverOnFirstProductLink);
        return this;
    }

    @Step("Check That User Can Hover On Second Product")
    public ProductsPage hoverOnSecondProduct() {
        driver.element().hoverOnItem(hoverOnSecondProductLink);
        return this;
    }

    @Step("Check That User Can Click On First Product Add To Cart Button")
    public ProductsPage clickOnFirstProductAddToCartButton() {
        driver.element().click(clickOnFirstProductAddToCartButton);
        return this;
    }

    @Step("Check That User Can Click On Continue Shopping Button")
    public ProductsPage clickOnContinueShoppingButton() {
        driver.element().click(continueShoppingButton);
        return this;
    }

    @Step("Check That User Can Click On Second Product Add To Cart Button")
    public ProductsPage clickOnSecondProductAddToCartButton() {
        driver.element().click(clickOnSecondProductAddToCartButton);
        return this;
    }

    @Step("Check That User Can Click On View Cart Button")
    public ViewCartPage clickOnViewCartButton() {
        driver.element().click(viewCart);
        return new ViewCartPage(driver);
    }

    public FirstProductPage clickOnViewProductButton() {
        driver.element().click(viewProduct);
        return new FirstProductPage(driver);
    }


}


