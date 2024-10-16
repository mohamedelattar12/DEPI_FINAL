package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class ViewCartBrandProducts {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void checkThatProductQuantityIsAccurate() {
        new HomePage(driver)
                .clickOnProductsLink()
                .checkThatBrandsAreVisibleOnLeftSideBar()
                .clickOnPoloBrandName()
                .checkThatuserIsNavigatedToPoloBrandPage()
                .clickOnMadameBrandName()
                .checkThatuserIsNavigatedToMadameBrandPage();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }

}
