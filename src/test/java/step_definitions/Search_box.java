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

public class Search_box {
    private static final By SearchItem = By.id("search-query");
    private static final By SearchBtn = By.xpath("//*[@id='frmQuickSearch']/section/button");
    private static final By SearchResult = By.xpath("//div/div/span[1][(text()='3694272')]");

    private static Logger LOGGER = LogManager.getLogger(Search_box.class);
    WebDriver driver=Hooks.driver;

    @Given("a user on the Home page")
    public void NavigatedToHomePage() {
        String url = ReadConfigFiles.getPropertyValues("LowesUrl");
        ActOn.browser(driver).openBrowser(url);
        LOGGER.info("User is on the Home Page");
    }
    @When("user write product name at the search box")
    public void WriteProductCodeAtTheSearchBox() {
        String Product = ReadConfigFiles.getPropertyValues("ProductID");
        ActOn.element(driver, SearchItem).setValue(Product);
        driver.manage().deleteAllCookies();

    }
    @When("user click on search button")
    public void ClickOnSearchBtn() {
        ActOn.element(driver, SearchBtn).click();
    }

    @Then("user is navigated to the search result page")
    public void NavigatedToTheSearchResultPage() {
        boolean ProductDisplayed = driver.findElement(SearchResult).isDisplayed();
        Assert.assertTrue("Product shown on the search Result",ProductDisplayed);
        LOGGER.info("User successfully see product on the search result");
        ActOn.browser(driver).closeBrowser();
    }

}
