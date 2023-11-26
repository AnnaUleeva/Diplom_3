package site.nomoreparties.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static site.nomoreparties.stellarburgers.config.AppConfig.BASE_URL;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(BASE_URL);
    }

    final By registerLink = By.xpath("//a[contains(@class, 'Auth_link__1fOlj') and contains(text(), 'Зарегистрироваться')]");
    final By forgotPasswordLink = By.xpath("//a[contains(@class, 'Auth_link__1fOlj') and contains(text(), 'Восстановить пароль')]");
    final By emailInput = By.xpath("//fieldset[contains(@class, 'Auth_fieldset__1QzWN') and .//label[contains(text(), 'Email')]]//input[contains(@class, 'input__textfield')]");
    final By passwordInput = By.xpath("//fieldset[contains(@class, 'Auth_fieldset__1QzWN') and .//label[contains(text(), 'Пароль')]]//input[contains(@class, 'input__textfield')]");
    final By loginButton = By.xpath("//button[contains(@class, 'button_button__33qZ0') and contains(text(), 'Войти')]");
    final By screenTitle = By.xpath(".//h2[contains(text(),'Вход')]");

    public void clickRegisterLink() {
        goToElement(registerLink);
        webDriver.findElement(registerLink).click();
    }

    public void clickForgotPasswordLink() {
        goToElement(forgotPasswordLink);
        webDriver.findElement(forgotPasswordLink).click();
    }

    public void appendToEmailInput(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    public void appendToPasswordInput(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        goToElement(loginButton);
        webDriver.findElement(loginButton).click();
    }

    public void checkScreenTitle() {
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(screenTitle));
        webDriver.findElement(screenTitle).isDisplayed();
    }

    void goToElement(By by) {
        WebElement element = webDriver.findElement(by);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
