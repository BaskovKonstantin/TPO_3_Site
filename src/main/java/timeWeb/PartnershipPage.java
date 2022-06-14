package timeWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PartnershipPage {

    @FindBy(xpath = "/html/body/div[2]/div[2]/section/div[1]/div[1]/div/div[1]/div/div[2]/button")
    public WebElement registrationButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/section/div[1]/div[1]/div/div[1]/div/div[2]/button")
    public WebElement loginButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/section/div[2]/div[4]/div[3]/div[1]/div/div/strong[2]")
    public WebElement usersButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/section/div[2]/div[4]/div[3]/div[1]/div/div/strong[3]")
    public WebElement incomesButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/section/div[2]/div[4]/div[3]/div[1]/div/div/strong[4]")
    public WebElement paymentsButton;

    public WebDriver driver;

    public PartnershipPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
