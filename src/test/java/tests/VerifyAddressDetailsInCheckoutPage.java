package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class VerifyAddressDetailsInCheckoutPage {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void verifyAddressDetails() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnLoginSignupBtn()
                .checkThatUserIsNavigateToLoginSignUpPage()
                .fillInNameSingUpField("Ahmed")
                .fillInEmailSingUpField("TestTest123456788@gmail.com")
                .clickOnSignUpButton()
                .checkThatRegistrationPageIsLoadedSuccessfully()
                .fillInRegistrationForm()
                .clickOnCreateAccount()
                .checkThatSuccessMessageShouldBeDisplayed()
                .clickOnContinueBtn()
                .checkThatLoggedInAsUsernameIsDisplayed("Ahmed")
                .clickOnFirstAddToCartButton()
                .clickOnCartLink()
                .checkThatViewCartPageIsLoadedSuccessfully()
                .clickOnProceedToCheckOutButtonForRegisteredUser()
                .checkAddressDetailsIsDisplayed()
                .checkReviewOrderIsDisplayed()
                .fillInTextArea()
                .clickOnPlaceOrderBtn()
                .fillPaymentForm()
                .clickOnPayAndConfirmBtn()
                .checkSuccessMessageIsDisplayed()
                .clickOnDeleteAccountBtn()
                .checkThatAccountDeletedSuccessfully()
                .clickOnContinueButton();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();

    }
}
