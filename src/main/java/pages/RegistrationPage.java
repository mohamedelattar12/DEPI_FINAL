package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

    private Driver driver;

    By pageTitle = By.xpath("(//h2[@class=\"title text-center\"])[1]");
    By password = By.id("password");
    By days = By.xpath("//select[@data-qa=\"days\"]");
    By months = By.xpath("//select[@data-qa=\"months\"]");
    By years = By.id("years");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company=By.id("company");
    By address = By.xpath("//input[@data-qa=\"address\"]");
    By address2=By.xpath("//input[@data-qa=\"address2\"]");
    By country = By.xpath("//select[@data-qa=\"country\"]");
    By state = By.xpath("//input[@data-qa=\"state\"]");
    By city = By.xpath("//input[@data-qa=\"city\"]");
    By zipCode = By.id("zipcode");
    By mobile = By.id("mobile_number");
    By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");
    By newsletterCheckBox=By.id("newsletter");
    By receiveOffersFromPartners=By.id("optin");



    public RegistrationPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    public RegistrationPage checkThatRegistrationPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/signup"));
        Assert.assertTrue(driver.element().isDisplayed(pageTitle));
        Assert.assertEquals(driver.element().getTextOf(pageTitle), "ENTER ACCOUNT INFORMATION");
        return this;
    }


    /*********************************  Actions  *****************************************************/

    public RegistrationPage fillInRegistrationForm() {
        driver.element().fillField(password, "12345678");

        driver.element().selectByIndex(days, 4);
//        Select selectDays = new Select(driver.get().findElement(days));
//        selectDays.selectByIndex(4);

        driver.element().selectByIndex(months,10);
//        Select selectMonth = new Select(driver.get().findElement(months));
//        selectMonth.selectByIndex(10);

        driver.element().selectByValue(years,"1986");
//        Select selectYears = new Select(driver.get().findElement(years));
//        selectYears.selectByValue("1986");

        driver.element().click(newsletterCheckBox);
        driver.element().click(receiveOffersFromPartners);


        driver.element().fillField(firstName, "Mariam");
        driver.element().fillField(lastName, "Beshara");
        driver.element().fillField(company,"DEPI");
        driver.element().fillField(address, "Alex");
        driver.element().fillField(address2,"Alex");


        Select selectCountry = new Select(driver.get().findElement(country));
        selectCountry.selectByValue("Canada");

        driver.element().fillField(state, "Alex");
        driver.element().fillField(city, "Alex");
        driver.element().fillField(zipCode, "123456");
        driver.element().fillField(mobile, "01236985214");
        return this;
    }

    public RegistrationSuccessPage clickOnCreateAccount() {
        driver.element().click(createAccountButton);
        return new RegistrationSuccessPage(driver);
    }



}
