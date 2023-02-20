package ui.page.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    WebDriver driver;

    public ContactPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='contact-first-name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id='contact-last-name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id='contact-description']")
    private WebElement aboutField;

    public String firstNameField() {
        return firstNameField.getText();
    }

    public String lastNameField() {
        return lastNameField.getText();
    }

    public String aboutField() {
        return aboutField.getText();
    }
}
