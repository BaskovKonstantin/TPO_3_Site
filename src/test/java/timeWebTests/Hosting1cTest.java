package timeWebTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import timeWeb.Hosting1cPage;
import timeWeb.MainPage;
import util.BrowserDrivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Hosting1cTest {
    static BrowserDrivers browserDrivers;
    static HashMap<String, MainPage> mainPages;
    static HashMap<String, Hosting1cPage> hosting1cPages;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        mainPages = new HashMap();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://timeweb.com/ru/"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> mainPages.put(key, new MainPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> hosting1cPages.put(key, new Hosting1cPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @DisplayName("clickHosting1c")
    public void clickHosting1c() throws InterruptedException {
        mainPages.forEach((key, mainPage) -> assertTrue(mainPage.clickHosting1c()));
        hosting1cPages.forEach((key, hosting1cPage) -> assertTrue(hosting1cPage.checkUrl()));
    }

}
