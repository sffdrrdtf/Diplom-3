package websitetest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.checkwebsite.designer.HomePageDesigner;

import static ru.checkwebsite.designer.HomePageDesigner.MAIN_URL;

@RunWith(Parameterized.class)
public class HomePageDesignerTest {
    private WebDriver driver;
    private final String Ingredients;
    private final String checkDisplay;
    public HomePageDesignerTest( String Ingredients,  String checkDisplay)
    {
        this.Ingredients = Ingredients;
        this.checkDisplay = checkDisplay;
    }
    @Parameterized.Parameters
    public static Object[][] checkDesigner()
    {
        return new Object[][]
                {
                        {"//span[text()='Соусы']","//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[2]"},
                        {"//span[text()='Начинки']","//*[@id=\"root\"]/div/main/section[1]/div[2]/ul[3]"},
                };
    }
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(MAIN_URL);
    }
    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка, что работают переходы к разделам: Булки, Соусы, Начинки")
    public void designerIngredientsTest() {
        HomePageDesigner homePageDesigner = new HomePageDesigner(driver);
        homePageDesigner.scrollToBunsDesigner();
        homePageDesigner.checkMoveDesignerIsDisplayed();
        driver.findElement(By.xpath(Ingredients)).click();
        driver.findElement(By.xpath(checkDisplay)).isDisplayed();

    }
    @After
    public void teardown() {
        driver.quit();
    }
}
