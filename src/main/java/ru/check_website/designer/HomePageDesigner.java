package ru.check_website.designer;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageDesigner {
    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final By bunsDesigner = By.xpath("//span[text()='Булки']");
    private final By sauceDesigner = By.xpath("//span[text()='Соусы']");
    private final By fillingsDesigner = By.xpath("//span[text()='Начинки']");
    private final By fluorescentBun = By.xpath("//img[@alt='Флюоресцентная булка R2-D3']");
    private final By sauceSpice = By.xpath("//img[@alt='Соус Spicy-X']");
    private final By fillingForBun = By.xpath("//img[@alt='Говяжий метеорит (отбивная)']");
    private final WebDriver driver;

    public HomePageDesigner(WebDriver webDriver) {
        driver = webDriver;
    }

    public void scrollToBunsDesigner() {
        WebElement element = driver.findElement(bunsDesigner);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickBunsDesigner() {
        driver.findElement(bunsDesigner).click();
    }

    public void clickSauceDesigner() {
        driver.findElement(sauceDesigner).click();
    }

    public void clickFillingsDesigner() {
        driver.findElement(fillingsDesigner).click();
    }


    public void checkMoveDesignerBunsIsDisplayed() {
        assertThat("На главной странице в Конструкторе отображается раздел Булки ",
                true, equalTo(driver.findElement(fluorescentBun).isDisplayed()));
    }

    public void checkMoveDesignerSaucesIsDisplayed() {
        assertThat("На главной странице в Конструкторе отображается раздел Соусы ",
                true, equalTo(driver.findElement(sauceSpice).isDisplayed()));
    }

    public void checkMoveDesignerFillingsIsDisplayed() {
        assertThat("На главной странице в Конструкторе отображается раздел Начинки ",
                true, equalTo(driver.findElement(fillingForBun).isDisplayed()));
    }
}

