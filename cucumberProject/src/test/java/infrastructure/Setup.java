package infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {

    private static final String driverPATH = "C:\\Users\\LENOVO\\OneDrive\\_____ ______\\cucumberProject1\\chromedriver.exe";
    private static WebDriver driver;

    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", driverPATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){

        return this.driver;
    }

    public void closeDriver(){

        driver.close();
    }

    public void navigateToURL(String URL) {

        driver.get(URL);
    }

}

