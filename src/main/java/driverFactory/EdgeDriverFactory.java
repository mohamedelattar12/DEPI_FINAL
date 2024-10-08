package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverFactory extends DriverAbstract{
    @Override
    public WebDriver startDriver() {
        driver=new EdgeDriver();
        return driver;
    }
}
