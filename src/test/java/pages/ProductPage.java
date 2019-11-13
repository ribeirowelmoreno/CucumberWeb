package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {this.driver = driver;}

    public AddToCartPage AddingProductToCart(){
        driver.findElement(By.id("add-to-cart-button")).click();
        WebElement productAdded = driver.findElement(By.xpath("//*[@id='huc-v2-order-row-confirm-text']//h1[contains(text(), 'Adicionado ao carrinho')]"));
        productAdded.isDisplayed();

        return new AddToCartPage(driver);
    }
}
