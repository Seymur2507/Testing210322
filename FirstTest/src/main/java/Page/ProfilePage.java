package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[2]/td[2]/input")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"fat-menu\"]/a")
    private WebElement profileDropTab;

    @FindBy(xpath = "//*[@id=\"fat-menu\"]/ul/li[3]/a")
    private WebElement profileExitBtn;

    @FindBy(name="avatar")
    private WebElement profileAvatar;

    //загрузка аватара
    public void avatarInput() {
    String filePath = "https://www.anypics.ru/download.php?file=201210/1280x1024/anypics.ru-6881.jpg";
    profileAvatar.sendKeys(filePath);
    System.out.println("File is Uploaded Successfully");
    }

    //Получение юзернейма из профиля
    public String getUserName() {
        String userName = username.getAttribute("value");
        return userName; }

    //Выход из профиля
    public void clickLogoutLink(){
        profileDropTab.click();
        profileExitBtn.click();
    }
}
