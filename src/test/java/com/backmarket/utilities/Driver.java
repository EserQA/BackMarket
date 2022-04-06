package com.backmarket.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {}

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            String browser = ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();

                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
                    chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                    chromeOptions.addArguments("ignore-certificate-errors");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                    chromeOptions.addArguments("--full-screen");
                    chromeOptions.setAcceptInsecureCerts(true);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
    }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
