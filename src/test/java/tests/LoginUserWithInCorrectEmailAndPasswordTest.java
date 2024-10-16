package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class LoginUserWithInCorrectEmailAndPasswordTest {
    public Driver driver;


    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }



    @Test
    public void userCanLoggInWithInCorrectEmailAndPassword() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnLoginLink()
                .checkThatUserIsNavigateToLoginSignUpPage()
                .checkThatLoginToYourAccountIsVisible()
                .fillInLoginEmail("TestTest123@gmail.com")
                .fillInLoginPassword("12345678").
                clickOnLoginButtonUsingIncorrectData().
                checkThatErrorMessageIsVisibleWhenUseInCorrectEmailToLogin();

    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
