package cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage {
    WebDriverWait wait;
    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    @FindBy(xpath = ".//*[@class='noo-product-inner']")
    private List<WebElement> productList;

    @FindBy(id = "pa_color")
    private WebElement colorOption;

    @FindBy(id = "pa_size")
    private WebElement sizeOption;

    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    private WebElement btnAddToCart;

    public void selectProduct(int productNumber){
        productList.get(productNumber).click();
    }

    public void clickOnAddToCardBtn(){
        Select color = new Select(colorOption);
        color.selectByValue("white");
        Select size = new Select(sizeOption);
        size.selectByValue("medium");
        btnAddToCart.click();
    }

}
