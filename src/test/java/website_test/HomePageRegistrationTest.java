package website_test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.check_website.api_user.GeneratorRandom;


public class HomePageRegistrationTest extends TestBase {

    @Test
    @DisplayName("Регистрация пользователя через сайт")
    @Description("Проверка успешной регистрации пользователя " +
            "(минимальное количество символов для успешной регистрации 6)")
    public void registrationUserTest() {
        createUser = new GeneratorRandom().getCreateUser();
        enter.clickPersonalAccountBtn();
        login.clickRegistrationBtn();
        registration.setRegistrationNewUser(createUser.getName(), createUser.getEmail(), createUser.getPassword());
        login.setUserAccount(createUser.getEmail(), createUser.getPassword());
        enter.clickPersonalAccountBtn();
        login.checkSaveBtnIsDisplayed();
    }

    @Test
    @DisplayName("Регистрация пользователя через API")
    @Description("Проверка успешной регистрации пользователя")
    public void registrationUserWithApiTest() {
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        enter.clickPersonalAccountBtn();
        login.setUserAccount(createUser.getEmail(), createUser.getPassword());
        enter.clickPersonalAccountBtn();
    }

    @Test
    @DisplayName("Регистрация пользователя через сайт")
    @Description("Проверка что нельзя зарегистрпровать пользователя с коротким паролем(5 символов)")
    public void registrationUserWithShortPassTest() {
        createUser = new GeneratorRandom().getCreateUserWithShortPass();
        enter.clickPersonalAccountBtn();
        login.clickRegistrationBtn();
        registration.setRegistrationNewUser(createUser.getName(), createUser.getEmail(), createUser.getPassword());
        registration.checkRegistrationUserWithShortPassIsDisplayed();
    }

}



