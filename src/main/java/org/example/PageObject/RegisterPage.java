package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    //    Адрес страницы
    private final static String STELLAR_REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";
    //    Кнопка-Логотип "Stellar Burgers"
    private final static By LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.cssSelector(".//p[text()='Конструктор']");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.cssSelector(".//p[text()='Лента Заказов']");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.cssSelector(".//p[text()='Личный Кабинет']");
    //    Поле "Имя"
    private final static By NAME_INPUT_FIELD = By.cssSelector(".//label[text()='Имя']");
    //    Поле "Email"
    private final static By EMAIL_INPUT_FIELD = By.cssSelector(".//label[text()='Email']");
    //    Поле "Пароль"
    private final static By PASSWORD_INPUT_FIELD = By.cssSelector(".//input[@name='Пароль']");
    //    Кнопка показа пароля
//    private final static By EYE_IN_FIELD = By.cssSelector("#root > div > main svg");
    //    Кнопка "Войти"
    private final static By ENTER_BUTTON = By.cssSelector(".//a[text()='Войти']");
    //    Кнопка "Зарегистрироваться"
    private final static By REGISTER_BUTTON = By.cssSelector(".//button[text()='Зарегистрироваться']");
    //    Ошибка "Некорректный пароль"
    private final static By PASSWORD_ERROR = By.cssSelector(".//p[text()='Некорректный пароль']");

    private final WebDriver driver;

    //конструктор класса
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод открытия тестовой страницы
    public RegisterPage open() {
        driver.get(STELLAR_REGISTER_URL);
        return this;
    }

    // метод клика на кнопку-логотип
    public RegisterPage clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Конструктор"
    public RegisterPage clickConstructorButton() {
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Лента Заказов"
    public RegisterPage clickOrdersButton() {
        driver.findElement(ORDERS_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Личный Кабинет"
    public RegisterPage clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
        return this;
    }

    // метод ожидания загрузки страницы (появление наличия кнопки "Зарегистрироваться")
    public void waitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
    }

    // метод клика на кнопку "Войти"
    public RegisterPage clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }

    // метод ввода значения в Поле "Имя"
    public RegisterPage inputName() {
        driver.findElement(NAME_INPUT_FIELD).click();
        driver.findElement(NAME_INPUT_FIELD).sendKeys("1Username1");
        return this;
    }

    // метод ввода значения в Поле "Email"
    public RegisterPage inputEmail() {
        driver.findElement(EMAIL_INPUT_FIELD).click();
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys("1test-data1@yandex.ru");
        return this;
    }

    // метод ввода некорректного значения в Поле "Пароль"
    public RegisterPage inputPasswordWithFiveChars() {
        driver.findElement(PASSWORD_INPUT_FIELD).click();
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys("12345");
        return this;
    }

    // метод ввода корректного значения в Поле "Пароль"
    public RegisterPage inputPasswordWithSixChars() {
        driver.findElement(PASSWORD_INPUT_FIELD).click();
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys("123456");
        return this;
    }

    //    метод проверки появления ошибки "Некорректный пароль"
    public boolean isPasswordErrorPresent() {
        return driver.findElement(PASSWORD_ERROR).isDisplayed();
    }

    //    метод клика на кнопку "Зарегистрироваться"
    public RegisterPage clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
        return this;
    }
}