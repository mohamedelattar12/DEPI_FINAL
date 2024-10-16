package tests;

import driverFactory.Driver;
import org.testng.annotations.*;
import pages.HomePage;
import utilities.ScreenShotManager;

import java.time.Duration;

public class ContactUsFormTest {
    public Driver driver;
//   public ThreadLocal<Driver> driver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void SetUp(@Optional("CHROME") String browserName) {
        driver = new Driver();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test(priority = 1)
    public void contactUsTest() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .clickOnContactUsLink()
                .checkThatContactUsPageIsLoadedSuccessfully()
                .fillInContactUsFrom("Mariam", "TestTest122@gmail.com", "Test", "Welcome")
                .clickOnSubmitButton()
                .checkThatFormShouldBeSubmittedSuccessfully()
                .clickOnHomeButton()
                .checkThatHomePageIsLoadedSuccessfully();
        ScreenShotManager.CaptureScreenShot(driver.get(), "ContactUs");


    }

//    @AfterMethod
//    public void screenShotOnFailure(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            System.out.println("Test Failed");
//            System.out.println("Taking screen shot.....");
//            ScreenShotManager.CaptureScreenShot(driver.get(), result.getName());
//        }
//    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
