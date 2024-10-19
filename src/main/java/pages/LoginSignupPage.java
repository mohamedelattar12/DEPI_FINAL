package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginSignupPage {

    private Driver driver;
    WebDriverWait wait;

    By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    By signUpName = By.xpath("//input[@type=\"text\"]");
    By signUpEmail = By.xpath("(//input[@type=\"email\"])[2]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    By signUpFormTitle = By.xpath("//div[@class=\"signup-form\"]/h2");
    By loginToYourAccount = By.xpath("(//div/h2)[1]");
    By errorMessageUsingWrongEmail = By.xpath("(//form/p)[1]");
    By errorMessageUsingExistEmail = By.xpath("(//form/p)[1]");


    public LoginSignupPage(Driver driver) {
//        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        this.driver = driver;
    }


    /*********************************  Assertions  *****************************************************/

    @Step("Check that user is navigate to Login SignUp Page")
    public LoginSignupPage checkThatUserIsNavigateToLoginSignUpPage() {
//       wait.until(ExpectedConditions.visibilityOf(driver.get().findElement(signUpFormTitle)));
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/login"));
        Assert.assertEquals(driver.element().getTextOf(signUpFormTitle), "New User Signup!");
        return this;
    }

    @Step("Check that Login to your account is visible")
    public LoginSignupPage checkThatLoginToYourAccountIsVisible() {
        Assert.assertTrue(driver.element().isDisplayed(loginToYourAccount));
        Assert.assertEquals(driver.element().getTextOf(loginToYourAccount), "Login to your account");
        return this;
    }

    @Step("Check that error message is visible when use incorrect email to login")
    public LoginSignupPage checkThatErrorMessageIsVisibleWhenUseInCorrectEmailToLogin() {
        Assert.assertTrue(driver.element().isDisplayed(errorMessageUsingWrongEmail));
        Assert.assertEquals(driver.element().getTextOf(errorMessageUsingWrongEmail), "Your email or password is incorrect!");
        return this;
    }

    @Step("Check that error message is visible when use exist email")
    public LoginSignupPage checkThatErrorMessageIsVisibleWhenUseExistEmail() {
        Assert.assertTrue(driver.element().isDisplayed(errorMessageUsingExistEmail));
        Assert.assertEquals(driver.element().getTextOf(errorMessageUsingWrongEmail), "Email Address already exist!");
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that user can fill in login email")
    public LoginSignupPage fillInLoginEmail(String email) {
        driver.element().fillField(loginEmail, email);
        return this;
    }

    @Step("Check that user can fill in login password")
    public LoginSignupPage fillInLoginPassword(String password) {
        driver.element().fillField(loginPassword, password);
        return this;
    }

    @Step("Check that user can click on Login button")
    public HomePage clickOnLoginButton() {
        driver.element().click(loginButton);
        return new HomePage(driver);
    }

    @Step("Check that user can click on Login button using incorrect data")
    public LoginSignupPage clickOnLoginButtonUsingIncorrectData() {
        driver.element().click(loginButton);
        return this;
    }

    @Step("Check that user can fill in Name SingUp field")
    public LoginSignupPage fillInNameSingUpField(String name) {
        driver.element().fillField(signUpName, name);
        return this;
    }

    @Step("Check that user can fill in Email SingUp field")
    public LoginSignupPage fillInEmailSingUpField(String email) {
        driver.element().fillField(signUpEmail, email);
        return this;
    }
    @Step("Check that user can click on SignUp button")
    public RegistrationPage clickOnSignUpButton() {
        driver.element().click(signUpButton);
        return new RegistrationPage(driver);
    }

    @Step("Check that user can click on SignUp button using existing email")
    public LoginSignupPage clickOnSignUpButtonUsingExistEmail() {
        driver.element().click(signUpButton);
        return this;
    }
}