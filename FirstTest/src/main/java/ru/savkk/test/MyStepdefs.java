package ru.savkk.test;

import cucumber.api.PendingException;
import cucumber.api.java.ru.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    @Дано("открыть страницу")
    public void наСчетеПользователяИмеетсяРублей(int arg1) throws Throwable {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://users.bugred.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        throw new PendingException();
    }

    @Когда("^пользователь снимает со счета (\\d+) рублей$")
    public void пользовательСнимаетСоСчетаРублей(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^появляется предупреждение \"([^\"]*)\"$")
    public void появляетсяПредупреждение(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}