package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class WomenProductPage {

    Driver driver;

    By topsProductsTitle = By.cssSelector("span.google-anno-t");
    By jeansMenCategory = By.xpath("//*[@id=\"Men\"]/div/ul/li[2]/a");
    By menCategory = By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a");


    public WomenProductPage(Driver driver) {
        this.driver = driver;
    }

    /**********************************  Assertions  ****************************************/

    @Step("Check that Category page is loaded successfully")
    public WomenProductPage checkThatCategoryPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/category_products/2"));
        Assert.assertTrue(driver.element().isDisplayed(topsProductsTitle));
        return this;
    }

    @Step("Check that user is navigated to Men Products page successfully")
    public WomenProductPage checkThatUserIsNavigatedToMenProductsPageSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/category_products/6"));
        return this;
    }


    /*********************************  Actions  *****************************************************/
    @Step("Check that user can click on Men category")
    public WomenProductPage clickOnMenCategory() {
        driver.element().click(menCategory);
        return this;
    }

    @Step("Check that user can click on Jeans Men category")
    public WomenProductPage clickOnJeansMenCategory() {
        driver.element().click(jeansMenCategory);
        return this;
    }


}
