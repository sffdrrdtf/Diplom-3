package ru.checkwebsite.personal_account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HomePagePersonalAccount {
    private final WebDriver driver;
    private final By constructorBtn = By.xpath("//p[text()='Конструктор']");
    private final By textPackingBurger = By.xpath("//h1[text()= 'Соберите бургер']");
    private final By listOrders = By.xpath("//p[text()= 'Лента Заказов']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final  By exit = By.xpath("//button[text()='Выход']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By formEnter = By.xpath("//form[@class='Auth_form__3qKeq mb-20']");
    public HomePagePersonalAccount(WebDriver driver) {
        this.driver = driver;
    }
    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }
    public void clickExit(){
        driver.findElement(exit).click();
    }
    public void clickConstructorBtn(){
        driver.findElement(constructorBtn).click();
    }
    public void clickLogo(){
        driver.findElement(logo).click();
    }
    public void checkFormEnterIsDisplayed() {
        assertThat("При переходе по клику  на «Личный кабинет» отображается сообщение Вход для авторизации",
                true,equalTo(driver.findElement(formEnter).isDisplayed()));
    }
    public void checkTextPackingBurgerIsDisplayed() {
        assertThat("При переходе по клику из Личного кабинета на логотип Stellar Burgers, отображается сообщение Соберите бургер",
                true,equalTo(driver.findElement(textPackingBurger).isDisplayed()));
    }
    public void checkListOrdersIsDisplayed() {
        assertThat("При переходе по клику из Личного кабинета на Конструкторы, отображается сообщение Лента заказов",
                true,equalTo(driver.findElement(listOrders).isDisplayed()));
    }
}
