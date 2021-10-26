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

public class Savings {

    private final By SavingsBtn =By.linkText("Savings");
private final By SavingsPage = By.xpath("//*[@id='app']/div[2]/div/div/h1[(text()='Savings')]");
    private static final Logger LOGGER = LogManager.getLogger(Savings.class);
    WebDriver driver= Hooks.driver;

    @Given("a user on the Home page for Savings")
    public void NavigateToHomePageForSavings() {
        String url = ReadConfigFiles.getPropertyValues("LowesUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("User is on the Home Page");
    }

    @When("click on Savings button")
    public void ClickOnSavingsButton() {
        ActOn.wait(driver,SavingsBtn).waitForElementToBeVisible();
        driver.manage().deleteAllCookies();
        ActOn.element(driver, SavingsBtn).click();
        LOGGER.info("User Click on Savings");
    }
    @Then("user is navigated to the Savings page")
    public void NavigatedToTheSavingsPage() {
        ActOn.wait(driver,SavingsPage).waitForElementToBeVisible();
        boolean SavingsPge = driver.findElement(SavingsPage).isDisplayed();
        Assert.assertTrue("Navigated to Holiday Decorations page",SavingsPge);
        LOGGER.info("user Successfully Navigated to Savings page");
        ActOn.browser(driver).closeBrowser();
    }

}
