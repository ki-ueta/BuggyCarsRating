package dev.selenium.pageObjects.componentObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BannerComponent {
    private final WebDriver driver;

    // Web elements
    private final By bannerTextLocator = new By.ByCssSelector("body > my-app > header > div > div > div > div.col-md-4 > h1");
    private final By bannerImgLocator = new By.ByCssSelector("body > my-app > header > div > div > div > div.col-md-8 > div > img");

    public BannerComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBannerTextLocator() {
        return driver.findElement(bannerTextLocator);
    }

    public WebElement getBannerImgLocator() {
        return driver.findElement(bannerImgLocator);
    }

    public boolean isBannerComponentDisplayed() {
        WebElement bannerText = getBannerTextLocator();
        boolean isBannerTextDisplayedAndNotBlank = bannerText.isDisplayed() & !bannerText.getText().isEmpty();
        boolean isBannerImgDisplayed = getBannerImgLocator().isDisplayed();

        return isBannerTextDisplayedAndNotBlank && isBannerImgDisplayed;
    }


}
