package steps;

import io.cucumber.java.en.And;
import infrastructure.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.NpaPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NpaPageSteps {
    public static Setup newDriver = null;
    private NpaPage nbaPage = null;


    @Given("I am logged in NPA site")
    public void loggedInNpaPage() {
        newDriver = new Setup();
        newDriver.setupDriver();
        newDriver.navigateToURL("https://www.nba.com/stats/leaders");
        nbaPage = new NpaPage(newDriver.getDriver());
    }

    @When("On the home page I click on player arrow btn")
    public void iClickOnPlayersArrowBtn() {
        nbaPage.clickOnPlayerArrowBtn();
    }
    @And("Click on players btn")
    public void iClickOnPlayerBtn(){
        nbaPage.clickOnPlayerBtn();
    }
    @Then("Players page appears")
    public void checkIfPlayersPageAppear() {
        WebDriverWait wait = new WebDriverWait(newDriver.getDriver(), 10);
        wait.until(ExpectedConditions.urlToBe("https://www.nba.com/stats/players/traditional"));
        assertEquals("https://www.nba.com/stats/players/traditional", newDriver.getDriver().getCurrentUrl());
    }

}