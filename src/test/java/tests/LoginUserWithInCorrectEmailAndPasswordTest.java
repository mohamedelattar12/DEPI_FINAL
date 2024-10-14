package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginUserWithInCorrectEmailAndPasswordTest {
    public Driver driver;


    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().navigateToURL("https://automationexercise.com");
        driver.browser().maximizeWindows();
    }



    @Test
    public void userCanLoggInWithInCorrectEmailAndPassword() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnLoginLink()
                .checkThatUserIsNavigateToLoginSignUpPage()
                .checkThatLoginToSignIsVisible()
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
