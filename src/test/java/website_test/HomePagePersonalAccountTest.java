package website_test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.check_website.api_user.GeneratorRandom;
import ru.check_website.enter.HomePageEnter;
import ru.check_website.personal_account.HomePagePersonalAccount;
import ru.check_website.registration.HomePageLogin;


public class HomePagePersonalAccountTest extends TestBase {


    @Test
    @DisplayName("Переход в личный кабинет ")
    @Description("Проверка перехода по клику на «Личный кабинет»")
    public void moveToPersonalAccountTest() {
        HomePagePersonalAccount homePagePersonalAccount = new HomePagePersonalAccount(driver);
        homePagePersonalAccount.clickPersonalAccountButton();
        homePagePersonalAccount.checkFormEnterIsDisplayed();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор и клип по логотипу Stellar Burgers")
    @Description("Проверка перехода по клику на «Конструктор» и на логотип Stellar Burgers")
    public void moveToDesignerAndLogoTest() {
        HomePagePersonalAccount homePagePersonalAccount = new HomePagePersonalAccount(driver);
        homePagePersonalAccount.clickPersonalAccountButton();
        homePagePersonalAccount.clickLogo();
        homePagePersonalAccount.checkTextPackingBurgerIsDisplayed();
        homePagePersonalAccount.clickPersonalAccountButton();
        homePagePersonalAccount.clickConstructorBtn();
        homePagePersonalAccount.checkListOrdersIsDisplayed();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выхода из аккаунта в личном кабинете после успешной регистрации")
    public void exitFromAccountTest() {
        HomePageEnter homePage = new HomePageEnter(driver);
        HomePageLogin loginPage = new HomePageLogin(driver);
        HomePagePersonalAccount account = new HomePagePersonalAccount(driver);
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        homePage.clickPersonalAccountBtn();
        loginPage.setUserAccount(createUser.getEmail(), createUser.getPassword());
        homePage.clickPersonalAccountBtn();
        account.clickExit();
        account.checkFormEnterIsDisplayed();
    }
}
