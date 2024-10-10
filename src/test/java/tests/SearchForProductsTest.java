package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchForProductsTest {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com");
    }

    @Test
    public void checkThatUserCanSearchForProduct(){
        new HomePage(driver).checkThatHomePageIsLoadedSuccessfully()
                .clickOnProductsLink()
                .checkThatProductsPageIsLoadedSuccessfully()
                .searchForProduct("Blue Top")
                .clickOnSearchButton()
                .checkThatSearchedProductIsLoadedSuccessfully();

    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();


    }
}