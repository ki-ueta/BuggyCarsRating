package dev.selenium.bases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    private static BaseConfig configuration;
    protected WebDriver driver;

    @BeforeAll
    public static void LoadConfig() {
        configuration = new BaseConfig();
        configuration.LoadPropertiesFromConfig();
    }

    @BeforeEach
    public void setup() {
        driver = new BaseDriver().Initiate(configuration);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}