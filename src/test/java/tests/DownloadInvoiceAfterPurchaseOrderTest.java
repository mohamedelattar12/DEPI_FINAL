package tests;

import driverFactory.Driver;
import org.testng.annotations.*;
import pages.*;

public class DownloadInvoiceAfterPurchaseOrderTest {
    public Driver driver;



    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp(@Optional("EDGE") String browserName){
        driver = new Driver(browserName);
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com/");


    }

    @Test(priority = 1)
    public void userCanAddItemToTheCard(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnFirstAddToCartButton()
                .clickOnContinueShoppingButton()
                .clickOnCartLink()
                .checkThatViewCartPageIsLoadedSuccessfully()
                .clickOnProceedToCheckOutForNonRegisteredUser()
                .clickOnRegisterLoginBtn()
                .checkThatUserIsNavigateToLoginSignUpPage();

    }

    @Test(priority = 2,dependsOnMethods = "userCanAddItemToTheCard")
    public void userCanRegisterSuccessfully() {
        new LoginSignupPage(driver)
                .fillInNameSingUp("Mariam12")
                .fillInEmailSingUpField("Test.Test2222@gmail.com")
                .clickOnSignUpButton()
                .checkThatRegistrationPageIsLoadedSuccessfully()
                .fillInRegistrationForm()
                .clickOnCreateAccount()
                .checkThatSuccessMessageShouldBeDisplayed()
                .clickOnContinueBtn()
                .checkThatHomePageIsLoadedSuccessfully();

    }
    @Test(priority = 3)
    public void userCanNavigateToCartPageSuccessfully(){
        new HomePage(driver)
                .clickOnCartLink()
                .checkThatViewCartPageIsLoadedSuccessfully()
                .clickOnProceedToCheckOutButtonForRegisteredUser()
                .checkThatCheckOutPageIsLoadedSuccessfully();

    }

    @Test(priority = 4,dependsOnMethods = "userCanNavigateToCartPageSuccessfully")
    public void userCanPlaceOrderSuccessfully(){
        new CheckoutPage(driver)
                .fillInTextArea()
                .clickOnPlaceOrderBtn()
                .checkThatPaymentPageIsLoadedSuccessfully();

    }

    @Test(priority = 5,dependsOnMethods = "userCanPlaceOrderSuccessfully")
    public void userCanPayAndConfirmOrderSuccessfully(){
        new PaymentPage(driver)
                .fillPaymentForm()
                .clickOnPayAndConfirmBtn()
                .checkSuccessMessageIsDisplayed();

    }
    @Test(priority = 6,dependsOnMethods = "userCanPayAndConfirmOrderSuccessfully")
    public void DownloadInvoiceAfterPurchaseTheOrder(){
        new PaymentSuccessPage(driver)
                .clickOnDownloadInVoiceButton()
                .checkThatInvoiceIsDownloadedSuccessfully()
                .clickOnContinueButton()
                .checkThatHomePageIsLoadedSuccessfully();

    }
    @Test(priority = 7,dependsOnMethods = "DownloadInvoiceAfterPurchaseTheOrder")
    public void userCanDeleteAccountSuccessfully(){
        new HomePage(driver)
                .checkThatDeleteLinkShouldBeDisplayed()
                .clickOnDeleteAccountLink()
                .checkThatAccountDeletedSuccessfully()
                .clickOnContinueButton()
                .checkThatHomePageIsLoadedSuccessfully();

    }

    @AfterClass
    public void tearDown(){
        driver.browser().deleteAllCookies();
         driver.quit();

    }
}
