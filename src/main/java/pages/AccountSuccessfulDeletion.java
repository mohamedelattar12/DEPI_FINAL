package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountSuccessfulDeletion {
    private Driver driver;

    By deleteAccountSuccessMessage = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountSuccessfulDeletion(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check that account deleted sccessfully")
    public AccountSuccessfulDeletion checkThatAccountDeletedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/delete_account"));
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountSuccessMessage));
        Assert.assertEquals(driver.element().getTextOf(deleteAccountSuccessMessage), "ACCOUNT DELETED!");
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that user can click on continue button")
    public HomePage clickOnContinueButton() {
        driver.element().click(continueButton);
        return new HomePage(driver);
    }

}
