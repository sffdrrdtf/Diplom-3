package website_test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


public class HomePageDesignerTest extends TestBase {


    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка, что работает переход к разделу: Булки")
    public void designerBunsIngredientsTest() {
        enter.clickPersonalAccountBtn();
        account.clickConstructorBtn();
        designer.clickSauceDesigner();
        designer.clickBunsDesigner();
        designer.checkMoveDesignerBunsIsDisplayed();

    }


    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка, что работает переход к разделу: Соусы")
    public void designerSaucesIngredientsTest() {
        enter.clickPersonalAccountBtn();
        account.clickConstructorBtn();
        designer.clickSauceDesigner();
        designer.checkMoveDesignerSaucesIsDisplayed();
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка, что работает переход к разделу: Начинки")
    public void designerFillingsIngredientsTest() {
        enter.clickPersonalAccountBtn();
        account.clickConstructorBtn();
        designer.clickFillingsDesigner();
        designer.checkMoveDesignerFillingsIsDisplayed();
    }
}
