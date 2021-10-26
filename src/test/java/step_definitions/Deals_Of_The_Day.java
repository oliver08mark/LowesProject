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


public class Deals_Of_The_Day {
private final By DealsOfTheDay =By.linkText("Deals of the Day");
private final By DailyDeals = By.xpath("//div[2]/div/div/h1[(text()='Daily Deals')]");

    private static final Logger LOGGER = LogManager.getLogger(Deals_Of_The_Day.class);
    WebDriver driver=Hooks.driver;

    @Given("a user on Home page for Deals of the day")
    public void NavigateToTheHomePage() {
        String url = ReadConfigFiles.getPropertyValues("LowesUrl");
        ActOn.browser(driver).openBrowser(url);
                   LOGGER.info("User is on the Home Page");
                    }

    @When("User click on Deals of the Day button")
    public void ClickDealsOfTheDay() {
        ActOn.wait(driver,DealsOfTheDay).waitForElementToBeVisible();
       driver.manage().deleteAllCookies();
                      ActOn.element(driver, DealsOfTheDay).click();
    LOGGER.info("User Click on Deals Of the Day");
    }

       @Then("user is navigated to the Deals of the Day page")
    public void NavigateToDealsOfTheDay() {
        ActOn.wait(driver,DailyDeals).waitForElementToBeVisible();
    boolean DailyDealsDisplayed = driver.findElement(DailyDeals).isDisplayed();
   Assert.assertTrue("Navigated to Daily Deals Page",DailyDealsDisplayed);
    LOGGER.info("user Successfully Navigated to Deals of the day page");
    ActOn.browser(driver).closeBrowser();
    }


   }
