package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {this.driver = driver;}

    public AddPaymentMethodPage CloseOrder(){
        driver.findElement(By.xpath("//*[@id='sc-buy-box-ptc-button']/span/input")).isDisplayed();
        driver.findElement(By.xpath("//*[@id='sc-buy-box-ptc-button']/span/input")).click();

        return new AddPaymentMethodPage(driver);
    }
}