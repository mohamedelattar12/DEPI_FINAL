package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;


public class VerifySubscriptionInCartPageTest {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().navigateToURL("https://automationexercise.com/");
        driver.browser().maximizeWindows();
    }

    @Test
    public void checkThatUserCanSubscribeFromHomePage(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnCartLink()
                .checkSubscriptionIsVisibleInCartPage()
                .fillEmailField("TestTest333@gmail.com")
                .clickOnEmailArrowButton()
                .checkThatSuccessMessageDisplayedSuccessfully();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
