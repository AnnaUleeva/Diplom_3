package site.nomoreparties.stellarburgers;

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
    public void accessibilitySaucesTabTest() {
        mainPage.clickSaucesTab();
        assertTrue(mainPage.getSaucesTabClass().contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    public void accessibilityBunsTabTest() {
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        assertTrue(mainPage.getBunsTabClass().contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    public void accessibilityIngredientsTabTest() {
        mainPage.clickIngredientsTab();
        assertTrue(mainPage.getIngredientsTabClass().contains("tab_tab_type_current__2BEPc"));
    }
}
