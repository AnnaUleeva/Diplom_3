package site.nomoreparties.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static site.nomoreparties.stellarburgers.config.AppConfig.BASE_URL;

public class UserAccountPage {
    WebDriver webDriver;

    public UserAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(BASE_URL);
    }

    final By profileLink = By.xpath("//a[contains(@class, 'Account_link__2ETsJ') and contains(text(), 'Профиль')]");
    final By logoutButton = By.xpath("//button[contains(@class, 'Account_button__14Yp3') and contains(text(), 'Выход')]");

    public void clickLogoutButton() {
        webDriver.findElement(logoutButton).click();
    }
    public void checkExistsProfileLink() {
        webDriver.findElement(profileLink).isDisplayed();
    }
}
