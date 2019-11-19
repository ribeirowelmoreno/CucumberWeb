package stepDefinitions;

import cucumber.api.java.eo.Se;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.*;
import support.Web;

public class PurchaseSimulatorSteps {
    private WebDriver driver;

    @Before
    public void setUP(){
        driver = Web.createChrome();
    }

    @Given("user click in Faca seu Login")
    public void user_click_in_Faca_seu_Login() {
    new MainPage(driver)
            .StartLogin();
}

    @When("insert the correct {string} and {string}")
    public void insert_the_correct_and(String email, String password) {
    new MainPage(driver)
        .InsertEmailAndContinue(email, password);
    }

    @And("search for some {string}")
    public void search_for_some(String product) {
        new SignInPage(driver)
                .SearchForSomeProduct(product);
    }

    @And("click on first found product")
    public void click_on_first_found_product() {
        new SearchResultPage(driver)
                .ClickingOnProduct("//*[@id=\"search\"]//span[contains(text(), \"Celular Apple iPhone 11 Pro 64gb / Tela 5.8'' / 12MP / iOS 13\")]");
    }

    @And("click on second found product")
    public void click_on_second_found_product() {
        new SearchResultPage(driver)
                .ClickingOnProduct("//*[@id=\"search\"]//h2//span[contains(text(), \"Mouse Gamer PRO M5 RGB Preto FORTREK, Fortrek, Mouses\")]");
    }

    @And("change the quantity")
    public void change_the_quantity() {
        new ProceedToCheckoutPage(driver)
                .ChangeQuantity();
    }

    @And("add the product to cart")
    public void add_the_product_to_cart() {
    new ProductPage(driver)
            .AddingProductToCart();
    }

    @And("click on cart icon")
    public void click_on_cart_icon() {
        new MainPage(driver)
                .ClickOnCartIcon();
    }

    @And("delete the product")
    public void delete_the_product() {
        new CartPage(driver)
                .DeleteAnProduct("//div[@class=\"a-row sc-action-links\"]//span[@class=\"a-size-small sc-action-delete\"]//input[@aria-label=\"Excluir Geladeira Consul Frost Free Duplex 405 litros cor Inox com Filtro Bem Estar - 220V\"]");
    }

    @When("click on third found product")
    public void click_on_third_found_product() {
        new SearchResultPage(driver)
                .ClickingOnProduct("//*[@id=\"search\"]//h2//span[contains(text(), \"Geladeira Consul Frost Free Duplex 405 litros cor Inox com Filtro Bem Estar - 220V\")]");
    }

    @Then("I should see the product on the cart")
    public void i_should_see_the_product_on_the_cart() {
        new CartPage(driver)
                .ProductAddedAssert("spc-orders", "spc-orders");
    }

    @Then("proceed to checkout")
    public void proceed_to_checkout() {
        new AddToCartPage(driver)
            .ProceedToCheckout();
    }

    @Then("I should see the quantity was been changed")
    public void i_should_see_the_quantity_was_been_changed() {
        new ProceedToCheckoutPage(driver)
                .QuantityChangedAssert("//*[@id=\"spc-orders\"]//div/span[@class=\"quantity-display\"]", "//*[@id=\"spc-orders\"]//div/span[@class=\"quantity-display\"]");
    }

    @Then("I make sure the product was been deleted")
    public void i_make_sure_the_product_was_been_deleted() {
        new CartPage(driver)
                .ProductHasBeenDeleted("//*[@id=\"sc-item-C250c1557-69d4-405b-a031-0580ec676348\"]", "//*[@id=\"sc-item-C250c1557-69d4-405b-a031-0580ec676348\"]");
    }

    @Then("close browser")
    public void close_browser() {
    driver.quit();
    }
}
