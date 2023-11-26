package site.nomoreparties.stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static site.nomoreparties.stellarburgers.config.AppConfig.BASE_URL;

public class MainPage {
    WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(BASE_URL);
    }

    final By userAccountLinkInHeader = By.xpath("//a[@class = 'AppHeader_header__link__3D_hX' and @href='/account']");
    final By constructorLinkInHeader = By.xpath("//a[@class = 'AppHeader_header__link__3D_hX' and @href='/']");
    final By loginButtonInMainPage = By.xpath("//a[@class = 'AppHeader_header__link__3D_hX' and @href='/account']");
    final By createOrderButton = By.xpath("//button[contains(@class, 'button_button__33qZ0') and contains(text(), 'Оформить заказ')]");
    final By bunsTab = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[contains(text(), 'Булки')]]");
    final By saucesTab = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[contains(text(), 'Соусы')]]");
    final By ingredientsTab = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[contains(text(), 'Начинки')]]");


    public void clickUserAccountLinkInHeader() {
        webDriver.findElement(userAccountLinkInHeader).click();
    }

    public void clickConstructorLinkInHeader() {
        webDriver.findElement(constructorLinkInHeader).click();
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButtonInMainPage).click();
    }

    public void clickBunsTab() {
        webDriver.findElement(bunsTab).click();
    }

    public void clickSaucesTab() {
        webDriver.findElement(saucesTab).click();
    }

    public void clickIngredientsTab() {
        webDriver.findElement(ingredientsTab).click();
    }

    public void checkCreateOrderButton() {
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        webDriver.findElement(createOrderButton).isDisplayed();
    }

    public String getBunsTabClass() {
        return webDriver.findElement(bunsTab).getAttribute("class");
    }

    public String getSaucesTabClass() {
        return webDriver.findElement(saucesTab).getAttribute("class");
    }

    public String getIngredientsTabClass() {
        return webDriver.findElement(ingredientsTab).getAttribute("class");
    }
}
