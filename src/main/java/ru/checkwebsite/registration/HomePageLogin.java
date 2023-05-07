package ru.checkwebsite.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HomePageLogin {
    private final By personalAccountBtn = By.xpath("//p[text()='Личный Кабинет']");
    private final By registrationBtn = By.xpath("//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    private final By enterBtn = By.xpath("//button[text()='Войти']");
    private final By emailField = By.xpath("//label[text()='Email']/../input");
    private final By passwordField = By.xpath("//label[text()='Пароль']/../input");
    private final By saveBtn = By.xpath("//button[text()='Сохранить']");

    private final WebDriver driver;

    public HomePageLogin(WebDriver webDriver) {
        driver = webDriver;
    }

    public void clickEnterBtn() {
        driver.findElement(enterBtn).click();
    }

    public void clickRegistrationBtn() {
        driver.findElement(registrationBtn).click();
    }

    public void clickPersonalAccountBtn() {
        driver.findElement(personalAccountBtn).click();
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setUserAccount(String email, String password) {
        clickPersonalAccountBtn();
        setEmailField(email);
        setPasswordField(password);
        clickEnterBtn();
    }
    public void checkSaveBtnIsDisplayed() {
        assertThat("В профиле отображается кнопка Сохранить", true,
                equalTo(driver.findElement(saveBtn).isDisplayed()));
    }
}
