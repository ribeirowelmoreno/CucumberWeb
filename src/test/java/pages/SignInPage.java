package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    public SignInPage(WebDriver driver) {this.driver = driver;}

    public SearchResultPage SearchForSomeProduct(String product){
        driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        
        driver.findElement(By.xpath("//*[@id='nav-search']//input[@type='submit']")).isDisplayed();
        driver.findElement(By.xpath("//*[@id='nav-search']//input[@type='submit']")).click();

        return new SearchResultPage(driver);
    }
}
