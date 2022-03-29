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
            "Testing1234@mail.ru, Testing123",
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
}
