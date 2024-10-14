package tests;

import driverFactory.Driver;
import org.testng.annotations.*;
import pages.HomePage;

public class ScrollUpWithArrowButtonTest {
    public Driver driver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp(@Optional("EDGE") String browserName){
        driver = new Driver(browserName);
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com/");
    }

    @Test(priority = 1)

    public void scrollDownTest(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .scrollDownToBottom()
                .checkThatSubscriptionIsvIsVisible();


    }
    @Test(priority = 2 , dependsOnMethods = "scrollDownTest")
    public void ScrollUpWithArrowButton(){
        new HomePage(driver)
                .scrollUpToTopWithArrow()
                .checkThatThePageIsScrolledUpSuccessfully();
    }

    @AfterClass
    public void tearDown(){
        driver.browser().deleteAllCookies();
        driver.quit();

    }
}
