package timeWebTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import timeWeb.DedicatedServersPage;
import timeWeb.DomainsPage;
import util.BrowserDrivers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DomainsPageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, DomainsPage> domainsPageHashMap;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        domainsPageHashMap = new HashMap<String, DomainsPage>();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://timeweb.com/ru/services/domains/"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> domainsPageHashMap.put(key, new DomainsPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    @DisplayName("FieldCheck")
    public void fieldCheck() throws InterruptedException {
        domainsPageHashMap.forEach((key, DomainsPage) -> assertTrue(DomainsPage.field.isDisplayed()));
    }

    @Test
    @DisplayName("EnterField")
    public void enterField() throws InterruptedException {
        domainsPageHashMap.forEach((key, DomainsPage) -> DomainsPage.enterField("itmo"));
    }

    @Test
    @DisplayName("CheckDomainsCheck")
    public void checkDomainsCheck() throws InterruptedException {
        domainsPageHashMap.forEach((key, DomainsPage) -> assertTrue(DomainsPage.checkDomains.isDisplayed()));
    }

    @Test
    @DisplayName("ClickDomainsCheck")
    public void clickDomainsCheck() throws InterruptedException {
        domainsPageHashMap.forEach((key, DomainsPage) -> DomainsPage.clickCheckDomains());
    }

    @AfterAll
    public static void closeUp() throws InterruptedException {
        browserDrivers.closeBrowser();
    }
}
