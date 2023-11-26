package site.nomoreparties.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static site.nomoreparties.stellarburgers.config.AppConfig.BASE_URL;


public class RegisterPage {
    WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(BASE_URL);
    }

    // final By nameInput = By.cssSelector(".Auth_form__3qKeq .Auth_fieldset__1QzWN:nth-child(1) .input__textfield");
    // final By nameInput = By.xpath("//fieldset[contains(@class, 'Auth_fieldset__1QzWN') and position()=1]//input[contains(@class, 'input__textfield')]");
    final By nameInput = By.xpath("//fieldset[contains(@class, 'Auth_fieldset__1QzWN') and .//label[contains(text(), 'Имя')]]//input[contains(@class, 'input__textfield')]");
    // final By emailInput = By.cssSelector(".Auth_form__3qKeq .Auth_fieldset__1QzWN:nth-child(2) .input__textfield");
    // final By emailInput = By.xpath("//fieldset[contains(@class, 'Auth_fieldset__1QzWN') and position()=2]//input[contains(@class, 'input__textfield')]");
    final By emailInput = By.xpath("//fieldset[contains(@class, 'Auth_fieldset__1QzWN') and .//label[contains(text(), 'Email')]]//input[contains(@class, 'input__textfield')]");
    // final By passwordInput = By.cssSelector(".Auth_form__3qKeq .Auth_fieldset__1QzWN:nth-child(3) .input__textfield");
    // final By passwordInput = By.xpath("//fieldset[contains(@class, 'Auth_fieldset__1QzWN') and position()=3]//input[contains(@class, 'input__textfield')]");
    final By passwordInput = By.xpath("//fieldset[contains(@class, 'Auth_fieldset__1QzWN') and .//label[contains(text(), 'Пароль')]]//input[contains(@class, 'input__textfield')]");
    final By registerButton = By.xpath("//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    final By passwordError = By.cssSelector(".Auth_form__3qKeq .Auth_fieldset__1QzWN:nth-child(3) .input__error");
    final By loginLink = By.xpath("//a[contains(@class, 'Auth_link__1fOlj') and contains(text(), 'Войти')]");


    public void clickRegisterButton() {
        goToElement(registerButton);
        webDriver.findElement(registerButton).click();
    }

    public String checkPasswordError() {
        return webDriver.findElement(passwordError).getText();
    }


    public void appendToNameInput(String name) {
        webDriver.findElement(nameInput).sendKeys(name);
    }

    public void appendToEmailInput(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    public void appendToPasswordInput(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginLink() {
        goToElement(loginLink);
        webDriver.findElement(loginLink).click();
    }

    void goToElement(By by) {
        WebElement element = webDriver.findElement(by);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
