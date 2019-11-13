package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private WebDriver driver;

    public LogInPage(WebDriver driver) {this.driver = driver;}

    public PersonalInformationPage CreateAccount(){
        driver.findElement(By.id("email_create")).sendKeys("wel@teste.com");
        driver.findElement(By.id("SubmitCreate")).click();

        return new PersonalInformationPage(driver);
    }

    public LogInPage InsertEmail(){
        driver.findElement(By.id("email")).sendKeys("wel@teste.com");

        return this;
    }

    public LogInPage InsertPassword(){
        driver.findElement(By.id("passwd")).sendKeys("421563");

        return this;
    }

    public LoggedPage SubmitSignIn(){
        driver.findElement(By.id("SubmitLogin")).click();

        return new LoggedPage(driver);
    }
}
