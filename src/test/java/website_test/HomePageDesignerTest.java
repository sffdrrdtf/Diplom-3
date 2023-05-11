package website_test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import ru.check_website.designer.HomePageDesigner;
import ru.check_website.enter.HomePageEnter;
import ru.check_website.personal_account.HomePagePersonalAccount;


public class HomePageDesignerTest extends TestBase {


    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка, что работает переход к разделу: Булки")
    public void designerBunsIngredientsTest() {
        HomePageDesigner homePageDesigner = new HomePageDesigner(driver);
        HomePageEnter homePageEnter = new HomePageEnter(driver);
        HomePagePersonalAccount constructor = new HomePagePersonalAccount(driver);
        homePageEnter.clickPersonalAccountBtn();
        constructor.clickConstructorBtn();
        homePageDesigner.clickSauceDesigner();
        homePageDesigner.clickBunsDesigner();
        homePageDesigner.scrollToBunsDesigner();
        homePageDesigner.checkMoveDesignerBunsIsDisplayed();
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка, что работает переход к разделу: Соусы")
    public void designerSaucesIngredientsTest() {
        HomePageDesigner homePageDesigner = new HomePageDesigner(driver);
        HomePageEnter homePageEnter = new HomePageEnter(driver);
        HomePagePersonalAccount constructor = new HomePagePersonalAccount(driver);
        homePageEnter.clickPersonalAccountBtn();
        constructor.clickConstructorBtn();
        homePageDesigner.clickSauceDesigner();
        homePageDesigner.checkMoveDesignerSaucesIsDisplayed();
    }

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка, что работает переход к разделу: Начинки")
    public void designerFillingsIngredientsTest() {
        HomePageDesigner homePageDesigner = new HomePageDesigner(driver);
        HomePageEnter homePageEnter = new HomePageEnter(driver);
        HomePagePersonalAccount constructor = new HomePagePersonalAccount(driver);
        homePageEnter.clickPersonalAccountBtn();
        constructor.clickConstructorBtn();
        homePageDesigner.clickFillingsDesigner();
        homePageDesigner.checkMoveDesignerFillingsIsDisplayed();
    }
}
