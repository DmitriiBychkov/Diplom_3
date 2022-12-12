package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    //    Адрес сайта
    private final static String STELLAR_URL = "https://stellarburgers.nomoreparties.site/";
    //    Кнопка-Логотип "Stellar Burgers"
    private final static By LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a > svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.xpath(".//p[text()='Лента Заказов']");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    //    Кнопка "Войти в аккаунт" на главной
    private final static By LOGIN_ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    //    Кнопка вкладки "Соусы" в конструкторе
    private final static By SAUCES_BUTTON = By.xpath(".//span[text()='Соусы']");
    //    Кнопка вкладки "Начинки" в конструкторе
    private final static By FILLINGS_BUTTON = By.xpath(".//span[text()='Начинки']");
    //    Кнопка вкладки "Булки" в конструкторе
    private final static By BUNS_BUTTON = By.xpath(".//span[text()='Булки']");

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

//    // метод ожидания загрузки страницы (появление наличия кнопки Заказать)
//    public void waitForLoadPage() {
//        new WebDriverWait(driver, Duration.ofSeconds(2))
//                .until(ExpectedConditions.visibilityOfElementLocated(HEADER_ORDER_BUTTON));
//    }
//
//    //метод поиска раздела вопросов и скролла до него
//    public void findQuestions() {
//        WebElement element = driver.findElement(QUESTIONS);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//
//    //метод поиска первого вопроса и скролла до него
//    public void findFirstQuestion() {
//        WebElement element = driver.findElement(QUESTION_PRICE);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//
//    //    метод клика на вопрос "Сколько это стоит? И как оплатить?"
//    public ScooterMainPage clickPriceQuestion() {
//        driver.findElement(QUESTION_PRICE).click();
//        return this;
//    }
//
//    // метод для получения текста ответа на вопрос "Сколько это стоит? И как оплатить?"
//    public String priceText() {
//        return driver.findElement(ANSWER_PRICE).getText();
//    }
}
