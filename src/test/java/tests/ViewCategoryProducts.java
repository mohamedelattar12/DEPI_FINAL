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
        driver = new Driver();

    }

    @Test
    public void checkThatUserCanDealWithCategoryPageSuccessfully() {
        new HomePage(driver)
                .checkThatCategoriesAreVisibleOnLeftSideBar()
                .clickOnWomenCategory().clickOnTopsWomenCategory()
                .checkThatCategoryPageIsLoadedSuccessfully()
                .clickOnMenCategory().clickOnJeansMenCategory()
                .checkThatUserIsNavigatedToMenProductsPageSuccessfully();


    }


    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }
}
