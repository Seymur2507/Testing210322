import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TestingGroup {
    public WebDriver driver;
    @BeforeClass
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://users.bugred.ru/");
    }
    @Test
    public void LoginСheck(){
        SitePage sitepage = new SitePage(driver);
        LoginPage loginpage = new LoginPage(driver);
        ProfilePage profilepage = new ProfilePage(driver);
        sitepage.clickLoginBtn();
        loginpage.inputEmail("Testing123@mail.ru");
        loginpage.inputPassword("Testing123");
        loginpage.AuthClick();
        sitepage.clickprofileLink();
        String user = profilepage.getUserName();
        Assert.assertEquals("testing123", user);
        profilepage.clickLogoutLink();
    }
    @AfterClass
    public void Shutdown(){
        driver.quit();
    }
}
