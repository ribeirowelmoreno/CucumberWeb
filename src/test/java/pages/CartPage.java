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

    public CartPage DeleteAnProduct(){
        driver.findElement(By.xpath("//div[@class=\"a-fixed-left-grid-col a-col-right\"]//span[@class=\"a-declarative\"]//input[@aria-label=\"Excluir Mouse Gamer PRO M5 RGB Preto FORTREK, Fortrek, Mouses\"]")).isDisplayed();
        driver.findElement(By.xpath("//div[@class=\"a-fixed-left-grid-col a-col-right\"]//span[@class=\"a-declarative\"]//input[@aria-label=\"Excluir Mouse Gamer PRO M5 RGB Preto FORTREK, Fortrek, Mouses\"]")).click();

        return this;
    }

    public CartPage ProductAddedAssert(String id, String expectedText){
        driver.findElement(By.id(id));

        Assert.assertEquals(id, expectedText);

        return this;
    }
}

