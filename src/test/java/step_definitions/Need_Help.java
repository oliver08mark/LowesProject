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

public class Need_Help {

    private final By NeedHelpBtn =By.linkText("Need Help?");

    private static final Logger LOGGER = LogManager.getLogger(Need_Help.class);
    WebDriver driver= Hooks.driver;

    @Given("a user on the Home page for Need Help Features")
    public void NavigateToHomePageForNeedHelpFeatures() {
        String url = ReadConfigFiles.getPropertyValues("LowesUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("User is on the Home Page");
    }
    @When("user click on Need Help button")
    public void ClickOnNeedHelpButton() {
        ActOn.wait(driver,NeedHelpBtn).waitForElementToBeVisible();
        driver.manage().deleteAllCookies();
        ActOn.element(driver, NeedHelpBtn).click();
        LOGGER.info("User Click on Need Help");
    }
    @Then("user is navigated to the Need Help page")
    public void NavigatedToTheNeedHelpPage() {
        String Actual = driver.getTitle();
        String Expected = "Contact Us & Customer Service FAQ";
        Assert.assertEquals(Expected,Actual);
        LOGGER.info("user Successfully Navigated to Need Help page");
        ActOn.browser(driver).closeBrowser();
    }
}
