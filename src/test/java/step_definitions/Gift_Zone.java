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

public class Gift_Zone {

    private final By GiftZone =By.linkText("Gift Zone");
    private final By GiftIdeasPage = By.xpath("//*[@id='app']/div[2]/div/div/h1");

    private static final Logger LOGGER = LogManager.getLogger(Gift_Zone.class);
    WebDriver driver= Hooks.driver;

    @Given("a user on the Home page for Gift Zone Features")
    public void NavigateToHomePageForGiftZone() {
        String url = ReadConfigFiles.getPropertyValues("LowesUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("User is on the Home Page");

    }


    @When("user click on Gift Zone button")
    public void LookForGiftZoneButton() {
        ActOn.wait(driver,GiftZone).waitForElementToBeVisible();
        driver.manage().deleteAllCookies();
        ActOn.element(driver, GiftZone).click();
        LOGGER.info("User Click on Gift Zone");
        }


    @Then("user is navigated to the Gift Idea page")
    public void NavigateToGiftZonePage() {
        ActOn.wait(driver,GiftIdeasPage).waitForElementToBeVisible();
        boolean GiftIdeasDisplayed = driver.findElement(GiftIdeasPage).isDisplayed();
        Assert.assertTrue("Navigated to Gift Ideas page",GiftIdeasDisplayed);
        LOGGER.info("user Successfully Navigated to Gift Ideas page");
        ActOn.browser(driver).closeBrowser();
    }
}
