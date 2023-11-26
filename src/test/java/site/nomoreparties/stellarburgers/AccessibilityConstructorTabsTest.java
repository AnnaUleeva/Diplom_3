package site.nomoreparties.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class AccessibilityConstructorTabsTest extends BaseTest {
    MainPage mainPage;

    @Before
    public void init() {
        mainPage = new MainPage(webDriver);
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Переход к разделу 'Соусы'")
    public void accessibilitySaucesTabTest() {
        clickSaucesTab();
        checkSaucesTabIsActive();
    }

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Переход к разделу 'Булки'")
    public void accessibilityBunsTabTest() {
        clickSaucesTab();
        clickBunsTab();
        checkBunsTabIsActive();
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Переход к разделу 'Начинки'")
    public void accessibilityIngredientsTabTest() {
        clickIngredientsTab();
        checkIngredientsTabIsActive();
    }

    @Step("Нажатие по табу 'Соусы'")
    void clickSaucesTab() {
        mainPage.clickSaucesTab();
    }

    @Step("Нажатие по табу 'Булки'")
    void clickBunsTab() {
        mainPage.clickBunsTab();
    }

    @Step("Нажатие по табу 'Начинки'")
    void clickIngredientsTab() {
        mainPage.clickIngredientsTab();
    }

    @Step("Проверка активности таба 'Соусы'")
    void checkSaucesTabIsActive() {
        assertTrue(mainPage.getSaucesTabClass().contains("tab_tab_type_current__2BEPc"));
    }

    @Step("Проверка активности таба 'Булки'")
    void checkBunsTabIsActive() {
        assertTrue(mainPage.getBunsTabClass().contains("tab_tab_type_current__2BEPc"));
    }

    @Step("Проверка активности таба 'Начинки'")
    void checkIngredientsTabIsActive() {
        assertTrue(mainPage.getIngredientsTabClass().contains("tab_tab_type_current__2BEPc"));
    }
}
