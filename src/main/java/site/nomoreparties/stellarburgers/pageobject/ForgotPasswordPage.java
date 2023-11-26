package site.nomoreparties.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static site.nomoreparties.stellarburgers.config.AppConfig.BASE_URL;

public class ForgotPasswordPage {
    WebDriver webDriver;

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(BASE_URL);
    }

    final By loginLink = By.xpath("//a[contains(@class, 'Auth_link__1fOlj') and contains(text(), 'Войти')]");

    public void clickLoginLink() {
        goToElement(loginLink);
        webDriver.findElement(loginLink).click();
    }

    void goToElement(By by) {
        WebElement element = webDriver.findElement(by);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
