package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class RegisterBeforeCheckout {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com");
    }

    @Test
    public void checkThatProductQuantityIsAccurate(){
       new HomePage(driver).checkThatHomePageIsLoadedSuccessfully().clickOnLoginSignupBtn()
               .fillInNameSingUp("esraa").fillInEmailSingUpFiled("esraaf1234@gmail.com")
               .clickOnSignUpButton().checkThatRegistrationPageIsLoadedSuccessfully()
               .fillInRegistrationForm().clickOnCreateAccount().checkThatSuccessMessageShouldBeDisplayed()
               .clickOnContinueBtn().checkThatLoggedInAsUsernameIsDisplayed("esraa").clickOnFirstAddToCartButton()
               .clickOnCartLink().checkThatViewCartPageIsLoadedSuccessfully()
               .clickonproceedtocheckoutbtn().CheckAddressDetailsIsDisplayed().CheckReviewOrderIsDisplayed()
               .fillInTextArea().clickOnPlaceOrderBtn().fillPaymentForm().
               clickOnPayAndConfirmBtn().checkSuccessMessageIsDisplayed().clickOnDeleteAccountBtn()
               .checkThatAccountDeletedSuccessfully().clickOnContinueButton();





    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();


    }
}


