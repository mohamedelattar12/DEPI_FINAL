package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ViewCartPage {

    Driver driver;

    By productsTable=By.xpath("//div[@id=\"cart_info\"]");

    public ViewCartPage(Driver driver) {
        this.driver = driver;
    }

    /**********************************  Assertions  ****************************************/

    public ViewCartPage checkThatViewCartPageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/view_cart"));
        Assert.assertTrue(driver.element().isDisplayed(productsTable));
        return this;
    }

}