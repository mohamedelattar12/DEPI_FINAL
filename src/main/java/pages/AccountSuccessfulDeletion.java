package pages;

import driverFactory.Driver;
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
    public AccountSuccessfulDeletion checkThatAccountDeletedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/delete_account"));
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountSuccessMessage));
        Assert.assertEquals(driver.element().getTextOf(deleteAccountSuccessMessage), "ACCOUNT DELETED!");
        return this;
    }

    public HomePage clickOnContinueButton() {
        driver.element().click(continueButton);
        return new HomePage(driver);
    }

}
