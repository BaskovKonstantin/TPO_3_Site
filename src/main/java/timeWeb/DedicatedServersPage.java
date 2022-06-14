package timeWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DedicatedServersPage {

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/a")
    public WebElement registrationButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/a")
    public WebElement banner;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[3]/div/div[1]/div[1]/a[5]")
    public WebElement licensesButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/div[1]/div[2]/div/div/div[1]")
    public WebElement questionButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/div[1]/div[2]/div/div/div[1]")
    public WebElement orderButton;

    public WebDriver driver;

    public DedicatedServersPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void clickQuestionButton() {this.questionButton.click();}
}
