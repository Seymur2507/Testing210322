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

    @FindBy(xpath="/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[1]/td[2]/input")
    private WebElement profileAvatar;

    @FindBy(name="act_profile_now")
    private WebElement saveProfileButton;


    //загрузка аватара
    public void avatarInput() {

        profileAvatar.click();
        //profileAvatar.sendKeys("C:/fakepath/chili-patagoniya-priroda-gory-skaly-sneg-nebo.jpg");
        System.out.println("File is Uploaded Successfully");
    }

    //Сохранить настройки профиля
    public void saveProfile(){
        saveProfileButton.click();
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
