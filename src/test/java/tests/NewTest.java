package tests;

import driverFactory.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginSignupPage;

import java.time.Duration;


public class NewTest {
    Driver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = new Driver("EDGE");
//        wait=new WebDriverWait(driver.get(),Duration.ofSeconds(30));
        driver.browser().navigateToURL("https://automationexercise.com");
        driver.browser().maximizeWindows();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .checkThatLoginLinkShouldBeDisplayed()
                .clickOnLoginLink()
                .checkThatUserIsNavigateToLoginSignUpPage()
                .fillInNameSingUp("Mariam")
                .fillInEmailSingUpButton("TestTestt123456@gmail.com")
                .clickOnSignUpButton()
                .checkThatRegistrationPageIsLoadedSuccessfully()
                .fillInRegistrationForm()
                .clickOnCreateAccount()
                .checkThatSuccessMessageShouldBeDisplayed();

        driver.browser().deleteAllCookies();
    }

    @Test(priority = 2, dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSuccessfully() {
        driver.browser().navigateToURL("https://automationexercise.com/login");
        new LoginSignupPage(driver)
                .fillInLoginEmail("TestTestt123456@gmail.com")
                .fillInLoginPassword("12345678")
                .clickOnLoginButton()
                .checkThatLogOutLinkShouldBeDisplayed();
        driver.browser().deleteAllCookies();
    }


//    @Test(priority = 3, dependsOnMethods = "userCanLoginSuccessfully")
//    public void userCanLogoutSuccessfully() {
//        new HomePage(driver)
//                .clickOnLogOutLink()
//                .checkThatUserIsNavigateToLoginSignUpPage();
//    }


    @Test(priority = 3, dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanDeleteSuccessfully() {
        driver.browser().navigateToURL("https://automationexercise.com/login");
        new LoginSignupPage(driver)
                .fillInLoginEmail("TestTestt123456@gmail.com")
                .fillInLoginPassword("12345678")
                .clickOnLoginButton()
                .checkThatDeleteLinkShouldBeDisplayed()
                .clickOnDeleteAccountLink()
                .checkThatAccountDeletedSuccessfully()
                .clickOnContinueButton()
                .checkThatHomePageIsLoadedSuccessfully()
                .checkThatLoginLinkShouldBeDisplayed();

    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }


}
