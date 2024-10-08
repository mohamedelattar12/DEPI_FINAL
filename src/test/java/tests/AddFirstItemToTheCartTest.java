package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ViewCartPage;

import java.time.Duration;

public class AddFirstItemToTheCartTest {
    Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().navigateToURL("https://automationexercise.com/");
        driver.browser().maximizeWindows();
        driver.browser().scrollToBottom();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void hoverOnFirstItemAndAddedToCart() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .hoverOnFirstItem()
                .clickOnFirstAddToCartButton()
                .clickOnViewCartButton();
    }

    @Test(dependsOnMethods = "hoverOnFirstItemAndAddedToCart", priority = 2)
    public void userCanViewCartSuccessfully() {
        new ViewCartPage(driver)
                .checkThatViewCartPageIsLoadedSuccessfully();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
