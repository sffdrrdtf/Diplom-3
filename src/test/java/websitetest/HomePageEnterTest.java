package websitetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.checkwebsite.apiuser.CreateUser;
import ru.checkwebsite.apiuser.GeneratorRandom;
import ru.checkwebsite.apiuser.User;
import ru.checkwebsite.enter.HomePageEnter;
import ru.checkwebsite.registration.HomePageLogin;

import java.util.concurrent.TimeUnit;

import static ru.checkwebsite.designer.HomePageDesigner.MAIN_URL;

public class HomePageEnterTest {
    private WebDriver driver;
    CreateUser createUser;
    private User user;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        user = new User();
        driver.navigate().to(MAIN_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
    @Test
    @DisplayName("Вход через кнопку Войти в аккаунт")
    @Description("Проверка входа в аккаунт через кнопку Войти в аккаунт")
    public void enterInButtonAccountTest(){
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
    public void enterInPersonalAccountTest(){
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
    public void enterInAccountTest(){
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
    public void enterInButtonInFormRefreshPassTest(){
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
    @After
    public void teardown() {
        driver.quit();
        if (createUser != null) {
            ValidatableResponse response = User.requestCreateLogin(createUser);
            String bearerToken = response.extract().path("accessToken");
            if (bearerToken == null) {
                return;
            }
            user.userDelete(bearerToken);
        }
    }
}
