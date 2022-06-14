package timeWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class VirtualHostingPage {

    public WebDriver driver;

    public VirtualHostingPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public boolean checkUrl(){
        return "https://timeweb.com/ru/services/hosting/".equals(driver.getCurrentUrl());
    }
}
