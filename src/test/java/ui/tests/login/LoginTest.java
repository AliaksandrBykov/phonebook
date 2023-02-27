package ui.tests.login;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.page.MenuEl;
import ui.page.login.LoginPage;
import ui.tests.TestBase;

public class LoginTest extends TestBase {
    String userMail = "test@gmail.com";

    String password = "test@gmail.com";

    LoginPage loginPage;

    MenuEl menu;

    Faker faker = new Faker();

    String wrongMail = faker.internet().emailAddress();

    String wrongPassword = faker.internet().password();

    String errorLoginPasswordMessage = "Please check your activation or login + Password combination";

    @Test
    public void LoginTest () {
        logger.info("Test date:\nlogin - " + userMail + "\npassword - "  + password);
        loginPage = new LoginPage(driver);
        loginPage.getLogin(userMail, password );
        menu = new MenuEl(driver);

        Assert.assertTrue(menu.isAddNewContactMenuLinkDisplayed(),"The main page did not load");
    }
    @Test
    public void setErrorLoginPasswordMessage() {
        logger.info("Test date:\n login - " + wrongMail + "\npassword -"  + wrongPassword);
        loginPage = new LoginPage(driver);
        loginPage.getLogin(wrongMail, wrongPassword);

        Assert.assertEquals(loginPage.getErrorLoginPasswordMessage(),errorLoginPasswordMessage);



    }
}
