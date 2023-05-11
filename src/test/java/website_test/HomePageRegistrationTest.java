package website_test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import ru.check_website.api_user.GeneratorRandom;
import ru.check_website.enter.HomePageEnter;
import ru.check_website.registration.*;


public class HomePageRegistrationTest extends TestBase {

    @Test
    @DisplayName("Регистрация пользователя через сайт")
    @Description("Проверка успешной регистрации пользователя " +
            "(минимальное количество символов для успешной регистрации 6)")
    public void registrationUserTest() {
        HomePageEnter homePage = new HomePageEnter(driver);
        HomePageLogin loginPage = new HomePageLogin(driver);
        HomePageRegistration registrationPage = new HomePageRegistration(driver);
        createUser = new GeneratorRandom().getCreateUser();
        homePage.clickPersonalAccountBtn();
        loginPage.clickRegistrationBtn();
        registrationPage.setRegistrationNewUser(createUser.getName(), createUser.getEmail(), createUser.getPassword());
        loginPage.setUserAccount(createUser.getEmail(), createUser.getPassword());
        homePage.clickPersonalAccountBtn();
        loginPage.checkSaveBtnIsDisplayed();
    }

    @Test
    @DisplayName("Регистрация пользователя через API")
    @Description("Проверка успешной регистрации пользователя")
    public void registrationUserWithApiTest() {
        HomePageEnter homePage = new HomePageEnter(driver);
        HomePageLogin loginPage = new HomePageLogin(driver);
        createUser = new GeneratorRandom().getCreateUser();
        user.requestCreateUser(createUser);
        homePage.clickPersonalAccountBtn();
        loginPage.setUserAccount(createUser.getEmail(), createUser.getPassword());
        homePage.clickPersonalAccountBtn();
    }

    @Test
    @DisplayName("Регистрация пользователя через сайт")
    @Description("Проверка что нельзя зарегистрпровать пользователя с коротким паролем(5 символов)")
    public void registrationUserWithShortPassTest() {
        HomePageEnter homePage = new HomePageEnter(driver);
        HomePageLogin loginPage = new HomePageLogin(driver);
        HomePageRegistration registrationPage = new HomePageRegistration(driver);
        createUser = new GeneratorRandom().getCreateUserWithShortPass();
        homePage.clickPersonalAccountBtn();
        loginPage.clickRegistrationBtn();
        registrationPage.setRegistrationNewUser(createUser.getName(), createUser.getEmail(), createUser.getPassword());
        registrationPage.checkRegistrationUserWithShortPassIsDisplayed();
    }


}



