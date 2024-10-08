package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverFactory extends DriverAbstract{

    @Override
    public WebDriver startDriver() {
        driver=new FirefoxDriver();
        return driver;
    }
}
