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

public class Holiday_Decorations {

    private final By HolidayDecorations =By.linkText("Holiday Decorations");
    private final By HolidayDecorationsPage = By.xpath("//*[@id='app']/div[2]/div/div/h1");

    private static final Logger LOGGER = LogManager.getLogger(Gift_Zone.class);
    WebDriver driver= Hooks.driver;

    @Given("a user on the Home page for Holiday Decorations")
    public void NavigateToHomePageForHolidayDecorations() {
        String url = ReadConfigFiles.getPropertyValues("LowesUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("User is on the Home Page");
    }
    @When("user click on Holiday Decorations button")
    public void ClickOnHolidayDecorationsButton() {
        ActOn.wait(driver,HolidayDecorations).waitForElementToBeVisible();
        driver.manage().deleteAllCookies();
        ActOn.element(driver, HolidayDecorations).click();
        LOGGER.info("User Click on Holiday Decorations");

    }
    @Then("user is Navigated to the Holiday Decorations page")
    public void NavigateToHolidayDecorationsPage() {
        ActOn.wait(driver,HolidayDecorationsPage).waitForElementToBeVisible();
        boolean HolidayDecoration = driver.findElement(HolidayDecorationsPage).isDisplayed();
        Assert.assertTrue("Navigated to Holiday Decorations page",HolidayDecoration);
        LOGGER.info("user Successfully Navigated to Holiday Decorations page");
        ActOn.browser(driver).closeBrowser();
    }


}
