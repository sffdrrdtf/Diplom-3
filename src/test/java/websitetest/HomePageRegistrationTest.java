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
import ru.checkwebsite.registration.*;

import java.util.concurrent.TimeUnit;

import static ru.checkwebsite.designer.HomePageDesigner.MAIN_URL;


public class HomePageRegistrationTest {
    CreateUser createUser;
     private User user;
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        user = new User();
        driver.navigate().to(MAIN_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

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



