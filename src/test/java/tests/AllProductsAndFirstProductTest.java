package tests;

import driverFactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;


public class AllProductsAndFirstProductTest {

    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().navigateToURL("https://automationexercise.com/");
        driver.browser().maximizeWindows();

    }

    @Test
    public void checkThatUserCanNavigateToFirstProductPageSuccessfully() {
        new HomePage(driver)
                .clickOnProductsLink()
                .checkThatProductsPageIsLoadedSuccessfully()
                .clickOnFirstProduct()
                .checkThatUseNavigateToFirstProductPageSuccessfully();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }

}
