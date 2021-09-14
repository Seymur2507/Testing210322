import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//input[@name=\"name\"]")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"fat-menu\"]/a")
    private WebElement profileDropTab;

    @FindBy(xpath = "//*[@id=\"fat-menu\"]/ul/li[3]/a")
    private WebElement profileExitBtn;

    //Получение юзернейма из профиля
    public String getUserName() {
        String userName = username.getText();
        return userName; }

    //Выход из профиля
    public void clickLogoutLink(){
        profileDropTab.click();
        profileExitBtn.click();
    }
}
