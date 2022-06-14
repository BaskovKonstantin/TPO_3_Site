package timeWebTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import timeWeb.MainPage;
import timeWeb.VpsVdsPage;
import util.BrowserDrivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VpsVdsPageTest {
    static BrowserDrivers browserDrivers;
    static HashMap<String, MainPage> mainPages;
    static HashMap<String, VpsVdsPage> vpsVdsPages;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        vpsVdsPages = new HashMap();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://timeweb.com/ru/services/vds-50/"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> vpsVdsPages.put(key, new VpsVdsPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @DisplayName("clickLicense1c")
    public void clickLicense1c() throws InterruptedException {
        vpsVdsPages.forEach((key, vpsVdsPage) -> assertTrue(vpsVdsPage.checkUrl()));
    }

}
