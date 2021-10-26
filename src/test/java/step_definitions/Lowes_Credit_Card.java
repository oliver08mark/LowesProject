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

public class Lowes_Credit_Card {

    private final By LowesCreditCard =By.linkText("Lowe's Credit Cards");
    private final By LowesCreditCardPage = By.xpath("//*[@id='app']/div[2]/div/div/h1");

    private static final Logger LOGGER = LogManager.getLogger(Gift_Zone.class);
    WebDriver driver= Hooks.driver;

    @Given("a user on the Lowes Home page for Credit Card Feature")
    public void NavigateToHomePageForCreditCardFeature() {
        String url = ReadConfigFiles.getPropertyValues("LowesUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("User is on the Home Page");
    }

    @When("user click on Lowes Credit Card button")
    public void ClickOnLowesCreditCardButton() {
        ActOn.wait(driver,LowesCreditCard).waitForElementToBeVisible();
        driver.manage().deleteAllCookies();
        ActOn.element(driver, LowesCreditCard).click();
        LOGGER.info("User Click on Lowe's Credit Card");
    }

    @Then("user is navigated to the Lowes Credit Card page")
    public void NavigatedToTheLowesCreditCardPage() {
        ActOn.wait(driver,LowesCreditCardPage).waitForElementToBeVisible();
        boolean LowesCreditCardDisplayed = driver.findElement(LowesCreditCardPage).isDisplayed();
        Assert.assertTrue("Navigated to Lowes Credit Card page",LowesCreditCardDisplayed);
        LOGGER.info("user Successfully Navigated to Lowes Credit Card page");
        ActOn.browser(driver).closeBrowser();
    }
}
