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

public class Weekly_Ad {
    private final By WeekyAdBtn =By.linkText("Weekly Ad");

    private static final Logger LOGGER = LogManager.getLogger(Weekly_Ad.class);
    WebDriver driver= Hooks.driver;

    @Given("a user on the Home page for Weekly Ad Page")
    public void NavigateToHomePageForWeeklyAd() {
        String url = ReadConfigFiles.getPropertyValues("LowesUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("User is on the Home Page");
    }
    @When("user click on Weekly Ad")
    public void ClickOnWeeklyAd() {
        ActOn.wait(driver,WeekyAdBtn).waitForElementToBeVisible();
        driver.manage().deleteAllCookies();
        ActOn.element(driver, WeekyAdBtn).click();
        LOGGER.info("User Click on Weekly Ad");

    }
    @Then("user is navigated to the Weekly Ad")
    public void NavigatedToTheWeeklyAdPage() {
        String Actual = driver.getTitle();
        String Expected = "Lowe's Weekly Ad - Your Local Store";
        Assert.assertEquals(Expected,Actual);
        LOGGER.info("user Successfully Navigated to Weekly Ad page");
        ActOn.browser(driver).closeBrowser();
    }

}
