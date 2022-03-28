import Page.LoginPage;
import Page.ProfilePage;
import Page.SitePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class TestChangeAvatar {
        public WebDriver driver;

        @BeforeAll
        public void Setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("http://users.bugred.ru/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        @AfterAll
        public void Shutdown() {
            driver.quit();
        }

        @ParameterizedTest
        @CsvSource(value = {
                "Testing123@mail.ru, Testing123"
        })
        public void TestChangeAvatar_me(String mail, String pas) {
            LoginPage loginpage = new LoginPage(driver);
            ProfilePage profilepage = new ProfilePage(driver);
            SitePage sitepage = new SitePage(driver);
            sitepage.clickLoginBtn();
            loginpage.inputEmail("Testing123@mail.ru");
            loginpage.inputPassword("Testing123");
            loginpage.AuthClick();
            sitepage.clickprofileLink();
            profilepage.avatarInput();
        }
}

