package cucumber.step_definition;

import cucumber.api.java.en.Then;
import cucumber.enums.Context;
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
        String productName = (String) testContext.getScenarioContext().getContext(Context.PRODUCTNAME);
        System.out.println("111111productName: "+productName);
        System.out.println("222222: "+confirmationPage.getProductNames().stream().filter(x -> x.contains("WHITE")).findFirst().get());
//        Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.contains(productName)).findFirst().get().length() > 0);
    }
}
