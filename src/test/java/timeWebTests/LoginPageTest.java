package timeWebTests;

import org.apache.commons.logging.Log;
import timeWeb.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import util.BrowserDrivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, LoginPage> loginPageHashMap;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        loginPageHashMap = new HashMap<String, LoginPage>();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://wm.timeweb.ru/login?_ga=2.196343784.555368092.1655207883-2128871962.1655207883"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> loginPageHashMap.put(key, new LoginPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @DisplayName("UsernameFieldCheck")
    public void usernameField() throws InterruptedException {
        loginPageHashMap.forEach((key, LoginPage) -> assertTrue(LoginPage.usernameField.isDisplayed()));
    }

    @Test
    @DisplayName("UsernameFieldEnter")
    public void usernameEnter() throws InterruptedException {
        loginPageHashMap.forEach((key, LoginPage) -> LoginPage.usernameField.sendKeys("cb47665"));
    }

    @Test
    @DisplayName("PasswordFieldCheck")
    public void passwordField() throws InterruptedException {
        loginPageHashMap.forEach((key, LoginPage) -> assertTrue(LoginPage.passwordField.isDisplayed()));
    }

    @Test
    @DisplayName("PasswordFieldEnter")
    public void passwordEnter() throws InterruptedException {
        loginPageHashMap.forEach((key, LoginPage) -> LoginPage.passwordField.sendKeys("eaSzomOx656N"));
    }

    @Test
    @DisplayName("GitHubButtonCheck")
    public void gitHubButton() throws InterruptedException {
        loginPageHashMap.forEach((key, LoginPage) -> assertTrue(LoginPage.gitHubButton.isDisplayed()));
    }

    @Test
    @DisplayName("LoginButtonCheck")
    public void loginButtonCheck() throws InterruptedException {
        loginPageHashMap.forEach((key, LoginPage) -> assertTrue(LoginPage.loginButton.isDisplayed()));
    }

    @Test
    @DisplayName("LoginButtonClick")
    public void loginButtonClick() throws InterruptedException {
        loginPageHashMap.forEach((key, LoginPage) -> LoginPage.clickLoginButton());
    }

    @AfterAll
    public static void closeUp() throws InterruptedException {
        browserDrivers.closeBrowser();
    }
}
