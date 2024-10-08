package listeners.testng;

import driverFactory.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenShotManager;

import java.lang.reflect.Field;

public class TestNGListener implements ITestListener, IExecutionListener {


    @Override
    public void onExecutionStart() {
        System.out.println("*************** Welcome to Selenium Framework ******************");
    }


    @Override
    public void onExecutionFinish() {
        System.out.println("Generating Report.........");
        System.out.println("****************** End of Execution ***************************");

    }


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("********* Starting Test: " + result.getName() + " ************");

    }


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("********* Success of Test: " + result.getName() + " ************");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
        System.out.println("Taking screen shot.....");

        Driver driver = null;
        ThreadLocal<Driver> driverThreadLocal;

        Object currentClass = result.getInstance();
        Field[] fields = result.getTestClass().getRealClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                if (field.getType() == Driver.class) {
                    driver = (Driver) field.get(currentClass);
                }
                if (field.getType() == ThreadLocal.class) {
                    driverThreadLocal = (ThreadLocal<Driver>) field.get(currentClass);
                    driver = driverThreadLocal.get();
                }
            }

        } catch (IllegalAccessException exception) {
            System.out.println("Unable to get field, Field should be public");
        }
//        try {
//            driver = (Driver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        }
        assert driver != null;
        ScreenShotManager.CaptureScreenShot(driver.get(), result.getName());


//        ScreenShotManager.CaptureScreenShot(Driver.get(), result.getName());
        System.out.println("*********** failure of Test: " + result.getName() + " *************");


    }


}
