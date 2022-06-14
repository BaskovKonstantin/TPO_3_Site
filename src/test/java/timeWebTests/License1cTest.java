package timeWebTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import timeWeb.License1cPage;
import timeWeb.MainPage;
import util.BrowserDrivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class License1cTest {
    static BrowserDrivers browserDrivers;
    static HashMap<String, MainPage> mainPages;
    static HashMap<String, License1cPage> license1cPages;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        license1cPages = new HashMap();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://timeweb.com/ru/services/bitrix/license/"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> license1cPages.put(key, new License1cPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @DisplayName("clickVpsVds")
    public void clickVpsVds() throws InterruptedException {
        license1cPages.forEach((key, license1cPage) -> assertTrue(license1cPage.checkUrl()));
    }
}
