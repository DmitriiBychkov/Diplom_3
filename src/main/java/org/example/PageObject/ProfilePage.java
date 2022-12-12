package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
//    //    Адрес сайта
//    private static final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";
//    //    Кнопка "да все привыкли" в окне про куки
//    private final static By COOKIE_BUTTON = By.id("rcc-confirm-button");
//    //    Кнопка "Заказать" в хедере
//    private final static By HEADER_ORDER_BUTTON = By.cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g");
//    //    Раздел вопросов
//    private final static By QUESTIONS = By.cssSelector(".Home_FAQ__3uVm4");
//    //    Вопрос "Сколько это стоит? И как оплатить?"
//    private final static By QUESTION_PRICE = By.id("accordion__heading-0");
//    //    Ответ "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
//    private final static By ANSWER_PRICE = By.id("accordion__panel-0");
//    //    Вопрос "Хочу сразу несколько самокатов! Так можно?"
//    private final static By QUESTION_QUANTITY = By.id("accordion__heading-1");
//    //    Ответ "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
//    private final static By ANSWER_QUANTITY = By.id("accordion__panel-1");
//    //    Вопрос "Как рассчитывается время аренды?"
//    private final static By QUESTION_TIME = By.id("accordion__heading-2");
//    //    Ответ "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
//    private final static By ANSWER_TIME = By.id("accordion__panel-2");
//    //    Вопрос "Можно ли заказать самокат прямо на сегодня?"
//    private final static By QUESTION_TODAY = By.id("accordion__heading-3");
//    //    Ответ "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
//    private final static By ANSWER_TODAY = By.id("accordion__panel-3");
//    //Вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
//    private final static By QUESTION_EXTEND_RETURN = By.id("accordion__heading-4");
//    //    Ответ "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."
//    private final static By ANSWER_EXTEND_RETURN = By.id("accordion__panel-4");
//    //    Вопрос "Вы привозите зарядку вместе с самокатом?"
//    private final static By QUESTION_CHARGER = By.id("accordion__heading-5");
//    //    Ответ "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."
//    private final static By ANSWER_CHARGER = By.id("accordion__panel-5");
//    //    Вопрос "Можно ли отменить заказ?"
//    private final static By QUESTION_CANCELLATION = By.id("accordion__heading-6");
//    //    Ответ "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
//    private final static By ANSWER_CANCELLATION = By.id("accordion__panel-6");
//    //    Вопрос "Я жизу за МКАДом, привезёте?"
//    private final static By QUESTION_MKAD = By.id("accordion__heading-7");
//    //    Ответ "Да, обязательно. Всем самокатов! И Москве, и Московской области."
//    private final static By ANSWER_MKAD = By.id("accordion__panel-7");
//
//    private final WebDriver driver;
//
//    public ScooterMainPage(WebDriver driver) {
//        this.driver = driver;
//    }//конструктор класса
//
//    // метод открытия тестовой страницы
//    public ScooterMainPage open() {
//        driver.get(SCOOTER_URL);
//        return this;
//    }
//
//    // метод клика на подтверждение куки
//    public ScooterMainPage clickCookieButton() {
//        driver.findElement(COOKIE_BUTTON).click();
//        return this;
//    }
//
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
//
//    //метод поиска второго вопроса и скролла до него
//    public void findSecondQuestion() {
//        WebElement element = driver.findElement(QUESTION_QUANTITY);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//
//    //    метод клика на вопрос "Хочу сразу несколько самокатов! Так можно?"
//    public ScooterMainPage clickQuantityQuestion() {
//        driver.findElement(QUESTION_QUANTITY).click();
//        return this;
//    }
//
//    // метод для получения текста ответа на вопрос "Сколько это стоит? И как оплатить?"
//    public String quantityText() {
//        return driver.findElement(ANSWER_QUANTITY).getText();
//    }
//
//    //метод поиска третьго вопроса и скролла до него
//    public void findThirdQuestion() {
//        WebElement element = driver.findElement(QUESTION_TIME);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//
//    //    метод клика на вопрос "Как рассчитывается время аренды?"
//    public ScooterMainPage clickTimeQuestion() {
//        driver.findElement(QUESTION_TIME).click();
//        return this;
//    }
//
//    // метод для получения текста ответа на вопрос "Как рассчитывается время аренды?"
//    public String timeText() {
//        return driver.findElement(ANSWER_TIME).getText();
//    }
//
//    //метод поиска четвёртого вопроса и скролла до него
//    public void findFourthQuestion() {
//        WebElement element = driver.findElement(QUESTION_TODAY);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//
//    //    метод клика на вопрос "Можно ли заказать самокат прямо на сегодня?"
//    public ScooterMainPage clickTodayQuestion() {
//        driver.findElement(QUESTION_TODAY).click();
//        return this;
//    }
//
//    // метод для получения текста ответа на вопрос "Можно ли заказать самокат прямо на сегодня?"
//    public String todayText() {
//        return driver.findElement(ANSWER_TODAY).getText();
//    }
//
//    //метод поиска пятого вопроса и скролла до него
//    public void findFifthQuestion() {
//        WebElement element = driver.findElement(QUESTION_EXTEND_RETURN);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//
//    //    метод клика на вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
//    public ScooterMainPage clickExtendReturnQuestion() {
//        driver.findElement(QUESTION_EXTEND_RETURN).click();
//        return this;
//    }
//
//    // метод для получения текста ответа на вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
//    public String extendReturnText() {
//        return driver.findElement(ANSWER_EXTEND_RETURN).getText();
//    }
//
//    //метод поиска шестого вопроса и скролла до него
//    public void findSixthQuestion() {
//        WebElement element = driver.findElement(QUESTION_CHARGER);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//
//    //    метод клика на вопрос "Вы привозите зарядку вместе с самокатом?"
//    public ScooterMainPage clickChargerQuestion() {
//        driver.findElement(QUESTION_CHARGER).click();
//        return this;
//    }
//
//    // метод для получения текста ответа на вопрос "Вы привозите зарядку вместе с самокатом?"
//    public String chargerText() {
//        return driver.findElement(ANSWER_CHARGER).getText();
//    }
//
//    //метод поиска седьмого вопроса и скролла до него
//    public void findSeventhQuestion() {
//        WebElement element = driver.findElement(QUESTION_CANCELLATION);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//
//    //    метод клика на вопрос "Можно ли отменить заказ?"
//    public ScooterMainPage clickCancellationQuestion() {
//        driver.findElement(QUESTION_CANCELLATION).click();
//        return this;
//    }
//
//    // метод для получения текста ответа на вопрос "Можно ли отменить заказ?"
//    public String cancellationText() {
//        return driver.findElement(ANSWER_CANCELLATION).getText();
//    }
//
//    //метод поиска восьмого вопроса и скролла до него
//    public void findEighthQuestion() {
//        WebElement element = driver.findElement(QUESTION_MKAD);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//
//    //    метод клика на вопрос "Я жизу за МКАДом, привезёте?"
//    public ScooterMainPage clickMkadQuestion() {
//        driver.findElement(QUESTION_MKAD).click();
//        return this;
//    }
//
//    // метод для получения текста ответа на вопрос "Я жизу за МКАДом, привезёте?"
//    public String mkadText() {
//        return driver.findElement(ANSWER_MKAD).getText();
//    }
}
