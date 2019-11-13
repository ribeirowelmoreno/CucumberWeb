package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LogInPage;
import pages.LoggedPage;
import pages.MainPage;
import pages.PersonalInformationPage;
import support.Web;

import java.net.MalformedURLException;

public class LoginSteps {
    private WebDriver driver;

    MainPage mMainPage;
    LogInPage mLogInPage;
    LoggedPage mLoggedPage;
    PersonalInformationPage mPersonalInformationPage;

    @Before
    public void setUP() {
        driver = Web.createChrome();
    }

    @Given("user in main page")
    public void user_in_main_page() {
        mMainPage.ClickInLogIn();
    }

    @When("insert the correct usermane")
    public void insert_the_correct_usermane() {
        mLogInPage.InsertEmail();
    }

    @When("insert the correct password")
    public void insert_the_correct_password() {
        mLogInPage.InsertPassword();
        mLogInPage.SubmitSignIn();
    }

    @Then("user page should be showed")
    public void user_page_should_be_showed() {
        mPersonalInformationPage.AssertUsername();
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }
}
