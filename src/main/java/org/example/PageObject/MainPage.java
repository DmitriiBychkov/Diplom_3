package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    //    Адрес страницы
    private final static String STELLAR_URL = "https://stellarburgers.nomoreparties.site/";
    //    Кнопка-Логотип "Stellar Burgers"
    private final static By LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.cssSelector(".//p[text()='Конструктор']");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.cssSelector(".//p[text()='Лента Заказов']");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.cssSelector(".//p[text()='Личный Кабинет']");
    //    Кнопка "Войти в аккаунт" на главной
    private final static By LOGIN_ACCOUNT_BUTTON = By.cssSelector(".//button[text()='Войти в аккаунт']");
    //    Кнопка вкладки "Соусы" в конструкторе
    private final static By SAUCES_BUTTON = By.cssSelector(".//span[text()='Соусы']");
    //    Кнопка вкладки "Начинки" в конструкторе
    private final static By FILLINGS_BUTTON = By.cssSelector(".//span[text()='Начинки']");
    //    Кнопка вкладки "Булки" в конструкторе
    private final static By BUNS_BUTTON = By.cssSelector(".//span[text()='Булки']");
    //    Меню ингредиентов в конструкторе на главной
    private final static By MENU = By.className("BurgerIngredients_ingredients__menuContainer__Xu3Mo");
    //    Последний ингредиент "Сыр с астероидной плесенью" в конструкторе на главной
    private final static By CHEESE = By.cssSelector(".//p[text()='Сыр с астероидной плесенью']");
    //    Кнопка вкладки ингредиентов в конструкторе не выделена
    private final static By NO_SELECT_BUTTON = By.cssSelector(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    //    Кнопка вкладки ингредиентов в конструкторе выделена
    private final static By SELECT_BUTTON = By.cssSelector(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    private final WebDriver driver;

    //конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод открытия тестовой страницы
    public MainPage open() {
        driver.get(STELLAR_URL);
        return this;
    }

    // метод клика на кнопку-логотип
    public MainPage clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Конструктор"
    public MainPage clickConstructorButton() {
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Лента Заказов"
    public MainPage clickOrdersButton() {
        driver.findElement(ORDERS_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Личный Кабинет"
    public MainPage clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Войти в аккаунт"
    public MainPage clickLoginAccountButton() {
        driver.findElement(LOGIN_ACCOUNT_BUTTON).click();
        return this;
    }

    // метод клика на раздел "Соусы"
    public MainPage clickSaucesButton() {
        driver.findElement(SAUCES_BUTTON).click();
        return this;
    }

    // метод клика на раздел "Начинки"
    public MainPage clickFillingsButton() {
        driver.findElement(FILLINGS_BUTTON).click();
        return this;
    }

    // метод клика на раздел "Булки"
    public MainPage clickBunsButton() {
        driver.findElement(BUNS_BUTTON).click();
        return this;
    }

    // метод ожидания загрузки страницы (появление наличия меню ингредиентов)
    public void waitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(MENU));
    }

    //метод поиска последнего ингредиента и прокрутки до него
    public void findQuestions() {
        WebElement element = driver.findElement(CHEESE);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод проверки наличия выделения кнопки вкладки ингредиентов
    public boolean isSelectButtonPresent() {
        return driver.findElement(SELECT_BUTTON).isDisplayed();
    }

    // метод проверки отсутствия выделения кнопки вкладки ингредиентов
    public boolean isNoSelectButtonPresent() {
        return driver.findElement(NO_SELECT_BUTTON).isDisplayed();
    }
//    // метод для получения текста ответа на вопрос "Сколько это стоит? И как оплатить?"
//    public String priceText() {
//        return driver.findElement(ANSWER_PRICE).getText();
//    }
}