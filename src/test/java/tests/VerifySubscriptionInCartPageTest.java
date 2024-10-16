package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;


public class VerifySubscriptionInCartPageTest {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void checkThatUserCanSubscribeFromCartPage(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnCartLink()
                .checkSubscriptionIsVisibleInCartPage()
                .fillEmailField("TestTest333@gmail.com")
                .clickOnEmailArrowButton()
                .checkThatSuccessMessageIsSuccessfullyDisplayed();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
