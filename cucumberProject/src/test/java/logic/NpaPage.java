package logic;

import infrastructure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NpaPage extends BasePage {

    private static final By PLAYER_ARROW_BTN = By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[3]/section[1]/div/nav/div[1]/button/span/span");
    private static final By PLAYER_BTN = By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[3]/section[1]/div/nav/div[1]/ul/li[1]/a");



    private final WebElement playerArrowBtn;
    private final WebElement playerBtn;

    public NpaPage(WebDriver driver){
        super(driver);
        this.playerArrowBtn = this.driver.findElement(PLAYER_ARROW_BTN);
        this.playerBtn = this.driver.findElement(PLAYER_BTN);

    }
    public void clickOnPlayerArrowBtn() {
        executeJavaScriptClick(playerArrowBtn);
    }

    public void clickOnPlayerBtn() {
        executeJavaScriptClick(playerBtn);
    }

    private void executeJavaScriptClick(WebElement element) {
        executeJavaScript("arguments[0].click();", element);
    }

    private Object executeJavaScript(String script, Object... args) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor.executeScript(script, args);
    }


}
