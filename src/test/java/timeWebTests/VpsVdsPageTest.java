package timeWebTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import timeWeb.MainPage;
import util.BrowserDrivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VpsVdsPageTest {
    static BrowserDrivers browserDrivers;
    static HashMap<String, MainPage> mainPages;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        mainPages = new HashMap();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://wm.timeweb.ru/login?_ga=2.196343784.555368092.1655207883-2128871962.1655207883"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> mainPages.put(key, new MainPage(driver)));
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
        mainPages.forEach((key, mainPage) -> assertTrue(mainPage.clickLicense1c()));
    }

}
