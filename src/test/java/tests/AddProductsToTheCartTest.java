package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class AddProductsToTheCartTest {
    Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().navigateToURL("https://automationexercise.com/");
        driver.browser().maximizeWindows();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void hoverOnFirstItemAndAddedToCart() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnProductsLink()
                .hoverOnFirstProduct()
                .clickOnFirstProductAddToCartButton()
                .clickOnContinueShoppingButton()
                .hoverOnSecondProduct()
                .clickOnSecondProductAddToCartButton()
                .clickOnViewCartButton()
                .checkThatViewCartPageIsLoadedSuccessfully()
                .checkThatFirstAndSecondProductsAreAddedToTheCartSuccessfully();

    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
