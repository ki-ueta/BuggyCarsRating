package dev.selenium.pageObjects;

import dev.selenium.bases.BaseConfig;
import dev.selenium.pageObjects.componentObjects.BannerComponent;
import dev.selenium.pageObjects.componentObjects.NavigationBarComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

public class HomePage extends LoadableComponent<HomePage> {
    private final WebDriver driver;

    // Components
    public final NavigationBarComponent navigationBar;
    public final BannerComponent banner;

    // Web elements
    private final By popularMakeHeaderBy = new By.ByCssSelector("body > my-app > div > main > my-home > div > div:nth-child(1) > div > h2");
    private final By popularMakeLinkBy = new By.ByCssSelector("body > my-app > div > main > my-home > div > div:nth-child(1) > div > a");
    private final By popularModelHeaderBy = new By.ByCssSelector("body > my-app > div > main > my-home > div > div:nth-child(2) > div > h2");

    private final By popularModelLinkBy = new By.ByCssSelector("body > my-app > div > main > my-home > div > div:nth-child(2) > div > a");
    private final By overallRatingHeaderBy = new By.ByCssSelector("body > my-app > div > main > my-home > div > div:nth-child(3) > div > h2");
    private final By overallRatingLinkBy = new By.ByCssSelector("body > my-app > div > main > my-home > div > div:nth-child(3) > div > a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.navigationBar = new NavigationBarComponent(driver);
        this.banner = new BannerComponent(driver);
    }

    public WebElement getPopularMakeHeader() {
        return driver.findElement(popularMakeHeaderBy);
    }

    public WebElement getPopularMakeLink() {
        return driver.findElement(popularMakeLinkBy);
    }

    public WebElement getPopularModelHeader() {
        return driver.findElement(popularModelHeaderBy);
    }

    public WebElement getPopularModelLink() {
        return driver.findElement(popularModelLinkBy);
    }

    public WebElement getOverallRatingHeader() {
        return driver.findElement(overallRatingHeaderBy);
    }

    public WebElement getOverallRatingLink() {
        return driver.findElement(overallRatingLinkBy);
    }

    @Override
    protected void load() {
        driver.get(new BaseConfig().url());
    }

    @Override
    protected void isLoaded() throws Error {
        boolean ready = false;

        try {
            boolean hasTitleLoaded = driver.getTitle().equals("Buggy Cars Rating");
            ready = hasTitleLoaded;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!ready) {
            throw new Error("Page has not loaded");
        }
    }
}
