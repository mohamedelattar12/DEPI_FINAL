package tests;

import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class ViewCategoryProducts {
    public Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().maximizeWindows();
        driver.browser().navigateToURL("https://automationexercise.com");
    }

    @Test
    public void checkThatUserCanDealWithCategoryPageSuccessfully() {
        new HomePage(driver)
//                .clickOnLoginLink().fillInLoginEmail("doaa121093@gmail.com").fillInLoginPassword("123456").clickOnLoginButton()
                .checkThatCategoriesAreVisibleOnLeftSideBar()
                .clickOnWomenCategory().clickOnTopsWomenCategory()
                .checkThatCategoryPageIsLoadedSuccessfully()
                .clickOnMenCategory().clickOnjeansMenCategory()
                .checkThatUserIsNavigatedToMenProductsPageSuccessfully();


    }


    @AfterClass
    public void tearDown() {
//        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
