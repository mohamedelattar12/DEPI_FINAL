package pages;

import driverFactory.Driver;
import elementActions.ElementActions;
import org.openqa.selenium.By;
import org.testng.Assert;


public class CheckoutPage {
private Driver driver;

By addressDetails = By.xpath("//div[@class=\"checkout-information\"]");
By reviewOrder = By.xpath("//div[@class=\"table-responsive cart_info\"]");
By commentTextArea = By.xpath("//textarea[@name=\"message\"]");
By placeOrderBtn = By.xpath("//a[@class=\"btn btn-default check_out\"]");


 /*********************************  Assertions  *****************************************************/

 public CheckoutPage CheckAddressDetailsIsDisplayed () {
     Assert.assertTrue(driver.element().isDisplayed(addressDetails));
     return this;
 }
    public CheckoutPage CheckReviewOrderIsDisplayed () {
        Assert.assertTrue(driver.element().isDisplayed(reviewOrder));
        return this;
    }

 /*********************************  Actions  *****************************************************/

   public CheckoutPage fillInTextArea(){
       driver.element().fillField(commentTextArea, "Blue Top");
       return this;
   }
    public PaymentPage clickOnPlaceOrderBtn(){
        driver.element().click(placeOrderBtn);
        return new PaymentPage(driver);
    }




    public CheckoutPage(Driver driver){
        this.driver = driver;
    }
}
