package ru.checkwebsite.designer;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageDesigner {
    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final By bunsDesigner = By.className("BurgerIngredients_ingredients__list__2A-mT");

    private final WebDriver driver;

    public HomePageDesigner(WebDriver webDriver) {
        driver = webDriver;
    }

    public void scrollToBunsDesigner(){
        WebElement element = driver.findElement(bunsDesigner);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void checkMoveDesignerIsDisplayed(){
        assertThat("На главной странице в Конструкторе отображается раздел Булки ",
                true,equalTo(driver.findElement(bunsDesigner).isDisplayed()));
    }
}

