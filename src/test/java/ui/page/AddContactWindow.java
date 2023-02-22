package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class AddContactWindow {
    WebDriver driver;

    public AddContactWindow (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//*[@id='form-name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[@id='form-lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@id='form-about']")
    private WebElement aboutInput;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    private WebElement saveButton;

    public void fillData(String firstName,String lastName,String about) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        aboutInput.clear();
        aboutInput.sendKeys(about);
        saveButton.click();
    }
}

