package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class RemoveProductsFromCart {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
    }

    @Test
    public void checkThatUserCanRemoveProductsFromCartSuccessfully() {
        new HomePage(driver).checkThatHomePageIsLoadedSuccessfully().clickOnLoginLink()
                .fillInLoginEmail("doaa121093@gmail.com").fillInLoginPassword("123456")
                .clickOnLoginButton()
                .checkThatLoggedInAsUsernameIsDisplayed("Doaa")
                .clickOnFirstAddToCartButton().clickOnCartLink()
                .checkThatViewCartPageIsLoadedSuccessfully().clickOnremoveProductBtn()
                .checkThatProductRemovedFromTheCartSuccessfully();


    }


    @AfterClass
    public void tearDown() {
//        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
