package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class AddReviewOnProduct {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void writeReviewOnProduct(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnProductsLink()
                .checkThatProductsPageIsLoadedSuccessfully()
                .clickOnViewProductButton()
                .checkThatWriteYourReviewIsVisible()
                .fillInReviewerName("Ahmed")
                .fillInReviewerEmail("TestTest122@gmail.com")
                .fillInReviewerReview("This is good quality at a good price.")
                .ClickOnReviewerSubmitBtn()
                .checkThatSuccessMsgForReviewIsVisible();
    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();


    }
}

