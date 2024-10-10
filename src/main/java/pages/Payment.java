package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Payment {
    private Driver driver;
    private WebDriverWait wait;

    By payment = By.className("heading");
    By nameOnCard = By.xpath("//input[@data-qa=\"name-on-card\"]");
    By cardNumber = By.xpath("//input[@data-qa=\"card-number\"]");
    By cvc = By.xpath("//input[@data-qa=\"cvc\"]");
    By expiration = By.xpath("//input[@data-qa=\"expiry-month\"]");
    By expirationYear = By.xpath("//input[@data-qa=\"expiry-year\"]");
    By payAndConfirmOrder = By.xpath("//button[@data-qa=\"pay-button\"]");
    By successMessage = By.xpath("(//div[@class=\"alert-success alert\"])[1]");


    public Payment(Driver driver){this.driver=driver;}

    /**********************************  Assertions  ****************************************/

    public Payment checkThatPaymentPageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/payment"));
        Assert.assertTrue(driver.element().isDisplayed(payment));
        return this;

    }

    public Payment checkThatSuccessMessageAppear(){
        Assert.assertTrue(driver.element().isDisplayed(successMessage));
        return this;
    }

    /**********************************  Actions  ****************************************/


    public Payment fillInPaymentForm(){
        driver.element().fillField(nameOnCard,"mariam");
        driver.element().fillField(cardNumber,"12345");
        driver.element().fillField(cvc,"122");
        driver.element().fillField(expiration,"07");
        driver.element().fillField(expirationYear,"2050");
        return this;
    }

    public PaymentDone clickOnPayAndConfirmOrder(){
        driver.element().click(payAndConfirmOrder);
        return new PaymentDone(driver);
    }


}
