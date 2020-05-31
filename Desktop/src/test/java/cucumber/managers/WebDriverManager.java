package cucumber.managers;

import cucumber.enums.DriverType;
import cucumber.enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";

    public WebDriverManager(){
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver(){
        if (driver == null){
            driver = createDriver();
        }
        return driver;
    }

    private WebDriver createDriver(){
        switch (environmentType){
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createLocalDriver(){
        String driverPath = FileReaderManager.getInstance().getConfigReader().getDriverPath();
        switch (driverType){
            case CHROME:
                driverPath += "chromedriver.exe";
                System.setProperty(CHROME_DRIVER_PROPERTY, driverPath);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driverPath += "geckodriver.exe";
                System.setProperty(FIREFOX_DRIVER_PROPERTY, driverPath);
                driver = new FirefoxDriver();
                break;
            case INTERNETEXPLORER:
                driverPath += "IEDriverServer.exe";
                System.setProperty(FIREFOX_DRIVER_PROPERTY, driverPath);
                driver = new InternetExplorerDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver(){
        throw new RuntimeException("RemoteWebDriver is not implemented");
    }

    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}
