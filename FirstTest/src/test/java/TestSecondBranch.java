import Page.LoginPage;
import Page.ProfilePage;
import Page.SitePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSecondBranch {
    public WebDriver driver;
    @BeforeAll
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://users.bugred.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Testing123@mail.ru, Testing123",
            ""
    }) //true чтобы пропускал пробелы
    public void LoginCheck(String mail, String pas){
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
    @AfterAll
    public void Shutdown(){

        driver.quit();
    }
}
