package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class PersonalInformationPage {
    private WebDriver driver;

    public PersonalInformationPage(WebDriver driver) {this.driver = driver;}

    public PersonalInformationPage AssertUsername(){
        boolean status = driver.findElement(By.xpath("//*[@id='header']//a[@title='View my customer account']//span[contains(text(), 'Wellynton Moreno')]")).isDisplayed();
        Assert.assertEquals(true, status);

        return this;
    }
}
