package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class VerifySubscriptionInHomePageTest {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void checkThatUserCanSubscribeFromHomePage() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .checkThatSubscriptionIsVisible()
                .fillEmailField("Test1Test333@gmail.com")
                .clickOnEmailSubscriptionButton()
                .checkThatSuccessMessageDisplayedSuccessfully();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();


    }

}
