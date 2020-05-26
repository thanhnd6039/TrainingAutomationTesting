package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    private static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        String projectDirPath =  System.getProperty("user.dir");
        String driverPath = projectDirPath + "\\src\\test\\resources\\driver\\windows\\chromedriver.exe";
        String baseUrl = "http://shop.demoqa.com/";
        String searchStr = "?s=dress&post_type=product";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.navigate().to(baseUrl+searchStr);
        List<WebElement> items = driver.findElements(By.xpath(".//*[@class='noo-product-inner']"));
        items.get(0).click();
        WebElement colorOption = driver.findElement(By.id("pa_color"));
        Select color = new Select(colorOption);
        color.selectByValue("white");
        WebElement sizeOption = driver.findElement(By.id("pa_size"));
        Select size = new Select(sizeOption);
        size.selectByValue("medium");
        Thread.sleep(3000);
        driver.quit();
    }
}
