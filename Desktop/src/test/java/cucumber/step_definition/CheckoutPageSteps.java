package cucumber.step_definition;

import cucumber.api.java.en.When;
import cucumber.managers.FileReaderManager;
import cucumber.pages.CheckoutPage;
import cucumber.selenium.Wait;
import cucumber.sharing_test_context.TestContext;
import cucumber.test_data_types.Customer;

public class CheckoutPageSteps {

    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context){
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @When("^Fill \"([^\"]*)\" personal details on checkout page$")
    public void fill_personal_details_on_checkout_page(String customerName){
        Customer customer = FileReaderManager.getInstance().getJsonDataReader().getCustomerByName(customerName);
        checkoutPage.fillPersonalDetails(customer);
    }

    @When("^Place an order$")
    public void place_an_order(){
        checkoutPage.checkTermAndConditions();
        checkoutPage.clickOnPlaceOrderBtn();

    }
}
