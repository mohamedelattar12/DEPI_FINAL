package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class LoginUserWithCorrectEmailAndPasswordTest {

    public Driver driver;


    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .checkThatLoginLinkShouldBeDisplayed()
                .clickOnLoginLink()
                .checkThatUserIsNavigateToLoginSignUpPage()
                .fillInNameSingUpField("Mariam")
                .fillInEmailSingUpField("TestTest123456@gmail.com")
                .clickOnSignUpButton()
                .checkThatRegistrationPageIsLoadedSuccessfully()
                .fillInRegistrationForm()
                .clickOnCreateAccount()
                .checkThatSuccessMessageShouldBeDisplayed()
                .clickOnContinueBtn();
        driver.browser().deleteAllCookies();
    }

    @Test(priority = 2, dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoggInWithCorrectEmailAndPassword() {
        driver.browser().navigateToURL("https://automationexercise.com");
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnLoginLink()
                .checkThatUserIsNavigateToLoginSignUpPage()
                .checkThatLoginToYourAccountIsVisible()
                .fillInLoginEmail("TestTest123456@gmail.com")
                .fillInLoginPassword("12345678")
                .clickOnLoginButton()
                .checkThatLoggedInAsUsernameIsDisplayed("Mariam")
                .clickOnDeleteAccountLink()
                .checkThatAccountDeletedSuccessfully();

    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
