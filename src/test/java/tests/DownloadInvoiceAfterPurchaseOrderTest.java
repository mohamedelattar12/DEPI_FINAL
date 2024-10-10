package tests;

import driverFactory.Driver;
import org.testng.annotations.*;
import pages.*;

public class DownloadInvoiceAfterPurchaseOrderTest {
    public Driver driver;



    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp(@Optional("CHROME") String browserName){
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
                .clickOnProceedToCheckOutButtonForNonRegisterUser()
                .clickOnRegisterLoginButton()
                .checkThatUserIsNavigateToLoginSignUpPage();

    }

    @Test(priority = 2,dependsOnMethods = "userCanAddItemToTheCard")
    public void userCanRegisterSuccessfully() {
        new LoginSignupPage(driver)
                .fillInNameSingUp("Mariam")
                .fillInEmailSingUpButton("TestTest333@gmail.com")
                .clickOnSignUpButton()
                .checkThatRegistrationPageIsLoadedSuccessfully()
                .fillInRegistrationForm()
                .clickOnCreateAccount()
                .checkThatSuccessMessageShouldBeDisplayed()
                .clickOnContinueButton()
                .checkThatHomePageIsLoadedSuccessfully();

    }
    @Test(priority = 3,dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLogoutSuccessfully() {
        new HomePage(driver)
                .clickOnLogOutLink()
                .checkThatUserIsNavigateToLoginSignUpPage();

    }
    @Test(priority = 4,dependsOnMethods = "userCanLogoutSuccessfully")
    public void userCanLoginSuccessfully() {
        new LoginSignupPage(driver)
                .fillInLoginEmail("TestTest333@gmail.com")
                .fillInLoginPassword("12345678")
                .clickOnLoginButton()
                .checkThatHomePageIsLoadedSuccessfully();

    }
    @Test(priority = 5,dependsOnMethods = "userCanLoginSuccessfully")
    public void userCanNavigateToCartPageSuccessfully(){
        new HomePage(driver)
                .clickOnCartLink()
                .checkThatViewCartPageIsLoadedSuccessfully()
                .clickOnProceedToCheckOutButtonForRegisterUser()
                .checkThatCheckOutPageIsLoadedSuccessfully();

    }

    @Test(priority = 6,dependsOnMethods = "userCanNavigateToCartPageSuccessfully")
    public void userCanPlaceOrderSuccessfully(){
        new CheckOutPage(driver)
                .fillInDescriptionInCommentTextArea("size M")
                .clickOnPlaceOrderButton()
                .checkThatPaymentPageIsLoadedSuccessfully();

    }

    @Test(priority = 7,dependsOnMethods = "userCanPlaceOrderSuccessfully")
    public void userCanPayAndConfirmOrderSuccessfully(){
        new Payment(driver)
                .fillInPaymentForm()
                .clickOnPayAndConfirmOrder()
                .checkThatPaymentDonePageIsLoadedSuccessfully();

    }
    @Test(priority = 8,dependsOnMethods = "userCanPayAndConfirmOrderSuccessfully")
    public void DownloadInvoiceAfterPurchaseTheOrder(){
        new PaymentDone(driver)
                .clickOnDownloadInVoiceButton()
                .checkThatInvoiceIsDownloadedSuccessfully()
                .clickOnContinueButton()
                .checkThatHomePageIsLoadedSuccessfully();

    }
    @Test(priority = 9,dependsOnMethods = "DownloadInvoiceAfterPurchaseTheOrder")
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
