package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class RegisterWithExistEmailTest {
    public Driver driver;
    double num = Math.random();


    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().navigateToURL("https://automationexercise.com");
        driver.browser().maximizeWindows();
    }


    @Test
    public void userCannotLoggInWithInCorrectEmailAndPassword() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnLoginLink()
                .checkThatLoginToSignIsVisible()
                .fillInNameSingUp("Mariam")
                .fillInEmailSingUpFiled("TestTest12345@gmail.com")
                .clickOnSignUpButtonUsingExistEmail()
                .checkThatErrorMessageIsVisibleWhenUseExistEmail();

    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
