import Page.LoginPage;
import Page.SitePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestRegister {
    public WebDriver driver;

    @Test
    public void  Register(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://users.bugred.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginpage = new LoginPage(driver);
        SitePage sitepage = new SitePage(driver);
        sitepage.clickLoginBtn();
        loginpage.RegInputNamec("Сейм");
        loginpage.RegInputEmailc("Testing123@mail.ru");
        loginpage.RegInputPasswordc("Testing123");
        loginpage.RegClick();
        driver.quit();
    }
}
