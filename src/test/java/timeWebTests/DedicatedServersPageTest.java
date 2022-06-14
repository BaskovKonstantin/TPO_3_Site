package timeWebTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import timeWeb.DedicatedServersPage;
import timeWeb.LoginPage;
import util.BrowserDrivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DedicatedServersPageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, DedicatedServersPage> dedicatedServersPageHashMap;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        dedicatedServersPageHashMap = new HashMap<String, DedicatedServersPage>();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://timeweb.com/ru/services/dedicated-server/"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> dedicatedServersPageHashMap.put(key, new DedicatedServersPage(driver)));
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
        dedicatedServersPageHashMap.forEach((key, DedicatedServersPage) -> assertTrue(DedicatedServersPage.registrationButton.isDisplayed()));
    }

    @Test
    @DisplayName("BannerCheck")
    public void bannerCheck() throws InterruptedException {
        dedicatedServersPageHashMap.forEach((key, DedicatedServersPage) -> assertTrue(DedicatedServersPage.banner.isDisplayed()));
    }

    @Test
    @DisplayName("LicensesButtonCheck")
    public void licensesButtonCheck() throws InterruptedException {
        dedicatedServersPageHashMap.forEach((key, DedicatedServersPage) -> assertTrue(DedicatedServersPage.licensesButton.isDisplayed()));
    }

    @Test
    @DisplayName("QuestionButtonCheck")
    public void questionButtonCheck() throws InterruptedException {
        dedicatedServersPageHashMap.forEach((key, DedicatedServersPage) -> assertTrue(DedicatedServersPage.questionButton.isDisplayed()));
    }

    @Test
    @DisplayName("ClickQuestionButton")
    public void clickQuestionButton() throws InterruptedException {
        dedicatedServersPageHashMap.forEach((key, DedicatedServersPage) -> DedicatedServersPage.clickQuestionButton());
    }

    @Test
    @DisplayName("OrderButtonCheck")
    public void orderButtonCheck() throws InterruptedException {
        dedicatedServersPageHashMap.forEach((key, DedicatedServersPage) -> assertTrue(DedicatedServersPage.orderButton.isDisplayed()));
    }

    @AfterAll
    public static void closeUp() throws InterruptedException {
        browserDrivers.closeBrowser();
    }
}
