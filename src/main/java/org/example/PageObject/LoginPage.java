package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //    Адрес страницы
    private final static String STELLAR_LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    //    Кнопка-Логотип "Stellar Burgers"
//    private final static By LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a svg");
    private final static By LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a > svg");
    //    Кнопка "Конструктор" в хедере
//    private final static By HEADER_CONSTRUCTOR_BUTTON = By.cssSelector(".//p[text()='Конструктор']");
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");
    //    Кнопка "Лента Заказов"
//    private final static By ORDERS_BUTTON = By.cssSelector(".//p[text()='Лента Заказов']");
    private final static By ORDERS_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[2]/a/p");
    //    Кнопка "Личный Кабинет"
//    private final static By ACCOUNT_BUTTON = By.cssSelector(".//p[text()='Личный Кабинет']");
    private final static By ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    //    Поле "Email"
//    private final static By EMAIL_INPUT_FIELD = By.cssSelector(".//input[@name='name']");
    private final static By EMAIL_INPUT_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    //    Поле "Пароль"
//    private final static By PASSWORD_INPUT_FIELD = By.cssSelector(".//input[@name='Пароль']");
    private final static By PASSWORD_INPUT_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    //    Кнопка показа пароля
//    private final static By EYE_IN_FIELD = By.cssSelector("#root > div > main svg");
    //    Кнопка "Войти"
//    private final static By ENTER_BUTTON = By.cssSelector(".//button[text()='Войти']");
    private final static By ENTER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    //    Кнопка "Зарегистрироваться"
//    private final static By REGISTER_BUTTON = By.cssSelector(".//a[text()='Зарегистрироваться']");
    private final static By REGISTER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
    //    Кнопка "Восстановить пароль"
//    private final static By FORGOT_BUTTON = By.cssSelector(".//a[text()='Восстановить пароль']");
    private final static By FORGOT_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a");
    //    Ошибка "Некорректный пароль"
//    private final static By PASSWORD_ERROR = By.cssSelector(".//p[text()='Некорректный пароль']");
    private final static By PASSWORD_ERROR = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/p");
    //    Заголовок "Вход"
//    private final static By HEADER_INPUT = By.cssSelector(".//h2[text()='Вход']");
    private final static By HEADER_INPUT = By.xpath("//*[@id=\"root\"]/div/main/div/h2");

    private final WebDriver driver;

    //конструктор класса
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод открытия тестовой страницы
    public LoginPage open() {
        driver.get(STELLAR_LOGIN_URL);
        return this;
    }

    // метод клика на кнопку-логотип
    public LoginPage clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Конструктор"
    public LoginPage clickConstructorButton() {
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Лента Заказов"
    public LoginPage clickOrdersButton() {
        driver.findElement(ORDERS_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Личный Кабинет"
    public LoginPage clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
        return this;
    }

    // метод ожидания загрузки страницы (появление наличия кнопки "Войти")
    public void waitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(ENTER_BUTTON));
    }

    // метод клика на кнопку "Войти"
    public LoginPage clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }

    // метод ввода значения в Поле "Email"
    public LoginPage inputEmail() {
        driver.findElement(EMAIL_INPUT_FIELD).click();
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys("1test-data1@yandex.ru");
        return this;
    }

    // метод ввода некорректного значения в Поле "Пароль"
    public LoginPage inputPasswordWithFiveChars() {
        driver.findElement(PASSWORD_INPUT_FIELD).click();
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys("12345");
        return this;
    }

    // метод ввода корректного значения в Поле "Пароль"
    public LoginPage inputPasswordWithSixChars() {
        driver.findElement(PASSWORD_INPUT_FIELD).click();
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys("123456");
        return this;
    }

    //    метод проверки появления ошибки "Некорректный пароль"
    public boolean isPasswordErrorPresent() {
        return driver.findElement(PASSWORD_ERROR).isDisplayed();
    }

    //    метод клика на кнопку "Зарегистрироваться"
    public LoginPage clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
        return this;
    }

    //    метод клика на кнопку "Восстановить пароль"
    public LoginPage clickForgotButton() {
        driver.findElement(FORGOT_BUTTON).click();
        return this;
    }

    // метод для получения текста заголовка страницы "Вход"
    public String headerInputText() {
        return driver.findElement(HEADER_INPUT).getText();
    }

    //    метод проверки появления окна "Вход"
    public boolean isLoginPageWindowOpen() {
        return driver.findElement(FORGOT_BUTTON).isDisplayed();
    }
}