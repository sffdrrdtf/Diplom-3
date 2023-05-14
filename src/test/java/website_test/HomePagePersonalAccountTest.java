package website_test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.check_website.api_user.GeneratorRandom;


public class HomePagePersonalAccountTest extends TestBase {


    @Test
    @DisplayName("Переход в личный кабинет ")
    @Description("Проверка перехода по клику на «Личный кабинет»")
    public void moveToPersonalAccountTest() {
        account.clickPersonalAccountButton();
        account.checkFormEnterIsDisplayed();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор и клип по логотипу Stellar Burgers")
    @Description("Проверка перехода по клику на «Конструктор» и на логотип Stellar Burgers")
    public void moveToDesignerAndLogoTest() {
        account.clickPersonalAccountButton();
        account.clickLogo();
        account.checkTextPackingBurgerIsDisplayed();
        account.clickPersonalAccountButton();
        account.clickConstructorBtn();
        account.checkListOrdersIsDisplayed();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выхода из аккаунта в личном кабинете после успешной регистрации")
    public void exitFromAccountTest() {
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        enter.clickPersonalAccountBtn();
        login.setUserAccount(createUser.getEmail(), createUser.getPassword());
        enter.clickPersonalAccountBtn();
        account.clickExit();
        account.checkFormEnterIsDisplayed();
    }
}
