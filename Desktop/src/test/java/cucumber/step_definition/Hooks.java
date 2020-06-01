package cucumber.step_definition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.sharing_test_context.TestContext;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context){
        testContext = context;
    }

    @Before
    public void setup(){

    }

    @After
    public void tearDown(){
//        testContext.getWebDriverManager().closeDriver();
    }
}
