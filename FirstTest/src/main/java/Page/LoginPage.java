package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//input[@name=\"login\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class=\"btn btn-danger\"]")
    private WebElement AuthBtn;

    //Ввод мыла
    public void inputEmail(String email) {emailInput.sendKeys(email);}
    //Ввод пасса
    public void inputPassword(String password) {passwordInput.sendKeys(password);}
    //Клик логина
    public void AuthClick() {AuthBtn.click();}

    @FindBy(name = "name")
    private WebElement RegNameInput;

    @FindBy(name = "email")
    private WebElement RegEmailInput;

    @FindBy(name = "password")
    private WebElement ReqPasswordInput;

    @FindBy(name = "act_register_now")
    private WebElement RegBtn;

    //Регистрация - ввод имени
    public void RegInputNamec(String name) {RegNameInput.sendKeys(name);}
    //Регистрация - ввод мыла
    public void RegInputEmailc(String email) {RegEmailInput.sendKeys(email);}
    //Регистрация - ввод пароля
    public void RegInputPasswordc(String password) {ReqPasswordInput.sendKeys(password);}
    //Клик логина
    public void RegClick() {RegBtn.click();}

}
