package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddPaymentMethodPage {
    private WebDriver driver;

    public AddPaymentMethodPage(WebDriver driver) {this.driver = driver;}

    public AddPaymentMethodPage SelectCreditCard(){
        driver.findElement(By.xpath("//*[@id='sc-buy-box-ptc-button']/span/input//*[@id='pm_0']")).isDisplayed();
        driver.findElement(By.xpath("//*[@id='sc-buy-box-ptc-button']/span/input//*[@id='pm_0']")).click();

        return this;
    }

    public BillingAddressPage ClickingOnBillingAddress(){
        driver.findElement(By.xpath("//*[@id='order-summary-container']/div/div/div/div[1]/span")).isDisplayed();
        driver.findElement(By.xpath("//*[@id='order-summary-container']/div/div/div/div[1]/span")).click();

        return new BillingAddressPage(driver);
    }
}

