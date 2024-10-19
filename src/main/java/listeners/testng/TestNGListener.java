package listeners.testng;

import driverFactory.Driver;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.AllureReportHelper;
import utilities.ScreenShotManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import static utilities.properties.PropertiesManager.*;

public class TestNGListener implements ITestListener, IExecutionListener {


    @Override
    public void onExecutionStart() {
        System.out.println("*************** Welcome to Selenium Framework ******************");
        initializeProperties();
        if (ReportConfig.getProperty("CleanAllureReport").equalsIgnoreCase("true")){
            AllureReportHelper.cleanAllureReport();
            System.out.println("Allure Report Cleaned Successfully");
        }
    }


    @Override
    public void onExecutionFinish() {
        System.out.println("Generating Report.........");
        if (ReportConfig.getProperty("OpenAllureReportAfterExecution").equalsIgnoreCase("true")) {
            try {
                System.out.println("Opening Allure Report");
                Runtime.getRuntime().exec("reportGeneration.bat");
            } catch (IOException e) {
                System.out.println("Unable to Generate Allure Report, may be there's an issue in the batch file/commands");
            }
        }
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

        assert driver != null;
        ScreenShotManager.CaptureScreenShot(driver.get(), result.getName());

        String fullPath = System.getProperty("user.dir") + result.getName();

        try {
            Allure.addAttachment(result.getMethod().getConstructorOrMethod().getName(),
                    FileUtils.openInputStream(new File(fullPath)));
        } catch (IOException e) {
            System.out.println("Attachment isn't Found");
        }

        System.out.println("*********** failure of Test: " + result.getName() + " *************");
    }

}
