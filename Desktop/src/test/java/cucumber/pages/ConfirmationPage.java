package cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    public ConfirmationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    private WebElement lblConfirmationdMsg;;

    public String getConfirmationMsg(){
        return lblConfirmationdMsg.getText();
    }
}
