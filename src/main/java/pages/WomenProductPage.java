package pages;

import driverFactory.Driver;
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


    public WomenProductPage checkThatCategoryPageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/category_products/2"));
        Assert.assertTrue(driver.element().isDisplayed(topsProductsTitle));
        return this;
    }

    public WomenProductPage checkThatUserIsNavigatedToMenProductsPageSuccessfully(){
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/category_products/6"));
        return this;
    }


    /*********************************  Actions  *****************************************************/

    public WomenProductPage clickOnMenCategory() {
        driver.element().click(menCategory);
        return this;
    }

    public WomenProductPage clickOnjeansMenCategory(){
        driver.element().click(jeansMenCategory);
        return this;
    }


}
