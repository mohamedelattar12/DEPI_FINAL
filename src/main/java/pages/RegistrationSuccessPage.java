package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationSuccessPage {
    private Driver driver;
    private WebDriverWait wait;

    By accountCreated = By.xpath("//h2[@data-qa=\"account-created\"]");
    By continueBtn = By.xpath("//a[@data-qa=\"continue-button\"]");

    public RegistrationSuccessPage(Driver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver.get(), Duration.ofSeconds(30));
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check that success message should be displayed")
    public RegistrationSuccessPage checkThatSuccessMessageShouldBeDisplayed() {
//        wait.until(ExpectedConditions.urlContains("/account_created"));
        wait.until(ExpectedConditions.visibilityOf(driver.get().findElement(accountCreated)));

        Assert.assertTrue(driver.element().isDisplayed(accountCreated));
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/account_created"));
        Assert.assertEquals(driver.element().getTextOf(accountCreated)
                , "ACCOUNT CREATED!");
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that user can click on Continue button")
    public HomePage clickOnContinueBtn() {
        driver.element().click(continueBtn);
        return new HomePage(driver);
    }

}
