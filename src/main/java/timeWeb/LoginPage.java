package timeWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div/section/form/div[1]/input")
    public WebElement usernameField;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div/section/form/div[2]/input")
    public WebElement passwordField;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div/section/form/div[4]/button")
    public WebElement loginButton;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div/section/div/div/button[2]")
    public WebElement gitHubButton;

    public WebDriver driver;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.driver = webDriver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void enterUsername(String text){this.usernameField.sendKeys(text);}

    public void enterPassword(String text){this.passwordField.sendKeys(text);}

    public void clickLoginButton(){this.loginButton.click();}
}
