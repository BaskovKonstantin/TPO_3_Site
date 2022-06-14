package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AntiplagiarismPage {

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[1]/div/form/div/div[1]/div/div[1]/div[1]/textarea[1]")
    public WebElement inputText;


    public WebDriver driver;

    public AntiplagiarismPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void sendTextInputText(String text)
    {
        this.inputText.sendKeys(text);
    }



}
