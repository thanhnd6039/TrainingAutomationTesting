package cucumber.step_definition;

import cucumber.api.java.en.When;
import cucumber.pages.CartPage;
import cucumber.sharing_test_context.TestContext;

public class CartPageSteps {

    TestContext testContext;
    CartPage cartPage;

    public CartPageSteps(TestContext context){
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @When("^Move to checkout form mini cart$")
    public void move_to_checkout_form_mini_cart(){
        cartPage.clickOnCart();
        cartPage.clickOnProcessToCheckOutBtn();
    }
}
