package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PaymentPage;
import pages.PaymentSuccessPage;

import java.time.Duration;

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
                clickOnProceedToCheckOut().clickOnRegisterLoginBtn().fillInNameSingUp("esraa")
                .fillInEmailSingUpButton("esraf123@gmail.com").clickOnSignUpButton().fillInRegistrationForm()
                .clickOnCreateAccount().checkThatSuccessMessageShouldBeDisplayed().
                clickOnContinueBtn().checkThatLoggedInAsUsernameIsDisplayed().clickOnCartBtn()
                .clickonproceedtocheckoutbtn().CheckAddressDetailsIsDisplayed().CheckReviewOrderIsDisplayed()
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
