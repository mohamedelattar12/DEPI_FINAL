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
    By continueShoppingButtonCss = By.cssSelector("#cartModal > div > div > div.modal-footer > button");
    By cart = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");

    public ProductsPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check that all the products related to search are visible")
    public ProductsPage checkThatAllTheProductsRelatedToSearchAreVisible(String searchedProduct) {
        // Find multiple elements using a class name
        List<WebElement> elements = driver.get().findElements(By.className("productinfo"));
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertTrue(elements.get(i).getText().toLowerCase().contains(searchedProduct.toLowerCase()));
        }
        return this;
    }

    @Step("Check that Products Page is loaded successfully")
    public ProductsPage checkThatProductsPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/products"));
        Assert.assertTrue(driver.element().isDisplayed(productsTitle));
        Assert.assertEquals(driver.element().getTextOf(productsTitle), "ALL PRODUCTS");

        return this;
    }

    @Step("Check that searched product is loaded successfully")
    public ProductsPage checkThatSearchedProductIsLoadedSuccessfully() {
        Assert.assertTrue(driver.element().isDisplayed(searchedProductTitle));
        Assert.assertEquals(driver.element().getTextOf(searchedProductTitle), "SEARCHED PRODUCTS");
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/products?search="));
        return this;
    }


    @Step("check that brands are visible on left Side bar")
    public ProductsPage checkThatBrandsAreVisibleOnLeftSideBar() {
        Assert.assertTrue(driver.element().getTextOf(brands).contains("BRANDS"));
        return this;
    }

    @Step("Check that user is navigated to Polo brand page")
    public ProductsPage checkThatuserIsNavigatedToPoloBrandPage() {
        Assert.assertTrue(driver.element().getTextOf(poloBrandTitle).contains("POLO PRODUCTS"));
        Assert.assertTrue(driver.browser().getCurrentURL().contains("brand_products/Polo"));
        return this;
    }


    @Step("Check that user is navigated to Madame brand page")
    public ProductsPage checkThatuserIsNavigatedToMadameBrandPage() {
        Assert.assertTrue(driver.element().getTextOf(madameBrandTitle).contains("MADAME PRODUCTS"));
        Assert.assertTrue(driver.browser().getCurrentURL().contains("brand_products/Madame"));
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that user can click on Cart button")
    public ViewCartPage clickOnCartButton() {
        driver.element().click(cart);
        return new ViewCartPage(driver);
    }

    @Step("Check that user can add all products in the page to Cart")
    public ProductsPage addAllProductsInThePageToCart() throws InterruptedException {
        // Find multiple elements using a class name
        List<WebElement> elements = driver.get().findElements(By.className("add-to-cart"));
        for (int i = 0; i < elements.size(); i = i + 2) {
            elements.get(i).click();
            driver.element().click(continueShoppingButtonCss);
        }
        return this;
    }

    @Step("Check that user can click on search bar")
    public ProductsPage clickOnSearchBar() {
        driver.element().click(productSearchbar);
        return this;
    }

    @Step("Check that the user can click on first product Link")
    public FirstProductPage clickOnFirstProduct() {
        driver.element().click(firstProductLink);
        return new FirstProductPage(driver);
    }

    @Step("Check that the user can click on Polo brand name")
    public ProductsPage clickOnPoloBrandName() {
        driver.element().click(poloBrandName);
        return this;
    }

    @Step("Check that user can click on Madam brand name")
    public ProductsPage clickOnMadameBrandName() {
        driver.element().click(madameBrandName);
        return this;
    }

    @Step("Check that user can Search for product")
    public ProductsPage searchForProduct(String X) {
        driver.element().searchBar(productSearchbar, X);
        return this;
    }

    @Step("Check that user can click on Search button")
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

    @Step("Check user can click on View Product button")
    public FirstProductPage clickOnViewProductButton() {
        driver.element().click(viewProduct);
        return new FirstProductPage(driver);
    }


}


