package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class VerifySubscriptionInHomePageTest {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com");
    }

    @Test
    public void checkThatUserCanSearchForProduct(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .checkThatSubscriptionIsvIsVisible()
                .fillEmailField("Test1Test333@gmail.com")
                .clickOnEmailSubscriptionButton()
                .checkThatSuccessMessageDisplayedSuccessfully();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
       // driver.quit();


    }

}
