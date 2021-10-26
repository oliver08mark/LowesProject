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


public class Hand_Tools {
    private final By ToolsBtn =By.linkText("Tools");
    private final By HandToolsBtn =By.linkText("Hand Tools");


    private static final Logger LOGGER = LogManager.getLogger(Need_Help.class);
    WebDriver driver= Hooks.driver;

    @Given("a user on the Home page for Hand Tools")
    public void NavigatedToTheHomePageForHandTools() {
                String url = ReadConfigFiles.getPropertyValues("LowesUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("User is on the Home Page");

    }
    @When("click on Tools Button")
    public void ClickOnToolsButton() {
        ActOn.wait(driver,ToolsBtn).waitForElementToBeVisible();
        driver.manage().deleteAllCookies();
        ActOn.element(driver, ToolsBtn).click();
        LOGGER.info("User Click on Tools Button");
    }
    @When("Click on Hand Tools Button")
    public void ClickOnHandToolsButton() {
        ActOn.wait(driver,HandToolsBtn).waitForElementToBeVisible();
        driver.manage().deleteAllCookies();
        ActOn.element(driver, HandToolsBtn).click();
        LOGGER.info("User Click on Hand Tools Button");
    }
    @Then("user is navigated to the Hand Tools page")
    public void NavigatedToTheHandToolsPage() {
        String Actual = driver.getTitle();
        String Expected = "Black Friday Hand Tools Deals 2021 - Lowes.com";
        Assert.assertEquals(Expected,Actual);
        LOGGER.info("user Successfully Navigated to Hand Tools page");
        ActOn.browser(driver).closeBrowser();
    }

}
