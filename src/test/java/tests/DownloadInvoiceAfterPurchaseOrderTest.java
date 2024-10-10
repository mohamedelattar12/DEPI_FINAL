package tests;

import driverFactory.Driver;
import org.testng.annotations.*;
import pages.HomePage;

public class DownloadInvoiceAfterPurchaseOrder {
    public Driver driver;



    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp(@Optional("CHROME") String browserName){
        driver = new Driver(browserName);
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com/");


    }

    @Test
    public void DownloadInvoiceAfterPurchaseOrder(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnFirstAddToCartButton()
                .clickOnContinueShoppingButton()
                .clickOnCartLink()
                .checkThatViewCartPageIsLoadedSuccessfully()
                .clickOnProceedToCheckOutButtonForNonRegisterUser()
                .clickOnRegisterLoginButton()
                .checkThatUserIsNavigateToLoginSignUpPage()
                .fillInNameSingUp("Mariam")
                .fillInEmailSingUpButton("TestTest333@gmail.com")
                .clickOnSignUpButton()
                .checkThatRegistrationPageIsLoadedSuccessfully()
                .fillInRegistrationForm()
                .clickOnCreateAccount()
                .checkThatSuccessMessageShouldBeDisplayed()
                .clickOnContinueButton()
                .clickOnLogOutLink()
                .fillInLoginEmail("TestTest333@gmail.com")
                .fillInLoginPassword("12345678")
                .clickOnLoginButton()
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnCartLink()
                .checkThatViewCartPageIsLoadedSuccessfully()
                .clickOnProceedToCheckOutButtonForRegisterUser()
                .checkThatCheckOutPageIsLoadedSuccessfully()
                .fillInDescriptionInCommentTextArea("size M")
                .clickOnPlaceOrderButton()
                .checkThatPaymentPageIsLoadedSuccessfully()
                .fillInPaymentForm()
                .clickOnPayAndConfirmOrder()
                .checkThatPaymentDonePageIsLoadedSuccessfully()
                .clickOnDownloadInVoiceButton()
                .checkThatInvoiceIsDownloadedSuccessfully()
                .clickOnContinueButton()
                .checkThatHomePageIsLoadedSuccessfully()
                .checkThatDeleteLinkShouldBeDisplayed()
                .clickOnDeleteAccountLink()
                .checkThatAccountDeletedSuccessfully()
                .clickOnContinueButton();


    }

    @AfterClass
    public void tearDown(){

    }
}
