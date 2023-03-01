package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.page.AddContactWindow;
import ui.page.MenuEl;
import ui.page.contact.ContactPage;
import ui.page.login.LoginPage;
import util.DataProviders;

import java.util.Map;

public class ParametrizedTest extends TestBase {
    LoginPage loginPage;
    MenuEl menu;
    AddContactWindow addContactWindow;
    ContactPage contactPage;


    @BeforeMethod
    public void precondition() {
        loginPage = new LoginPage(driver);
        loginPage.getLogin(EMAIL, PASSWORD);

    }


    @Test(dataProvider = "NewContact", dataProviderClass = DataProviders.class)
    public void addNewContactDataProviderTest(String firstName, String lastName, String about) {

        menu = new MenuEl(driver);
        menu.clickNewContact();
        addContactWindow = new AddContactWindow(driver);
        addContactWindow.fillData(firstName, lastName, about);
        contactPage = new ContactPage(driver);


        Map<String, String> info = contactPage.getInfo();

        Assert.assertEquals(info.get("first name"), firstName);
        Assert.assertEquals(info.get("last name"), lastName);
        Assert.assertEquals(info.get("contact description"), about);

    }
    @Test(dataProvider = "newContactWithCsv", dataProviderClass = DataProviders.class)
    public void addNewContactDataProviderCsvTest(String firstName, String lastName, String about) {

        menu = new MenuEl(driver);
        menu.clickNewContact();
        addContactWindow = new AddContactWindow(driver);
        addContactWindow.fillData(firstName, lastName, about);
        contactPage = new ContactPage(driver);
        Map<String, String> info = contactPage.getInfo();
        Assert.assertEquals(info.get("first name"), firstName);
        Assert.assertEquals(info.get("last name"), lastName);
        Assert.assertEquals(info.get("contact description"), about);

    }


}
