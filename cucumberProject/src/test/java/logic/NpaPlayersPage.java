package logic;

import infrastructure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NpaPlayersPage extends BasePage {

    private static final By SEASON_ARROW_BTN = By.xpath("(//div/label/div/select/option[@value='2023-24'])/ancestor::select");

    private final By PLAYER_POINT = By.xpath("//table[@class='Crom_table__p1iZz']/tbody/tr[1]/td[9]");

    private final By FIRST_PLAYER = By.xpath("//table[@class='Crom_table__p1iZz']/tbody/tr[1]/td[2]/a");


    private final WebElement SeasonArrowBtn;

    public NpaPlayersPage(WebDriver driver){
        super(driver);
        this.SeasonArrowBtn = this.driver.findElement(SEASON_ARROW_BTN);

    }

public void selectSeason(String seasonYear) {
    new WebDriverWait(driver,10 ).until(ExpectedConditions.elementToBeClickable(SeasonArrowBtn)).click();
    By optionLocator = By.xpath("//div/label/div/select/option[@value='" + seasonYear + "']");
    driver.findElement(optionLocator).click();
}
    public String getPlayerPoint (){
        WebElement playerPointElement = driver.findElement(PLAYER_POINT);
        return playerPointElement.getText();
    }

    public String getTopPlayerName(){
        WebElement topPlayerElement = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(FIRST_PLAYER));
        return topPlayerElement.getText();
    }

}
