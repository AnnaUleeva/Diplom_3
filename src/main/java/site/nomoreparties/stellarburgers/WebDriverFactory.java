package site.nomoreparties.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;;

public class WebDriverFactory {
    public static WebDriver get(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                ChromeOptions yandexOptions = new ChromeOptions();
                WebDriver yandexDriver = new ChromeDriver(yandexOptions);
                yandexDriver.get("https://yandex.ru");
                return yandexDriver;
            default:
                throw new RuntimeException("Browser is not detected");
        }
    }
}
