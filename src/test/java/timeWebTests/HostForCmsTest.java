package timeWebTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import timeWeb.CmsHostingPage;
import timeWeb.MainPage;
import util.BrowserDrivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HostForCmsTest {
    static BrowserDrivers browserDrivers;
    static HashMap<String, CmsHostingPage> cmsHostingPages;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        cmsHostingPages = new HashMap();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://timeweb.com/ru/services/cms/"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));

        browserDrivers.drivers.forEach((key, driver) -> cmsHostingPages.put(key, new CmsHostingPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @DisplayName("ClickCmsHost")
    public void clickCmsHost() throws InterruptedException {
        cmsHostingPages.forEach((key, cmsHostingPage) -> assertTrue(cmsHostingPage.checkUrl()));
    }
}
