package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class BrowserDrivers {


    public HashMap<String, WebDriver> drivers = new HashMap<>();
    String site = "";

    public BrowserDrivers() throws IOException {
        final String filePath = "C:\\Users\\KonBas\\IdeaProjects\\TPO_3_Site\\Drivers.json";

        HashMap<String,String> Properties = new ObjectMapper().readValue(new String(Files.readAllBytes(Paths.get(filePath))), HashMap.class);
        this.site = Properties.get("Site");

        String chromeDriver = "webdriver.chrome.driver";
        if (!Properties.get("Chrome").equals("")) {
            System.setProperty(chromeDriver, Properties.get("Chrome"));
            this.drivers.put("Chrome", new ChromeDriver());
        }

        String firefoxDriver = "webdriver.gecko.driver";
        if (!Properties.get("Firefox").equals("")){
            System.setProperty(firefoxDriver, Properties.get("Firefox"));
            this.drivers.put("Firefox", new FirefoxDriver());
        }

        String chromiumDriver = "webdriver.chromium.driver";
        if (!Properties.get("Chromium").equals("")) {
            System.setProperty(chromiumDriver, Properties.get("Chromium"));
            this.drivers.put("Chromium", new EdgeDriver());
        }

        String internetExplorerDriver = "webdriver.InternetExplorer.driver";
        if (!Properties.get("InternetExplorer").equals("")) {
            System.setProperty(internetExplorerDriver, Properties.get("InternetExplorer"));
            this.drivers.put("InternetExplorer",new InternetExplorerDriver());
        }

        String operaDriver = "webdriver.opera.driver";
        if (!Properties.get("Opera").equals("")) {
            System.setProperty(operaDriver, Properties.get("Opera"));
            ChromeOptions options = new ChromeOptions();
            options.setBinary("");
            this.drivers.put("Opera", new ChromeDriver(options) );
        }

        String safariDriver = "webdriver.safari.driver";
        if (!Properties.get("Safari").equals("")) {
            System.setProperty(safariDriver, Properties.get("Safari"));
            this.drivers.put("Safari", new SafariDriver());
        }


    }

    public HashMap getDrivers()
    {
        return this.drivers;
    }

    public String getSite(){return this.site;}

    public void closeBrowser()
    {
        for (String key : this.drivers.keySet()) {
            drivers.get(key).close();
        }
    }

}
