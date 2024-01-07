package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import infrastructure.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import logic.NpaPlayersPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NpaPlayersSteps {
    public static Setup newDriver = null;
    private NpaPlayersPage npaplayerpage = null;


    @Given("User is on NPA players page")
    public void loggedInNpaPage() {
        newDriver = new Setup();
        newDriver.setupDriver();
        newDriver.navigateToURL("https://www.nba.com/stats/players/traditional");
        npaplayerpage = new NpaPlayersPage(newDriver.getDriver());
    }

    @When("User filters by season {string}")
    public void filtersBySeason(String Season) throws InterruptedException {
        npaplayerpage.selectSeason(Season);
        Thread.sleep(3000);
    }

    @Then("Verify the top player is {string}")
    public void verifyTopTeam(String TopPlayer) {
        String actualTopPlayer = npaplayerpage.getTopPlayerName();
        assertEquals(actualTopPlayer, TopPlayer);
    }

    @And("sorts by {string}")
    public void verifyTopPlayerPint(String Point) {
        String actualPlayerPoint = npaplayerpage.getPlayerPoint();
        assertEquals(actualPlayerPoint, Point);
    }

    @After
    public void tearDown() {
        if (newDriver != null) {
            newDriver.closeDriver();
        }

    }
}