package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.applet.Main;
import support.Web;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){this.driver = driver;}

    public LogInPage ClickInLogIn(){
        driver.findElement(By.xpath("//*[@id='header']//a[@class='login'][contains(text(), 'Sign in')]")).click();

        return new LogInPage(driver);
    }
}
