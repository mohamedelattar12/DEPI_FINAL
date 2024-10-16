package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class RegisterWithExistEmailTest {
    public Driver driver;
    double num = Math.random();


    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    @Test
    public void userCannotLoggInWithInCorrectEmailAndPassword() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnLoginLink()
                .checkThatUserIsNavigateToLoginSignUpPage()
                .fillInNameSingUpField("Mariam")
                .fillInEmailSingUpField("TestTest12345@gmail.com")
                .clickOnSignUpButtonUsingExistEmail()
                .checkThatErrorMessageIsVisibleWhenUseExistEmail();

    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
