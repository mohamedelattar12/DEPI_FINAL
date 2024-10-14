package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class RegisterWhileCheckout {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com");
    }

    @Test
    public void checkThatProductQuantityIsAccurate(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully().clickOnFirstAddToCartButton().
                clickOnViewCartButton().checkThatViewCartPageIsLoadedSuccessfully().
                clickOnProceedToCheckOutForNonRegisteredUser().clickOnRegisterLoginBtn().fillInNameSingUp("esraa")
                .fillInEmailSingUpField("esraf123@gmail.com").clickOnSignUpButton().fillInRegistrationForm()
                .clickOnCreateAccount().checkThatSuccessMessageShouldBeDisplayed().
                clickOnContinueBtn().checkThatLoggedInAsUsernameIsDisplayed("esraa").clickOnCartLink()
                .clickOnProceedToCheckOutButtonForRegisteredUser().CheckAddressDetailsIsDisplayed().CheckReviewOrderIsDisplayed()
                .fillInTextArea().clickOnPlaceOrderBtn().fillPaymentForm().clickOnPayAndConfirmBtn().
                checkSuccessMessageIsDisplayed().clickOnDeleteAccountBtn().
                checkThatAccountDeletedSuccessfully().clickOnContinueButton();




    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
       driver.quit();


    }
}

