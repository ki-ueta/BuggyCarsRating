package dev.selenium.bases;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseConfig {

    public void LoadPropertiesFromConfig() {

        String propFileName = "config.properties";

        try {
            InputStream configFile = BaseConfig.class.getClassLoader().getResourceAsStream(propFileName);

            Properties prop = new Properties(System.getProperties());
            prop.load(configFile);

            // set the system properties
            System.setProperties(prop);

        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    public String url() {
        return System.getProperty("Url");
    }

    public String browser() {
        return System.getProperty("Browser", "");
    }

    public Duration defaultWaitInSecond() {
        String defaultWaitInSecondString = System.getProperty("DefaultWaitInSeconds", "30");
        return Duration.ofSeconds(Integer.parseInt(defaultWaitInSecondString));
    }

    public Duration defaultFluentWaitInSecond() {
        String defaultFluentWaitInSecondString = System.getProperty("DefaultFluentWaitInSeconds", "5");
        return Duration.ofSeconds(Integer.parseInt(defaultFluentWaitInSecondString));
    }

    public String defaultUserName() {
        return System.getProperty("DefaultUserName");
    }

    public String defaultPassword() {
        return System.getProperty("DefaultPassword");
    }


}
