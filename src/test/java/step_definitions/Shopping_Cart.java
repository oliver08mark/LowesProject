package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

public class Shopping_Cart {

    private final By CartBtn =By.xpath("//div[3]/a/span/span[2][(text()='Cart')]");

    private static final Logger LOGGER = LogManager.getLogger(Savings.class);
    WebDriver driver= Hooks.driver;


    @Given("a user on the Home page for Shopping Cart")
    public void NavigateToHomePageForShoppingCart() {
        String url = ReadConfigFiles.getPropertyValues("LowesUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("User is on the Home Page");
    }

    @When("user click on Cart button")
    public void ClickOnCartButton() {
        ActOn.wait(driver,CartBtn).waitForElementToBeVisible();
        driver.manage().deleteAllCookies();
        ActOn.element(driver, CartBtn).click();
        LOGGER.info("User Click on Cart Button");
    }
    @Then("user is Navigated to the Cart page")
    public void user_is_navigated_to_the_cart_page() {
        String Actual = driver.getTitle();
        String Expected = "Shopping Cart - Lowes.com";
        Assert.assertEquals(Expected,Actual);
        LOGGER.info("user Successfully Navigated to Cart page");
        ActOn.browser(driver).closeBrowser();
    }
}
