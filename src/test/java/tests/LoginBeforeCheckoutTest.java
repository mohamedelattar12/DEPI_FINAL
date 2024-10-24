package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginBeforeCheckoutTest {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();

    }

    @Test
    public void checkThatUserCanLoginBeforeCheckoutSuccessfully() {
        new HomePage(driver).checkThatHomePageIsLoadedSuccessfully().clickOnLoginLink()
                .fillInLoginEmail("doaa121093@gmail.com").fillInLoginPassword("123456")
                .clickOnLoginButton()
                .checkThatLoggedInAsUsernameIsDisplayed("Doaa")
                .clickOnFirstAddToCartButton()
                .clickOnCartLink()
                .checkThatViewCartPageIsLoadedSuccessfully()
                .clickOnProceedToCheckOutButtonForRegisteredUser()
//                .clickOnProceedToCheckOutButtonForRegisteredUser()
//                .CheckAddressDetailsIsDisplayed()
//                .CheckReviewOrderIsDisplayed()
                .fillInTextArea().clickOnPlaceOrderBtn().fillPaymentForm().
                clickOnPayAndConfirmBtn().checkSuccessMessageIsDisplayed();

    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}