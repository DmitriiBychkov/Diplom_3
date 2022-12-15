package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    //    Адрес страницы
    private final static String STELLAR_URL = "https://stellarburgers.nomoreparties.site/";
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    //    Кнопка "Войти в аккаунт" на главной
    private final static By LOGIN_ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button");
    //    Кнопка вкладки "Соусы" в конструкторе
    private final static By SAUCES_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span");
    //    Кнопка вкладки "Начинки" в конструкторе
    private final static By FILLINGS_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]/span");
    //    Кнопка вкладки "Булки" в конструкторе
    private final static By BUNS_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]/span");
    //    Меню ингредиентов в конструкторе на главной
    private final static By MENU = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]");
    //    Кнопка "Оформить заказ"
    private final static By SEND_ORDER = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button");

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
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(MENU));
    }

    //     метод проверки наличия кнопки "Оформить заказ"
    public boolean isSendOrderButtonPresent() {
        return driver.findElement(SEND_ORDER).isDisplayed();
    }

    // метод ожидания загрузки страницы (появление наличия меню ингредиентов)
    public void waitClickSauces() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(SAUCES_BUTTON));
    }

    public void waitClickBuns() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(BUNS_BUTTON));
    }

    public void waitClickFillings() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(FILLINGS_BUTTON));
    }
}