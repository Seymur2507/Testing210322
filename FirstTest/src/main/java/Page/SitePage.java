package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SitePage {
    public WebDriver driver;
    public SitePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]/a")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"fat-menu\"]/a")
    private WebElement profileDropTab;

    @FindBy(xpath = "//*[@id=\"fat-menu\"]/ul/li[1]/a")
    private WebElement profileLink;

    //Тык на вкладку логина
    public void clickLoginBtn() {
        loginBtn.click();}

    //Тык на вкладку личного кабинета
    public void clickprofileLink() {
        profileDropTab.click();
        profileLink.click();}
}
