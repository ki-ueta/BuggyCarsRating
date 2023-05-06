package dev.selenium.bases;

import dev.selenium.eventListeners.ConsoleLogEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class BaseDriver {
    public WebDriver Initiate(BaseConfig configuration) {
        WebDriver driver;

        switch (configuration.browser()) {
            case "chrome":
                System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
                System.setProperty("webdriver.chrome.verboseLogging", "true");
                driver = new ChromeDriver();
                break;
            default:
                driver = new FirefoxDriver();
        }

        // Decorate a driver with listeners.
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(new ConsoleLogEventListener());
        WebDriver decorateDriver = decorator.decorate(driver);

        // Setup generic driver options
        decorateDriver.manage().window().maximize();
        decorateDriver.manage().timeouts().implicitlyWait(configuration.defaultWaitInSecond());
        return decorateDriver;
    }
}
