package cucumber.step_definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SimpleFormSteps {
    private static WebDriver driver;
    private String msg = "";
    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page(){
        String projectDirPath =  System.getProperty("user.dir");
        String driverPath = projectDirPath + "\\src\\test\\resources\\driver\\windows\\chromedriver.exe";
        String baseUrl = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("^User inputs \"(.*)\"")
    public void user_inputs_a_message(String message){
        msg = message;
        driver.findElement(By.id("user-message")).sendKeys(msg);
    }

    @When("^Click to the Show Message button$")
    public void click_to_the_Show_Message_button(){
        driver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
    }

    @Then("^Message is displayed on Home Page$")
    public void message_is_displayed_on_Home_Page() {
        String expectedMessage = msg;
        String actualMessage = driver.findElement(By.id("display")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        driver.quit();
    }

//    @When("^User inputs value for a and b$")
//    public void user_inputs_value_for_a_and_b(){
//        driver.findElement(By.id("sum1")).sendKeys("5");
//        driver.findElement(By.id("sum2")).sendKeys("5");
//    }
//
//    @When("^Click to the Get Total button$")
//    public void click_to_the_Get_Total_button() {
//        driver.findElement(By.xpath("//button[contains(text(),'Get Total')]")).click();
//    }
//
//    @Then("^Result of a and b is displayed on Home Page$")
//    public void result_of_a_and_b_is_displayed_on_Home_Page() throws InterruptedException {
//        String expectedValue = "10";
//        String actualValue = driver.findElement(By.id("displayvalue")).getText();
//        Assert.assertEquals(actualValue, expectedValue);
//        Thread.sleep(5000);
//        driver.quit();
//    }
}
