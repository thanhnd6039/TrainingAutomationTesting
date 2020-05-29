package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriverWait wait;
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    @FindBy(xpath = "//span[@class='cart-item has-items']")
    private WebElement cart;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    private WebElement btnProcessToCheckout;

    public void clickOnCart(){
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){}
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='cart-item has-items']")),
                        ExpectedConditions.elementToBeClickable(cart)
                )
        );
        cart.click();
    }

    public void clickOnProcessToCheckOutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(btnProcessToCheckout));
        btnProcessToCheckout.click();
    }
}
