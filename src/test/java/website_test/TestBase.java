package website_test;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.check_website.api_user.CreateUser;
import ru.check_website.api_user.User;
import ru.check_website.designer.HomePageDesigner;
import ru.check_website.driver.WebDriverCreator;
import ru.check_website.enter.HomePageEnter;
import ru.check_website.personal_account.HomePagePersonalAccount;
import ru.check_website.registration.HomePageLogin;
import ru.check_website.registration.HomePageRegistration;

import java.util.concurrent.TimeUnit;

import static ru.check_website.designer.HomePageDesigner.MAIN_URL;

public class TestBase {
    public WebDriver driver;
    CreateUser createUser;
    User user = new User();
    HomePageDesigner designer = new HomePageDesigner(driver);
    HomePageEnter enter = new HomePageEnter(driver);
    HomePagePersonalAccount account = new HomePagePersonalAccount(driver);
    HomePageLogin login = new HomePageLogin(driver);
    HomePageRegistration registration = new HomePageRegistration(driver);

    @Before
    public void startUp() {
        driver = WebDriverCreator.createWebDriver();
        driver.manage().window().maximize();
        user = new User();
        driver.navigate().to(MAIN_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        designer = new HomePageDesigner(driver);
        enter = new HomePageEnter(driver);
        account = new HomePagePersonalAccount(driver);
        login = new HomePageLogin(driver);
        registration = new HomePageRegistration(driver);
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
