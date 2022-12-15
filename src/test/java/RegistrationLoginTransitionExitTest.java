import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.example.PageObject.LoginPage;
import org.example.PageObject.MainPage;
import org.example.PageObject.ProfilePage;
import org.example.PageObject.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegistrationLoginTransitionExitTest {
    private MainPage objMainPage;
    private LoginPage objLoginPage;
    private RegisterPage objRegisterPage;
    private ProfilePage objProfilePage;
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();//драйвер хром
        driver = new ChromeDriver();//экземпляр драйвера хром

        //замена на драйвер яндекс.браузера (закомментить экземпляр драйвера хрома выше и раскомментить строчки снизу)
//        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DNS\\yandexdriver.exe");
//        options.setBinary("C:\\Users\\DNS\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
//        driver = new ChromeDriver(options);

        objMainPage = new MainPage(driver);//новый объект класса главной страницы
        objLoginPage = new LoginPage(driver);//новый объект класса страницы "Вход"
        objRegisterPage = new RegisterPage(driver);//новый объект класса страницы "Регистрация"
        objProfilePage = new ProfilePage(driver);//новый объект класса страницы "Личный кабинет"
        objMainPage.open();//открытие тестовой страницы
        objMainPage.waitForLoadPage();//ожидание загрузки
    }

    @Test
    @DisplayName("Проверка успешной регистрации пользователя")
    public void aSuccessfulRegistration() {
        objMainPage.clickLoginAccountButton();//клик на "Войти в аккаунт"
        objLoginPage.clickRegisterButton();//клик на "Зарегистрироваться"
        objRegisterPage.inputName();//ввод имени
        objRegisterPage.inputEmail();//ввод почты
        objRegisterPage.inputPasswordWithSixChars();//ввод пароля
        objRegisterPage.clickRegisterButton();//клик на "Зарегистрироваться"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
    }//для повторной регистрации, после теста созданный пользователь удаляется через ручку в постмане

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля меньше шести символов")
    public void bCheckPasswordErrorIfLessSixChars() {
        objMainPage.clickLoginAccountButton();//клик на "Войти в аккаунт"
        objLoginPage.clickRegisterButton();//клик на "Зарегистрироваться"
        objRegisterPage.inputName();//ввод имени
        objRegisterPage.inputEmail();//ввод почты
        objRegisterPage.inputPasswordWithFiveChars();//ввод пароля
        objRegisterPage.clickRegisterButton();//клик на "Зарегистрироваться"
        objRegisterPage.isPasswordErrorPresent();//проверка появления ошибки
    }

    @Test
    @DisplayName("Проверка входа по кнопке Войти в аккаунт на главной")
    public void cSuccessfulLoginWithButtonEnterInAccount() {
        objMainPage.clickLoginAccountButton();//клик на "Войти в аккаунт"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @Test
    @DisplayName("Проверка входа через кнопку Личный кабинет")
    public void dSuccessfulLoginWithAccountButton() {
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void eSuccessfulLoginWithRegisterPageButton() {
        objMainPage.clickLoginAccountButton();//клик на "Войти в аккаунт"
        objLoginPage.clickRegisterButton();//клик на "Зарегистрироваться"
        objRegisterPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void fSuccessfulLoginWithResetPasswordPageButton() {
        objMainPage.clickLoginAccountButton();//клик на "Войти в аккаунт"
        objLoginPage.clickForgotButton();//клик на "Восстановить пароль"
        objRegisterPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет по клику на Личный кабинет")
    public void gSuccessfulTransitionWithAccountButton() {
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия кабинета
        objProfilePage.waitForLoadPage();//ожидание появления окна кабинета
        objProfilePage.isListItemButtonPresent();//проверка наличия кнопки "История заказов" в кабинете
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на Конструктор")
    public void hSuccessfulTransitionWithConstructorButton() {
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия кабинета
        objProfilePage.waitForLoadPage();//ожидание появления окна кабинета
        objProfilePage.isListItemButtonPresent();//проверка наличия кнопки "История заказов" в кабинете
        objProfilePage.clickConstructorButton();//клик на "Конструктор"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на логотип")
    public void iSuccessfulTransitionWithLogoButton() {
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия кабинета
        objProfilePage.waitForLoadPage();//ожидание появления окна кабинета
        objProfilePage.isListItemButtonPresent();//проверка наличия кнопки "История заказов" в кабинете
        objProfilePage.clickLogoButton();//клик на логотип
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void jSuccessfulExitFromAccount() {
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия кабинета
        objProfilePage.waitForLoadPage();//ожидание появления окна кабинета
        objProfilePage.isListItemButtonPresent();//проверка наличия кнопки "История заказов" в кабинете
        objProfilePage.clickExitButton();//клик на кнопку выхода
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы входа
        objLoginPage.waitForLoadPage();//ожидание появления окна страницы входа
        objLoginPage.isLoginPageWindowOpen();//проверка наличия кнопки "Восстановить пароль" на странице входа
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}