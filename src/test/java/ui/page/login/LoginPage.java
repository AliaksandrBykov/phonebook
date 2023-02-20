package ui.page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.tests.TestBase;

import java.awt.*;

public class LoginPage {
    WebDriver driver;
    private Label errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='defaultRegisterFormEmail']" )
    private WebElement userMailInput;

    @FindBy (xpath = "//*[@name='password']")
    private  WebElement userPasswordInput;

    @FindBy (xpath = "//*[@class='btn btn-info my-1 btn-block']")
    private  WebElement loginButton;

    @FindBy(xpath = "//div[@id=\"error-message\"]")
    private WebElement errorLoginPasswordMessage;




    public void  getLogin (String userMail, String password) {
        userMailInput.clear();
        userMailInput.sendKeys(userMail);
        userPasswordInput.clear();
        userPasswordInput.sendKeys(password);
        loginButton.click();
    }
    public String getErrorLoginPasswordMessage() {
        return errorLoginPasswordMessage.getText();
    }


}


