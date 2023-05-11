package ru.check_website.enter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HomePageEnter {
    private final WebDriver driver;
    private final By singInBtn = By.xpath(".//a[text()='Войти']");
    private final By forgotPasswordButton = By.xpath("//a[text()= 'Восстановить пароль']");
    private final By personalAccountBtn = By.xpath("//p[text()='Личный Кабинет']");
    private final By buttonEnter = By.xpath("//button[text()='Войти в аккаунт']");
    private final By createOrderBtn = By.xpath("//button[text()='Оформить заказ']");

    public HomePageEnter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    public void clickButtonEnter() {
        driver.findElement(buttonEnter).click();
    }

    public void clickPersonalAccountBtn() {
        driver.findElement(personalAccountBtn).click();
    }

    public void clickSingInBtn() {
        driver.findElement(singInBtn).click();
    }

    public void scrollForgotPassword() {
        WebElement element = driver.findElement(forgotPasswordButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void checkCreateOrderBtnIsDisplayed() {
        assertThat("В профиле отображается кнопка Оформить заказ", true,
                equalTo(driver.findElement(createOrderBtn).isDisplayed()));
    }
}
