package tests;

import driverFactory.Driver;
import org.testng.annotations.*;
import pages.HomePage;

public class ScrollUpWithoutArrowButtonTest {
    public Driver driver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp(@Optional("EDGE") String browserName){
        driver = new Driver(browserName);
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com/");
    }

    @Test
    public void scrollDownTest(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .scrollDownToBottom()
                .checkThatSubscriptionIsvIsVisible();


    }

    @Test
    public void scrollUpWithoutArrowButton(){
        new HomePage(driver)
                .scrollUpToTopWithoutArrow()
                .checkThatThePageIsScrolledUpSuccessfully();
    }

    @AfterClass
    public void tearDown(){
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
