import Page.LoginPage;
import Page.SitePage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestRegister extends TestBase{


    @Test
    public void  Register(){

        LoginPage loginpage = new LoginPage(driver);
        SitePage sitepage = new SitePage(driver);
        sitepage.clickLoginBtn();
        loginpage.RegInputNamec("Сейм");
        loginpage.RegInputEmailc("Testing123@mail.ru");
        loginpage.RegInputPasswordc("Testing123");
        loginpage.RegClick();
        String httpAfterLogin = driver.getCurrentUrl();
        Assertions.assertEquals("Сейм", httpAfterLogin);
        System.out.println("Reg - ok");

    }
}
