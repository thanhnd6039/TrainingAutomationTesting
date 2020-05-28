package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    public static void main(String[] args) throws InterruptedException {
        String projectDirPath =  System.getProperty("user.dir");
        String driverPath = projectDirPath + "\\src\\test\\resources\\driver\\windows\\chromedriver.exe";
        String baseUrl = "http://shop.demoqa.com/";
        String searchStr = "?s=dress&post_type=product";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15);
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='single_add_to_cart_button button alt']")));
        WebElement btnAddToCart = driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']"));
        btnAddToCart.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='cart-item has-items']")));
        WebElement cart = driver.findElement(By.xpath("//span[@class='cart-item has-items']"));
        cart.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='checkout-button button alt wc-forward']")));
        WebElement btnProcessToCheckout = driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']"));
        btnProcessToCheckout.click();

        WebElement txtFirstName = driver.findElement(By.id("billing_first_name"));
        WebElement txtLastName = driver.findElement(By.id("billing_last_name"));
        WebElement txtCompanyName = driver.findElement(By.id("billing_company"));


        txtFirstName.sendKeys("Thanh");
        txtLastName.sendKeys("Nguyen Duc");
        txtCompanyName.sendKeys("FreshCompany");
        WebElement cboCountry = driver.findElement(By.id("select2-billing_country-container"));
        cboCountry.click();
        List<WebElement> countryList = driver.findElements(By.xpath("//ul/li[@class='select2-results__option']"));

        for (WebElement country: countryList){
            if (country.getText().equals("India")){
                country.click();
                Thread.sleep(3000);
                break;
            }
        }

        WebElement txtStreetAddress = driver.findElement(By.id("billing_address_1"));
        txtStreetAddress.sendKeys("86/34/11 Thong Nhat Street");
        WebElement txtCity = driver.findElement(By.id("billing_city"));
        txtCity.sendKeys("Minto Road");
        WebElement cboState = driver.findElement(By.id("select2-billing_state-container"));
        cboState.click();
        List<WebElement> stateList = driver.findElements(By.xpath("//ul/li[@class='select2-results__option']"));
        for (WebElement state: stateList){
            if(state.getText().equals("Delhi")){
                state.click();
                Thread.sleep(3000);
                break;
            }
        }


        WebElement txtPostCode = driver.findElement(By.id("billing_postcode"));
        txtPostCode.sendKeys("110002");
        WebElement txtPhone = driver.findElement(By.id("billing_phone"));
        txtPhone.sendKeys("123456789");
        WebElement txtEmailAddress = driver.findElement(By.id("billing_email"));
        txtEmailAddress.sendKeys("thanh1@gmail.com");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("terms")));
        WebElement chkAccept = driver.findElement(By.id("terms"));
        chkAccept.click();
        WebElement btnPlaceOrder = driver.findElement(By.id("place_order"));
        btnPlaceOrder.click();


//        driver.quit();
    }
}
