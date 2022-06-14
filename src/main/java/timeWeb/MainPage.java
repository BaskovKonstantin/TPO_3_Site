package timeWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/ul[1]/li[1]/div/a[1]")
    public WebElement virtualHostingLink;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/ul[1]/li[1]/div/a[2]")
    public WebElement cmsHostLink;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/ul[1]/li[2]/a")
    public WebElement vpsVdsLink;


    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/ul[1]/li[3]/div/a[1]")
    public WebElement hosting1cLink;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/ul[1]/li[3]/div/a[2]")
    public WebElement license1cLink;


    public WebDriver driver;

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public boolean clickVirtualHosting() {
        virtualHostingLink.click();
        return true;
    }

    public boolean clickCmsHost() {
        cmsHostLink.click();
        return true;
    }

    public boolean clickVpsVds() {
        vpsVdsLink.click();
        return true;
    }

    public boolean clickHosting1c() {
        hosting1cLink.click();
        return true;
    }

    public boolean clickLicense1c() {
        license1cLink.click();
        return true;
    }

}
