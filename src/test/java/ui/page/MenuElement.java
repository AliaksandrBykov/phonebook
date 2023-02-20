package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class MenuElement {

    WebDriver driver;
//    private Label errorMessage;

    public MenuElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//ul[@class='navbar-nav mr-auto']/li[2]")
    private WebElement addNewContactMenuLink;

    public void clickNewContact() {
        addNewContactMenuLink.click();
    }

    public boolean isAddNewContactMenuLinkDisplayed() {
        return addNewContactMenuLink.isDisplayed();


    }

}
