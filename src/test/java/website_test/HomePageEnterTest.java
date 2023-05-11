package website_test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.check_website.api_user.GeneratorRandom;
import ru.check_website.enter.HomePageEnter;
import ru.check_website.registration.HomePageLogin;

public class HomePageEnterTest extends TestBase {

    @Test
    @DisplayName("Вход через кнопку Войти в аккаунт")
    @Description("Проверка входа в аккаунт через кнопку Войти в аккаунт")
    public void enterInButtonAccountTest() {
        HomePageEnter homePage = new HomePageEnter(driver);
        HomePageLogin loginPage = new HomePageLogin(driver);
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        homePage.clickButtonEnter();
        loginPage.setUserAccount(createUser.getEmail(), createUser.getPassword());
        homePage.checkCreateOrderBtnIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    @Description("Проверка входа в аккаунт через кнопку Личный кабинет")
    public void enterInPersonalAccountTest() {
        HomePageEnter homePage = new HomePageEnter(driver);
        HomePageLogin loginPage = new HomePageLogin(driver);
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        homePage.clickPersonalAccountBtn();
        loginPage.setUserAccount(createUser.getEmail(), createUser.getPassword());
        homePage.checkCreateOrderBtnIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверяется вход через кнопку в форме регистрации")
    public void enterInAccountTest() {
        HomePageEnter homePage = new HomePageEnter(driver);
        HomePageLogin loginPage = new HomePageLogin(driver);
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        homePage.clickPersonalAccountBtn();
        loginPage.setUserAccount(createUser.getEmail(), createUser.getPassword());
        homePage.checkCreateOrderBtnIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяется вход через кнопку в форме восстановления пароля")
    public void enterInButtonInFormRefreshPassTest() {
        HomePageEnter homePage = new HomePageEnter(driver);
        HomePageLogin loginPage = new HomePageLogin(driver);
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        homePage.clickPersonalAccountBtn();
        homePage.scrollForgotPassword();
        homePage.clickForgotPasswordButton();
        homePage.clickSingInBtn();
        loginPage.setUserAccount(createUser.getEmail(), createUser.getPassword());
        homePage.checkCreateOrderBtnIsDisplayed();
    }
}
