package timeWebTests;

public class LoginPageTest {

    static BrowserDrivers browserDrivers;
    static HashMap<String, DemoPage> demoPageHashMap;

    @BeforeAll
    public static void loadPage() throws IOException {
        browserDrivers = new BrowserDrivers();
        demoPageHashMap = new HashMap<String, DemoPage>();
        browserDrivers.drivers.forEach((key, driver) -> driver.get("https://statcounter.com/demo/summary/"));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS));
        browserDrivers.drivers.forEach((key, driver) -> demoPageHashMap.put(key, new DemoPage(driver)));
        browserDrivers.drivers.forEach((key, driver) -> driver.manage().window().setSize(new Dimension(1024, 1024)));
    }

    @BeforeEach
    @AfterEach
    public void timeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }
}
