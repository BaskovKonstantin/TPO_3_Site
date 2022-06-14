package timeWebTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import timeWeb.LoginPage;
import timeWeb.PartnershipPage;
import util.BrowserDrivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class PartnershipPageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, PartnershipPage> partnershipPageHashMap;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        partnershipPageHashMap = new HashMap<String, PartnershipPage>();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://timeweb.com/ru/partners/webmasters/"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> partnershipPageHashMap.put(key, new PartnershipPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @DisplayName("RegistrationButtonCheck")
    public void registrationButtonCheck() throws InterruptedException {
        partnershipPageHashMap.forEach((key, PartnershipPage) -> assertTrue(PartnershipPage.registrationButton.isDisplayed()));
    }

    @Test
    @DisplayName("LoginButtonCheck")
    public void loginButtonCheck() throws InterruptedException {
        partnershipPageHashMap.forEach((key, PartnershipPage) -> assertTrue(PartnershipPage.loginButton.isDisplayed()));
    }

    @Test
    @DisplayName("UsersButtonCheck")
    public void usersButtonCheck() throws InterruptedException {
        partnershipPageHashMap.forEach((key, PartnershipPage) -> assertFalse(PartnershipPage.usersButton.isDisplayed()));
    }

    @Test
    @DisplayName("IncomesButtonCheck")
    public void incomesButtonCheck() throws InterruptedException {
        partnershipPageHashMap.forEach((key, PartnershipPage) -> assertTrue(PartnershipPage.incomesButton.isDisplayed()));
    }

    @Test
    @DisplayName("PaymentsButtonCheck")
    public void paymentsButtonCheck() throws InterruptedException {
        partnershipPageHashMap.forEach((key, PartnershipPage) -> assertTrue(PartnershipPage.paymentsButton.isDisplayed()));
    }

    @AfterAll
    public static void closeUp() throws InterruptedException {
        browserDrivers.closeBrowser();
    }
}
