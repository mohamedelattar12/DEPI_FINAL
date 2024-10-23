package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class RegisterWhileCheckoutTest {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void checkThatProductQuantityIsAccurate(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully().clickOnFirstAddToCartButton().
                clickOnViewCartButton().checkThatViewCartPageIsLoadedSuccessfully().
                clickOnProceedToCheckOutForNonRegisteredUser().clickOnRegisterLoginBtn().fillInNameSingUpField("esraa")
                .fillInEmailSingUpField("esraf123@gmail.com").clickOnSignUpButton().fillInRegistrationForm()
                .clickOnCreateAccount().checkThatSuccessMessageShouldBeDisplayed().
                clickOnContinueBtn().checkThatLoggedInAsUsernameIsDisplayed("esraa").clickOnCartLink()
                .clickOnProceedToCheckOutButtonForRegisteredUser().checkAddressDetailsIsDisplayed().checkReviewOrderIsDisplayed()
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

