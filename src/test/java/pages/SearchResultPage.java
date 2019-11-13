package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {this.driver = driver;}

    public ProductPage ClickingOnProduct(String product){
        driver.findElement(By.xpath(product)).isDisplayed();
        driver.findElement(By.xpath(product)).click();

        return new ProductPage(driver);
    }
}
