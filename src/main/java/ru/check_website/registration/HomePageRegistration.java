package ru.check_website.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HomePageRegistration {
    private final By nameField = By.xpath("//label[text()='Имя']/../input");
    private final By emailField = By.xpath("//label[text()='Email']/../input");
    private final By passwordField = By.xpath("//label[text()='Пароль']/../input");
    private final By registrationBtn = By.xpath("//button[text()='Зарегистрироваться']");
    private final By errorPassword = By.xpath("//p[text()='Некорректный пароль']");

    private final WebDriver driver;

    public HomePageRegistration(WebDriver webDriver) {
        driver = webDriver;
    }

    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegistrationBtn() {
        driver.findElement(registrationBtn).click();
    }

    public void setRegistrationNewUser(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickRegistrationBtn();
    }

    public void checkRegistrationUserWithShortPassIsDisplayed() {
        assertThat("На странице Регистрации выводится сообщение о некорректном вводе пароля", true,
                equalTo(driver.findElement(errorPassword).isDisplayed()));
    }
}

