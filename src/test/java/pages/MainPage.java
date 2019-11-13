package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){this.driver = driver;}


    public MainPage StartLogin(){
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a")).click();

        return this;

    }

    public SignInPage InsertEmailAndContinue(String email, String password){
        driver.findElement(By.cssSelector("input[type=\"email\"]")).isDisplayed();
        driver.findElement(By.cssSelector("input[type=\"email\"]")).click();

        driver.findElement(By.cssSelector("input[type=\"email\"]")).isDisplayed();
        driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys(email);

        driver.findElement(By.cssSelector("input[id=\"continue\"][tabindex=\"5\"]")).isDisplayed();
        driver.findElement(By.cssSelector("input[id=\"continue\"][tabindex=\"5\"]")).click();

        driver.findElement(By.id("ap_password")).isDisplayed();
        driver.findElement(By.id("ap_password")).sendKeys(password);

        driver.findElement(By.id("signInSubmit")).isDisplayed();
        driver.findElement(By.id("signInSubmit")).click();

        return new SignInPage(driver);
    }

    public CartPage ClickOnCartIcon(){
        driver.findElement(By.id("nav-cart")).isDisplayed();
        driver.findElement(By.id("nav-cart")).click();

        return new CartPage(driver);
    }
}
