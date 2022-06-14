package timeWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DomainsPage {

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div/form/input")
    public WebElement field;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/a")
    public WebElement checkDomains;

    public WebDriver driver;

    public DomainsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void enterField(String text){this.field.sendKeys(text);}

    public void clickCheckDomains(){this.checkDomains.click();}
}
