package pages;

import driverFactory.Driver;
import elementActions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsPage {
    private Driver driver;
    FluentWait fluentWait;
    ElementActions element;


    By contactUsFormTitle = By.xpath("(//h2[@class=\"title text-center\"])[1]");
    By fromTitle = By.xpath("(//h2[@class=\"title text-center\"])[2]");
    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageField = By.id("message");
    By submitButton = By.name("submit");
    By successMessage = By.cssSelector("div.status.alert.alert-success");
    By homeButton = By.cssSelector("a.btn.btn-success");


    public ContactUsPage(Driver driver) {
//        fluentWait=new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(10))
//                .ignoring(NoSuchElementException.class);
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    public ContactUsPage checkThatContactUsPageIsLoadedSuccessfully() {

//        fluentWait.until(ExpectedConditions.textToBe(fromTitle,"GET IN TOUCH"));

        Assert.assertTrue(driver.browser().getCurrentURL().contains("/contact_us"));
        Assert.assertTrue(driver.element().isDisplayed(fromTitle));
        Assert.assertEquals(driver.element().getTextOf(fromTitle), "GET IN TOUCH");
        return this;
    }

    public ContactUsPage checkThatFormShouldBeSubmittedSuccessfully() {
        Assert.assertEquals(driver.element().getTextOf(successMessage), "Success! Your details have been submitted successfully.");
        return this;
    }

    /*********************************  Actions  *****************************************************/

    public ContactUsPage fillInContactUsFrom(String name, String email, String subject, String message) {
   driver.element().fillField(nameField,name);
        driver.element().fillField(emailField,email);
        driver.element().fillField(subjectField,subject);
        driver.element().fillField(messageField,message);
        return this;
    }

    public ContactUsPage clickOnSubmitButton() {
        driver.element().click(submitButton);
        driver.get().switchTo().alert().accept();
        return this;
    }

    public HomePage clickOnHomeButton() {
        driver.element().click(homeButton);
        return new HomePage(driver);
    }
}
