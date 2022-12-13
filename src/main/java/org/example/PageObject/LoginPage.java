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
    private final static By LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.cssSelector(".//p[text()='Конструктор']");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.cssSelector(".//p[text()='Лента Заказов']");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.cssSelector(".//p[text()='Личный Кабинет']");
    //    Поле "Email"
    private final static By EMAIL_INPUT_FIELD = By.cssSelector(".//input[@name='name']");
    //    Поле "Пароль"
    private final static By PASSWORD_INPUT_FIELD = By.cssSelector(".//input[@name='Пароль']");
    //    Кнопка показа пароля
//    private final static By EYE_IN_FIELD = By.cssSelector("#root > div > main svg");
    //    Кнопка "Войти"
    private final static By ENTER_BUTTON = By.cssSelector(".//button[text()='Войти']");
    //    Кнопка "Зарегистрироваться"
    private final static By REGISTER_BUTTON = By.cssSelector(".//a[text()='Зарегистрироваться']");
    //    Кнопка "Восстановить пароль"
    private final static By FORGOT_BUTTON = By.cssSelector(".//a[text()='Восстановить пароль']");
    //    Ошибка "Некорректный пароль"
    private final static By PASSWORD_ERROR = By.cssSelector(".//p[text()='Некорректный пароль']");

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
        new WebDriverWait(driver, Duration.ofSeconds(2))
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
}