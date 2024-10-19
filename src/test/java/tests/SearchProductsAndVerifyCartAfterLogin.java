package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class SearchProductsAndVerifyCartAfterLogin {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void checkThatProductQuantityIsAccurate() throws InterruptedException {
        new HomePage(driver)
                .clickOnProductsLink()
                .checkThatProductsPageIsLoadedSuccessfully()
                .clickOnSearchBar()
                .searchForProduct("women")
                .clickOnSearchButton()
                .checkThatAllTheProductsRelatedToSearchAreVisible("women")
                .addAllProductsInThePageToCart()
                .clickOnCartButton()
                .checkThatProductsAreVisibleInCart("women")
                .clickOnLoginLink()
                .fillInLoginEmail("moha@g.com")
                .fillInLoginPassword("12345678")
                .clickOnLoginButton()
                .clickOnCartButton()
                .checkThatProductsAreVisibleInCart("women");
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
