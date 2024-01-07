package steps;

import infrastructure.Setup;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.NpaTeamPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NpaTeamSteps {

    public static Setup newDriver = null;
    private NpaTeamPage npateampage = null;


    @Given("User is on the leaders teams page")
    public void loggedInNpaPage() {
        newDriver = new Setup();
        newDriver.setupDriver();
        newDriver.navigateToURL("https://www.nba.com/stats/teams/traditional");
        npateampage = new NpaTeamPage(newDriver.getDriver());
    }

    @When("Filter list by season {string}")
    public void filtersBySeason(String Season) throws InterruptedException {
        npateampage.selectSeason(Season);
        Thread.sleep(3000);
    }

    @Then("Verify the top team is {string}")
    public void verifyTopTeam(String TopPlayer) {
        String actualTopTeam = npateampage.getTopTeamName();
        assertEquals(actualTopTeam, TopPlayer);
    }

    @After
    public void tearDown() {
        if (newDriver != null) {
            newDriver.closeDriver();
        }
    }
}
