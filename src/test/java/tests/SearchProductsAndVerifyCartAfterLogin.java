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
        driver = new Driver("CHROME");
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void checkThatProductQuantityIsAccurate(){
        new HomePage(driver)
                .clickOnProductsLink()
                .checkThatProductsPageIsLoadedSuccessfully()
                .clickOnSearchBar()
                .searchForProduct("Men")
                .clickOnSearchButton()
                .checkThatAllTheProductsRelatedToSearchAreVisible("Men")
                .addAllProductsInThePageToCart();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
