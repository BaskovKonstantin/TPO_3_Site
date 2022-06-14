package timeWebTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import timeWeb.MainPage;
import timeWeb.VirtualHostingPage;
import util.BrowserDrivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualHostTest {
    static BrowserDrivers browserDrivers;
    static HashMap<String, MainPage> mainPages;
    static HashMap<String, VirtualHostingPage> virtualHostingPagePages;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        mainPages = new HashMap<String, MainPage>();
        virtualHostingPagePages = new HashMap<String, VirtualHostingPage>();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://timeweb.com/ru/"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> mainPages.put(key, new MainPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> virtualHostingPagePages.put(key, new VirtualHostingPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @DisplayName("ClickVirtualHosting")
    public void clickVirtualHosting() throws InterruptedException {
        mainPages.forEach((key, mainPage) -> assertTrue(mainPage.clickVirtualHosting()));
        virtualHostingPagePages.forEach((key, virtualHostingPagePage) -> assertTrue(virtualHostingPagePage.checkUrl()));
    }


}
