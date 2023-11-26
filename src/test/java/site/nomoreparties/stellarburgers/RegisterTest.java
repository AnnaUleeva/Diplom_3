package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.helper.UserHelper;
import site.nomoreparties.stellarburgers.pageobject.LoginPage;
import site.nomoreparties.stellarburgers.pageobject.MainPage;
import site.nomoreparties.stellarburgers.pageobject.RegisterPage;

import static org.junit.Assert.assertEquals;

public class RegisterTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    UserHelper userHelper;

    @Before
    public void init() {
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        userHelper = new UserHelper();
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Успешная регистрация")
    public void registerUserTest() {
        clickUserAccountLinkInHeader();
        clickRegisterLink();
        appendToNameInput();
        appendToEmailInput();
        appendToPasswordInput();
        clickRegisterButton();
        checkScreenTitle();
        reset();
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Ошибка для некорректного пароля")
    public void registerUserWithInvalidPasswordTest() {
        clickUserAccountLinkInHeader();
        clickRegisterLink();
        appendToNameInput();
        appendToEmailInput();
        appendInvalidValueToPasswordInput();
        clickRegisterButton();
        checkPasswordError();
    }

    void reset() {
        userHelper.login();
        userHelper.delete();
    }

    @Step("Переход по ссылке 'Личный кабинет' в хедере")
    void clickUserAccountLinkInHeader() {
        mainPage.clickUserAccountLinkInHeader();
    }

    @Step("Нажатие ссылки 'Зарегистрироваться' на странице входа")
    void clickRegisterLink() {
        loginPage.clickRegisterLink();
    }

    @Step("Добавление имени в поле ввода")
    void appendToNameInput() {
        registerPage.appendToNameInput(userHelper.getName());
    }

    @Step("Добавление email в поле ввода")
    void appendToEmailInput() {
        registerPage.appendToEmailInput(userHelper.getEmail());
    }

    @Step("Добавление пароля в поле ввода")
    void appendToPasswordInput() {
        registerPage.appendToPasswordInput(userHelper.getPassword());
    }

    @Step("Добавление невалидного пароля в поле ввода")
    void appendInvalidValueToPasswordInput() {
        registerPage.appendToPasswordInput("12345");
    }

    @Step("Нажатие кнопки регистрации")
    void clickRegisterButton() {
        registerPage.clickRegisterButton();
    }

    @Step("Проверка на странице заголовка 'Вход'")
    void checkScreenTitle() {
        loginPage.checkScreenTitle();
    }

    @Step("Проверка оштбки в поле пароля")
    void checkPasswordError() {
        assertEquals("Некорректный пароль", registerPage.checkPasswordError());
    }
}
