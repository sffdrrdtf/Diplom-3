package ru.check_website.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {
    private static final String YANDEX_DRIVER_PATH = "yandexdriver.exe";
    private static final String YANDEX_BROWSER_PATH = "C:\\Users\\user\\AppData\\Local\\Yandex" +
            "\\YandexBrowser\\Application\\browser.exe";

    public static WebDriver createWebDriver() {
        String browser = System.getenv("browser");
        if (browser == null) {
            return createChromeDriver();
        }

        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver", YANDEX_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(YANDEX_BROWSER_PATH);
        return new ChromeDriver(options);
    }
}
