package tests;

import driverFactory.Driver;
import org.testng.annotations.*;
import pages.HomePage;

import java.time.Duration;

public class ScrollUpWithoutArrowButtonTest {
    public Driver driver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp(@Optional("EDGE") String browserName){
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test(priority = 1)
    public void scrollDownTest(){
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .scrollDownToBottom()
                .checkThatSubscriptionIsVisible();

    }

    @Test(priority = 2,dependsOnMethods = "scrollDownTest")
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
