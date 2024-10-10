package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PaymentPage {
    private Driver driver;
    By deleteAccountBtn = By.xpath("//a[@href=\"/delete_account\"]");


    By nameOnCardField = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvcField = By.xpath("//input[@data-qa=\"cvc\"]");
    By expirationMonth = By.name("expiry_month");
    By expriationYear = By.xpath("//input[@name=\"expiry_year\"]");
    By payAndConfirmBtn = By.xpath("//button[@class=\"form-control btn btn-primary submit-button\"]");


/*********************************  Actions  *****************************************************/



    public PaymentPage fillPaymentForm(){
        driver.element().fillField(nameOnCardField,"esraa");
        driver.element().fillField(cardNumber, "123456789");
        driver.element().fillField(cvcField,"311");
        driver.element().fillField(expirationMonth,"03");
        driver.element().fillField(expriationYear,"2025");


        return this;
    }
    public PaymentSuccessPage clickOnPayAndConfirmBtn (){
        driver.element().click(payAndConfirmBtn);
        return new PaymentSuccessPage(driver);
    }

    public AccountSuccessfulDeletion clickOnDeleteAccountBtn(){
        driver.element().click(deleteAccountBtn);
        return new AccountSuccessfulDeletion(driver);

    }


    public PaymentPage (Driver driver){
        this.driver = driver;
    }


}
