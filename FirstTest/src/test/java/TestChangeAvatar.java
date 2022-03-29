import Page.LoginPage;
import Page.ProfilePage;
import Page.SitePage;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class TestChangeAvatar extends TestBase{

        @ParameterizedTest
        @CsvSource(value = {
                "Testing123@mail.ru, Testing123"
        })
        public void TestChangeAvatar_me(String mail, String pas) {
            LoginPage loginpage = new LoginPage(driver);
            ProfilePage profilepage = new ProfilePage(driver);
            SitePage sitepage = new SitePage(driver);
            sitepage.clickLoginBtn();
            loginpage.inputEmail(mail);
            loginpage.inputPassword(pas);
            loginpage.AuthClick();
            sitepage.clickprofileLink();
            profilepage.avatarInput(driver);
            System.out.println("File is Uploaded Successfully");
        }
}

