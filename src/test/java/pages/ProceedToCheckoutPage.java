package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProceedToCheckoutPage {
    private WebDriver driver;

    public ProceedToCheckoutPage(WebDriver driver) {this.driver = driver;}

    public PurchaseInfoPage InsertPassword(String password){
        driver.findElement(By.id("ap_password")).sendKeys(password);

        return new PurchaseInfoPage(driver);
    }

    public ShipmentOptionsPage SelectTheShipmentType() {
        driver.findElement(By.cssSelector("input[type=\"radio\"][title=\"Entrega Padrão\"]")).isDisplayed();
        driver.findElement(By.cssSelector("input[type=\"radio\"][title=\"Entrega Padrão\"]")).click();

        return new ShipmentOptionsPage(driver);

    }

    public CartPage ChangeQuantity(){
        Actions actions = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[@id=\"spc-orders\"]/div[1]/div"));
        actions.moveToElement(we).moveToElement(driver.findElement(By.cssSelector("a[tabindex=\"0\"][class=\"a-declarative change-quantity-button a-size-mini\"]"))).click().build().perform();

        driver.findElement(By.xpath("//span[@class=\"dynamic-quantity-update\"]//input")).isDisplayed();
        driver.findElement(By.xpath("//span[@class=\"dynamic-quantity-update\"]//input")).click();

        driver.findElement(By.xpath("//span[@class=\"dynamic-quantity-update\"]//input")).isDisplayed();
        driver.findElement(By.xpath("//span[@class=\"dynamic-quantity-update\"]//input")).clear();

        driver.findElement(By.xpath("//span[@class=\"dynamic-quantity-update\"]//input")).isDisplayed();
        driver.findElement(By.xpath("//span[@class=\"dynamic-quantity-update\"]//input")).sendKeys("2");

        driver.findElement(By.cssSelector("a[tabindex=\"0\"][class=\"a-declarative update-quantity-button a-size-mini\"]")).isDisplayed();
        driver.findElement(By.cssSelector("a[tabindex=\"0\"][class=\"a-declarative update-quantity-button a-size-mini\"]")).click();

        return new CartPage(driver);
    }

}
