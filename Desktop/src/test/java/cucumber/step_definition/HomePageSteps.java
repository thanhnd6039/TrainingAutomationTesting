package cucumber.step_definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.managers.FileReaderManager;
import cucumber.managers.PageObjectManager;
import cucumber.managers.WebDriverManager;
import cucumber.pages.HomePage;
import cucumber.selenium.Wait;
import cucumber.sharing_test_context.TestContext;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    HomePage homePage;
    TestContext testContext;


    public HomePageSteps(TestContext context){
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }
    @Given("^User is on home page$")
    public void user_is_on_home_page(){
        String baseUrl = FileReaderManager.getInstance().getConfigReader().geturl();
        homePage.navigateToHomePage(baseUrl);
    }

    @When("^He searches for dress$")
    public void he_searches_for_dress(){
        String searchStr = "?s=dress&post_type=product";
        homePage.searchProduct(searchStr);
    }
}
