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
import ru.checkwebsite.personal_account.HomePagePersonalAccount;
import ru.checkwebsite.registration.HomePageLogin;

import java.util.concurrent.TimeUnit;

import static ru.checkwebsite.designer.HomePageDesigner.MAIN_URL;

public class HomePagePersonalAccountTest {
    private WebDriver driver;
    CreateUser createUser;
    private User user;
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
    public void moveToDesignerAndLogoTest(){
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
    public void exitFromAccountTest(){
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
