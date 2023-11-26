package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.helper.UserHelper;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.MainPage;
import site.nomoreparties.stellarburgers.pageobject.UserAccountPage;

public class AccessibilityUserAccountTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    UserAccountPage userAccountPage;
    UserHelper userHelper;

    @Before
    public void init() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        userAccountPage = new UserAccountPage(webDriver);
        userHelper = new UserHelper();
        userHelper.create();
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Переход в личный кабинет")
    public void accessibilityUserAccountTest() {
        clickUserAccountLinkInHeader();
        appendToEmailInput();
        appendToPasswordInput();
        clickLoginButtonInLoginPage();
        clickUserAccountLinkInHeader();
        checkExistsProfileLink();
    }

    @After
    public void reset() {
        userHelper.delete();
    }

    @Step("Переход по ссылке 'Личный кабинет' в хедере")
    void clickUserAccountLinkInHeader() {
        mainPage.clickUserAccountLinkInHeader();
    }

    @Step("Добавление email в поле ввода")
    void appendToEmailInput() {
        loginPage.appendToEmailInput(userHelper.getEmail());
    }

    @Step("Добавление пароля в поле ввода")
    void appendToPasswordInput() {
        loginPage.appendToPasswordInput(userHelper.getPassword());
    }

    @Step("Нажатие кнопки входа")
    void clickLoginButtonInLoginPage() {
        loginPage.clickLoginButton();
    }

    @Step("Проверка наличия ссылки 'Профиль'")
    void checkExistsProfileLink() {
        userAccountPage.checkExistsProfileLink();
    }
}
