package CucumberPack;
import Page.LoginPage;
import Page.ProfilePage;
import Page.SitePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class TestProfileNameАorCuc {

    public WebDriver driver;

    public void SetupCuc() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://users.bugred.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //сквозной тест на проверку коректности имени в профиле

        public void LoginCheckCuc(String mail, String pas) {
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

        public void ShutdownCuc() {
        driver.quit();
    }

}
