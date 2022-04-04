import Page.LoginPage;
import Page.ProfilePage;
import Page.SitePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestProfileName extends TestBase{

//сквозной тест на проверку коректности имени в профиле
    @ParameterizedTest
    @CsvSource(value = {
            "Testing123@mail.ru, Testing123",
            "Testing1234@mail.ru, Testing123",/*задумано*/
            "Testing123@mail.ru, Testing123"
    }) //true чтобы пропускал пробелы
    public void LoginCheck(String mail, String pas) {
        LoginPage loginpage = new LoginPage(driver);
        ProfilePage profilepage = new ProfilePage(driver);
        SitePage sitepage = new SitePage(driver);
        sitepage.clickLoginBtn();
        loginpage.inputEmail(mail);
        loginpage.inputPassword(pas);
        loginpage.AuthClick();
        sitepage.clickprofileLink();
        String user = profilepage.getUserName();
        Assertions.assertEquals("Сейм", user);
        profilepage.clickLogoutLink();
    }

    //Негативный тест на авторизаацию
    @ParameterizedTest
    @CsvSource(value = {
            "Testing1234@mail.ru, Testing123"
    })
    public void LoginCheckNeg(String mail, String pas) {
        LoginPage loginpage = new LoginPage(driver);
        ProfilePage profilepage = new ProfilePage(driver);
        SitePage sitepage = new SitePage(driver);
        sitepage.clickLoginBtn();
        loginpage.inputEmail(mail);
        loginpage.inputPassword(pas);
        loginpage.AuthClick();
        String urlBase = driver.getCurrentUrl();
        Assertions.assertEquals("http://users.bugred.ru/user/login/index.html", urlBase);
    }
}
