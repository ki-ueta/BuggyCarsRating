package dev.selenium.pageObjects;

import dev.selenium.bases.BaseConfig;
import dev.selenium.pageObjects.componentObjects.NavigationBarComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarModelPage extends LoadableComponent<CarModelPage> {
    private final WebDriver driver;
    private final WebDriverWait conditionalWait;

    // Components
    public final NavigationBarComponent navigationBar;

    // Web elements
    private final By specificationSectionBy = new By.ByCssSelector("body > my-app > div > main > my-model > div > div:nth-child(1) > div.col-lg-4 > div:nth-child(1) > div > h4");
    private final By voteLabelBy = new By.ByCssSelector("body > my-app > div > main > my-model > div > div:nth-child(1) > div.col-lg-4 > div:nth-child(2) > div:nth-child(1) > h4");
    private final By commentTextBoxby = new By.ById("comment");
    private final By voteButtonBy = new By.ByCssSelector("body > my-app > div > main > my-model > div > div:nth-child(1) > div.col-lg-4 > div:nth-child(2) > div:nth-child(2) > div > button");
    private final By noVoteMsgBy = new By.ByCssSelector("body > my-app > div > main > my-model > div > div:nth-child(1) > div.col-lg-4 > div:nth-child(2) > div:nth-child(2) > p");

    public CarModelPage(WebDriver driver) {
        this.driver = driver;
        this.navigationBar = new NavigationBarComponent(driver);
        conditionalWait = new WebDriverWait(driver, new BaseConfig().defaultFluentWaitInSecond());
    }

    public WebElement getSpecificationSection() {
        return driver.findElement(specificationSectionBy);
    }

    public WebElement getVoteLabel() {
        return driver.findElement(voteLabelBy);
    }

    public WebElement getCommentTextBox() {
        return driver.findElement(commentTextBoxby);
    }

    public WebElement getVoteButton() {
        return driver.findElement(voteButtonBy);
    }

    @Override
    protected void load() {
        driver.get(new BaseConfig().url() + "/model/c4u1mqnarscc72is013g%7Cc4u1mqnarscc72is0140");
    }

    @Override
    protected void isLoaded() throws Error {
        boolean ready = false;

        try {
            ready = this.getSpecificationSection().isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!ready) {
            throw new Error("Page has not loaded");
        }
    }
}
