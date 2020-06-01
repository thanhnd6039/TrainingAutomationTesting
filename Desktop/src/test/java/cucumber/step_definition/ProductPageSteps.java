package cucumber.step_definition;

import cucumber.api.java.en.When;
import cucumber.pages.ProductPage;
import cucumber.sharing_test_context.TestContext;

public class ProductPageSteps {
    TestContext testContext;
    ProductPage productPage;
    public ProductPageSteps(TestContext context){
        testContext = context;
        productPage = testContext.getPageObjectManager().getProductPage();
    }

    @When("^Choose to buy the first item$")
    public void choose_to_buy_the_first_item(){
        productPage.selectProduct(0);
        productPage.clickOnAddToCardBtn();
    }
}
