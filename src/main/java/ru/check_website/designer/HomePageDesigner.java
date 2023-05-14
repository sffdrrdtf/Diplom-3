package ru.check_website.designer;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageDesigner {
    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    private final By bunsDesigner = By.xpath("//span[text()='Булки']");
    private final By sauceDesigner = By.xpath("//span[text()='Соусы']");
    private final By fillingsDesigner = By.xpath("//span[text()='Начинки']");
    private final By buns = By.xpath("//span[text()='Булки']/parent::div[contains(@class,'current')]");
    private final By sauce = By.xpath("//span[text()='Соусы']/parent::div[contains(@class,'current')]");
    private final By filling = By.xpath("//span[text()='Начинки']/parent::div[contains(@class,'current')]");
    private final By fluorescentBun = By.xpath("//img[@alt='Флюоресцентная булка R2-D3']");
    private final By sauceSpice = By.xpath("//img[@alt='Соус Spicy-X']");
    private final By fillingForBun = By.xpath("//img[@alt='Говяжий метеорит (отбивная)']");
    private final WebDriver driver;

    public HomePageDesigner(WebDriver webDriver) {
        driver = webDriver;
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
                true, equalTo(driver.findElement(buns).isDisplayed()));
        assertThat("В Конструкторе в разделе Соусы, отображается элемент: Флюоресцентная булка R2-D3",
                true, equalTo(driver.findElement(fluorescentBun).isDisplayed()));
    }

    public void checkMoveDesignerSaucesIsDisplayed() {
        assertThat("На главной странице в Конструкторе отображается раздел Соусы ",
                true, equalTo(driver.findElement(sauce).isDisplayed()));
        assertThat("В Конструкторе в разделе Соусы, отображается элемент: Соус Spicy-X",
                true, equalTo(driver.findElement(sauceSpice).isDisplayed()));
    }

    public void checkMoveDesignerFillingsIsDisplayed() {
        assertThat("На главной странице в Конструкторе отображается раздел Начинки ",
                true, equalTo(driver.findElement(filling).isDisplayed()));
        assertThat("В Конструкторе в разделе Соусы, отображается элемент: Говяжий метеорит (отбивная)",
                true, equalTo(driver.findElement(fillingForBun).isDisplayed()));
    }
}

