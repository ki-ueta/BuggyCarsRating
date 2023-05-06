package dev.selenium.pageObjects;

import dev.selenium.bases.BaseConfig;
import dev.selenium.pageObjects.componentObjects.BannerComponent;
import dev.selenium.pageObjects.componentObjects.NavigationBarComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.UUID;

public class RegisterPage extends LoadableComponent<RegisterPage> {
    private final WebDriver driver;
    private final BaseConfig configuration;

    // Components
    public final NavigationBarComponent navigationBar;
    public final BannerComponent banner;

    // Web elements
    private final By pageHeaderLocator = new By.ByCssSelector("body > my-app > div > main > my-register > div > div > h2");
    private final By loginTextBoxLocator = new By.ById("username");
    private final By firstNameTextBoxLocator = new By.ById("firstName");
    private final By lastNameTextBoxLocator = new By.ById("lastName");
    private final By passwordTextBoxLocator = new By.ById("password");
    private final By confirmPasswordTextBoxLocator = new By.ById("confirmPassword");
    private final By registerButtonLocator = new By.ByCssSelector("body > my-app > div > main > my-register > div > div > form > button");
    private final By successfulRegistrationMsgLocator = new By.ByCssSelector("body > my-app > div > main > my-register > div > div > form > div.result.alert.alert-success");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.navigationBar = new NavigationBarComponent(driver);
        this.banner = new BannerComponent(driver);

        this.configuration = new BaseConfig();
    }

    public WebElement getPageHeader() {
        return driver.findElement(pageHeaderLocator);
    }

    public WebElement getFirstNameTextBox() {
        return driver.findElement(firstNameTextBoxLocator);
    }

    public WebElement getLastNameTextBox() {
        return driver.findElement(lastNameTextBoxLocator);
    }

    public WebElement getLoginTextBox() {
        return driver.findElement(loginTextBoxLocator);
    }

    public WebElement getPasswordTextBox() {
        return driver.findElement(passwordTextBoxLocator);
    }

    public WebElement getConfirmPasswordTextBox() {
        return driver.findElement(confirmPasswordTextBoxLocator);
    }

    public WebElement getRegisterButton() {
        return driver.findElement(registerButtonLocator);
    }

    public WebElement getSuccessMsg() {
        return driver.findElement(successfulRegistrationMsgLocator);
    }

    public String successfullyRegisterNewUser() {
        String username = this.generateRandomUsername();

        getLoginTextBox().sendKeys(username);
        getFirstNameTextBox().sendKeys("First");
        getLastNameTextBox().sendKeys("Last");
        getPasswordTextBox().sendKeys(this.configuration.defaultPassword());
        getConfirmPasswordTextBox().sendKeys(this.configuration.defaultPassword());

        getRegisterButton().click();

        return username;
    }

    @Override
    protected void load() {
        driver.get(new BaseConfig().url() + "/register");
    }

    @Override
    protected void isLoaded() throws Error {
        boolean ready = false;

        try {
            ready = getPageHeader().isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!ready) {
            throw new Error("Page has not loaded");
        }
    }

    private String generateRandomUsername() {
        int desiredLength = 16;
        String random = UUID.randomUUID()
                .toString()
                .substring(0, desiredLength);
        return random;
    }
}
