package cucumber.step_definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.data_providers.ConfigFileReader;
import cucumber.managers.PageObjectManager;
import cucumber.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutSteps {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;
    private PageObjectManager pageObjectManager;
    private ConfigFileReader configFileReader;


    @Given("^User is on home page$")
    public void user_is_on_home_page(){
        configFileReader = new ConfigFileReader();
        String baseUrl = configFileReader.geturl();
        String driverPath = configFileReader.getDriverPath();
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.navigateToHomePage(baseUrl);
    }

    @When("^He searches for dress$")
    public void he_searches_for_dress(){
        String searchStr = "?s=dress&post_type=product";
        homePage.searchProduct(searchStr);
    }

    @When("^Choose to buy the first item$")
    public void choose_to_buy_the_first_item(){
        productPage = pageObjectManager.getProductPage();
        productPage.selectProduct(0);
        productPage.clickOnAddToCardBtn();
    }

    @When("^Move to checkout form mini cart$")
    public void move_to_checkout_form_mini_cart(){
        cartPage = pageObjectManager.getCartPage();
        cartPage.clickOnCart();
        cartPage.clickOnProcessToCheckOutBtn();
    }

    @When("^Fill personal details on checkout page$")
    public void fill_personal_details_on_checkout_page() throws InterruptedException {
        checkoutPage = pageObjectManager.getCheckoutPage();
        checkoutPage.fillPersonalDetails();
    }

    @When("^Place an order$")
    public void place_an_order(){
        checkoutPage.checkTermAndConditions();
        checkoutPage.clickOnPlaceOrderBtn();
    }

    @Then("^Show a message successful order$")
    public void show_a_message_successful_order(){
        confirmationPage = pageObjectManager.getConfirmationPage();
        String actualConfirmationMsg = confirmationPage.getConfirmationMsg();
        String expectedConfirmationMsg = "Thank you. Your order has been received.";
        Assert.assertEquals(actualConfirmationMsg, expectedConfirmationMsg);
        driver.quit();
    }
}
