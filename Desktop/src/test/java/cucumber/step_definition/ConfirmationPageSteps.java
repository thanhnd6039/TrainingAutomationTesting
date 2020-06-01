package cucumber.step_definition;

import cucumber.api.java.en.Then;
import cucumber.pages.ConfirmationPage;
import cucumber.sharing_test_context.TestContext;
import org.testng.Assert;

public class ConfirmationPageSteps {

    TestContext testContext;
    ConfirmationPage confirmationPage;

    public ConfirmationPageSteps(TestContext context){
        testContext = context;
        confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
    }

    @Then("^Show a message successful order$")
    public void show_a_message_successful_order(){
        String actualConfirmationMsg = confirmationPage.getConfirmationMsg();
        String expectedConfirmationMsg = "Thank you. Your order has been received.";
        Assert.assertEquals(actualConfirmationMsg, expectedConfirmationMsg);
    }
}
