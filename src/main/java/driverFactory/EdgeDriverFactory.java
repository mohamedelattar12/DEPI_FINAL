package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static utilities.properties.PropertiesManager.WebConfig;

public class EdgeDriverFactory extends DriverAbstract{
    @Override
    public WebDriver startDriver() {

        EdgeOptions options=new EdgeOptions();
        if (WebConfig.getProperty("HeadlessMode").equalsIgnoreCase("true")){
            options.addArguments("--headless");
            System.out.println("Start With Headless Mode");
        }
        driver=new EdgeDriver(options);
        return driver;
    }
}
