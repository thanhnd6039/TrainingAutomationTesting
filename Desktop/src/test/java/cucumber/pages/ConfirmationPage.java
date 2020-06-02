package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class ConfirmationPage {

    public ConfirmationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    private WebElement lblConfirmationdMsg;;

    @FindBy(how = How.CSS, using = ".order_item")
    private List<WebElement> productList;

    public List<String> getProductNames(){
        List<String> productNames = new ArrayList<>();
        for (WebElement element: productList){
            productNames.add(element.findElement(By.cssSelector(".product-name")).getText());
        }
        return productNames;
    }

    public String getConfirmationMsg(){
        return lblConfirmationdMsg.getText();
    }
}
