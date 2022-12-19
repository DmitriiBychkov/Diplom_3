package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    //    Адрес страницы
    private final static String STELLAR_FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    //    Кнопка-Логотип "Stellar Burgers"
    private final static By LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a > svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[2]/a/p");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    //    Поле "Email"
    private final static By EMAIL_INPUT_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    //    Кнопка "Войти"
    private final static By ENTER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");
    //    Кнопка "Восстановить"
    private final static By RECOVER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");

    private final WebDriver driver;

    //конструктор класса
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод открытия тестовой страницы
    public ForgotPasswordPage open() {
        driver.get(STELLAR_FORGOT_PASSWORD_URL);
        return this;
    }

    // метод клика на кнопку-логотип
    public ForgotPasswordPage clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Конструктор"
    public ForgotPasswordPage clickConstructorButton() {
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Лента Заказов"
    public ForgotPasswordPage clickOrdersButton() {
        driver.findElement(ORDERS_BUTTON).click();
        return this;
    }

    // метод клика на кнопку "Личный Кабинет"
    public ForgotPasswordPage clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
        return this;
    }

    // метод ожидания загрузки страницы (появление наличия кнопки "Восстановить")
    public void waitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(RECOVER_BUTTON));
    }

    // метод клика на кнопку "Войти"
    public ForgotPasswordPage clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }

    // метод ввода значения в Поле "Email"
    public ForgotPasswordPage inputEmail() {
        driver.findElement(EMAIL_INPUT_FIELD).click();
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys("1test-data1@yandex.ru");
        return this;
    }

    //    метод клика на кнопку "Восстановить"
    public ForgotPasswordPage clickRegisterButton() {
        driver.findElement(RECOVER_BUTTON).click();
        return this;
    }
}