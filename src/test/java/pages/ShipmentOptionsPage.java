package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShipmentOptionsPage {
    private WebDriver driver;
    public ShipmentOptionsPage(WebDriver driver) {this.driver = driver;}

    public ShipmentOptionsPage SelectShipmentExpress(){
        driver.findElement(By.id("order_0_ShippingSpeed_Exp BR Dom 1")).click();

        return this;
    }

    public ShipmentOptionsPage SelectShipmentDefault(){
        driver.findElement(By.id("order_0_ShippingSpeed_Std Dom 9")).click();

        return this;
    }

    public PaymentPage PressContinue(){
        WebElement button = driver.findElements(By.xpath("//*[@id='shippingOptionFormId']//span//input[@class='a-button-text']")).get(1);
        button.click();

        return new PaymentPage(driver);
    }


}
