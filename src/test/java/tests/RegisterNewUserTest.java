package tests;

import driverFactory.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;


public class RegisterNewUserTest {
   public Driver driver;
    WebDriverWait wait;


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
                .clickOnContinueBtn()
                .checkThatLoggedInAsUsernameIsDisplayed("Mariam")
                .clickOnDeleteAccountLink()
                .checkThatAccountDeletedSuccessfully()
                .clickOnContinueButton();

        driver.browser().deleteAllCookies();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }


}
