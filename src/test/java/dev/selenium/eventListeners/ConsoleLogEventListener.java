package dev.selenium.eventListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class ConsoleLogEventListener implements WebDriverListener {

    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Looking For " + locator.toString());
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("Finished looking for " + locator.toString());
    }

}
