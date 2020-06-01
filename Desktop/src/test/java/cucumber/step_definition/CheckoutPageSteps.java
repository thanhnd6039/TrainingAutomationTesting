package cucumber.step_definition;

import cucumber.api.java.en.When;
import cucumber.pages.CheckoutPage;
import cucumber.sharing_test_context.TestContext;

public class CheckoutPageSteps {

    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context){
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @When("^Fill personal details on checkout page$")
    public void fill_personal_details_on_checkout_page(){
        checkoutPage.fillPersonalDetails();
    }

    @When("^Place an order$")
    public void place_an_order(){
        checkoutPage.checkTermAndConditions();
        checkoutPage.clickOnPlaceOrderBtn();
    }
}
