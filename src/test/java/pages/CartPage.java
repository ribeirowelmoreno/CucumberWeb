package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {this.driver = driver;}

    public CartPage ChooseQuantity(Integer index){
        Select quantity = new Select(driver.findElement(By.id("//*[@id=\"a-autoid-0-announce\"]")));
        quantity.selectByIndex(index);

        return this;
    }

    public CartPage DeleteAnProduct(String product){
        driver.findElement(By.xpath(product)).isDisplayed();
        driver.findElement(By.xpath(product)).click();

        return this;
    }

    public CartPage ProductAddedAssert(String id, String expectedText){
        driver.findElement(By.id(id));

        Assert.assertEquals(id, expectedText);

        return this;
    }

    public CartPage ProductHasBeenDeleted(String deleteMessage, String expectedMessage){
        driver.findElement(By.xpath(deleteMessage));

        Assert.assertEquals(deleteMessage, expectedMessage);

        return this;
    }
}

