package website_test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.check_website.api_user.GeneratorRandom;

public class HomePageEnterTest extends TestBase {

    @Test
    @DisplayName("Вход через кнопку Войти в аккаунт")
    @Description("Проверка входа в аккаунт через кнопку Войти в аккаунт")
    public void enterInButtonAccountTest() {
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        enter.clickButtonEnter();
        login.setUserAccount(createUser.getEmail(), createUser.getPassword());
        enter.checkCreateOrderBtnIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    @Description("Проверка входа в аккаунт через кнопку Личный кабинет")
    public void enterInPersonalAccountTest() {
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        enter.clickPersonalAccountBtn();
        login.setUserAccount(createUser.getEmail(), createUser.getPassword());
        enter.checkCreateOrderBtnIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверяется вход через кнопку в форме регистрации")
    public void enterInAccountTest() {
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        enter.clickPersonalAccountBtn();
        login.setUserAccount(createUser.getEmail(), createUser.getPassword());
        enter.checkCreateOrderBtnIsDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяется вход через кнопку в форме восстановления пароля")
    public void enterInButtonInFormRefreshPassTest() {
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        enter.clickPersonalAccountBtn();
        enter.scrollForgotPassword();
        enter.clickForgotPasswordButton();
        enter.clickSingInBtn();
        login.setUserAccount(createUser.getEmail(), createUser.getPassword());
        enter.checkCreateOrderBtnIsDisplayed();
    }
}
