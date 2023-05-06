package dev.selenium.pageObjects.componentObjects;

import dev.selenium.bases.BaseConfig;
import dev.selenium.pageObjects.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBarComponent {
    private final WebDriver driver;
    private final WebDriverWait conditionalWait;
    private final BaseConfig configuration;

    // Web elements
    private final By homeIconBy = new By.ByCssSelector("body > my-app > header > nav > div > a");
    // Before logging in
    private final By usernameTextBoxBy = new By.ByName("login");
    private final By passwordTextboxBy = new By.ByName("password");
    private final By loginButtonBy = new By.ByCssSelector("body > my-app > header > nav > div > my-login > div > form > button");
    private final By registerButtonBy = new By.ByCssSelector("body > my-app > header > nav > div > my-login > div > form > a");
    // Logged in
    private final By welcomeMsgBy = new By.ByCssSelector("body > my-app > header > nav > div > my-login > div > ul > li:nth-child(1) > span");
    private final By profileBy = new By.ByCssSelector("body > my-app > header > nav > div > my-login > div > ul > li:nth-child(2) > a");
    private final By logoutBy = new By.ByCssSelector("body > my-app > header > nav > div > my-login > div > ul > li:nth-child(3) > a");

    public NavigationBarComponent(WebDriver driver) {
        this.driver = driver;
        configuration = new BaseConfig();
        conditionalWait = new WebDriverWait(driver, new BaseConfig().defaultFluentWaitInSecond());
    }

    public WebElement getHomeIcon() {
        return driver.findElement(homeIconBy);
    }

    public WebElement getUsernameTextBox() {
        return driver.findElement(usernameTextBoxBy);
    }

    public WebElement getPasswordTextBox() {
        return driver.findElement(passwordTextboxBy);
    }

    public WebElement getRegisterButton() {
        return driver.findElement(registerButtonBy);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonBy);
    }

    public WebElement getWelcomeMsg() {
        return driver.findElement(welcomeMsgBy);
    }

    public WebElement getProfileLink() {
        return driver.findElement(profileBy);
    }

    public WebElement getLogoutLink() {
        return driver.findElement(logoutBy);
    }

    public boolean isStandardNavigationBarDisplay() {
        boolean isHomeIconDisplay = getHomeIcon().isDisplayed();

        WebElement usernameTextBox = getUsernameTextBox();
        boolean isUsernameDisplayAndEnable = usernameTextBox.isEnabled() && usernameTextBox.isDisplayed();

        WebElement passwordTextBox = getPasswordTextBox();
        boolean isPasswordDisplayAndEnable = passwordTextBox.isEnabled() && passwordTextBox.isDisplayed();

        WebElement loginButton = getLoginButton();
        boolean isLoginButtonDisplayAndEnable = loginButton.isEnabled() && loginButton.isDisplayed();

        WebElement registerButton = getRegisterButton();
        boolean isRegisterButtonDisplayAndEnable = registerButton.isEnabled() && registerButton.isDisplayed();

        return isHomeIconDisplay && isUsernameDisplayAndEnable && isPasswordDisplayAndEnable && isLoginButtonDisplayAndEnable && isRegisterButtonDisplayAndEnable;
    }

    public boolean isLoggedInNavigationBarDisplay() {
        boolean isWelcomeMsgDisplay = getWelcomeMsg().isDisplayed();
        boolean isProfileLinkDisplay = getProfileLink().isDisplayed();
        boolean isLogoutLinkDisplay = getLogoutLink().isDisplayed();

        return isWelcomeMsgDisplay && isProfileLinkDisplay && isLogoutLinkDisplay;
    }

    public void successfullyLoginWithUsername() {
        successfullyLoginWithUsername(configuration.defaultUserName());
    }

    public void successfullyLoginWithUsername(String username) {
        WebElement usernameTextBox = getUsernameTextBox();
        WebElement passwordTextBox = getPasswordTextBox();
        WebElement loginButton = getLoginButton();

        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(configuration.defaultPassword());

        loginButton.click();
        conditionalWait.until(ExpectedConditions.invisibilityOf(usernameTextBox));
    }

    public void logoutSuccessfully() {
        WebElement logoutLink = getLogoutLink();
        logoutLink.click();

        conditionalWait.until(ExpectedConditions.invisibilityOf(logoutLink));
    }

    public RegisterPage clickRegister() {
        getRegisterButton().click();
        return new RegisterPage(driver);
    }

}
