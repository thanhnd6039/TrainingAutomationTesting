package cucumber.pages;

import org.apache.commons.validator.routines.EmailValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutPage {

    WebDriverWait wait;
    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(id = "billing_first_name")
    private WebElement txtFirstName;

    @FindBy(id = "billing_last_name")
    private WebElement txtLastName;

    @FindBy(id = "billing_company")
    private WebElement txtCompanyName;

    @FindBy(id = "select2-billing_country-container")
    private WebElement cboCountry;

    @FindBy(xpath = "//ul/li[@class='select2-results__option']")
    private List<WebElement> countryList;

    @FindBy(id = "billing_address_1")
    private WebElement txtStreetAddress;

    @FindBy(id = "billing_city")
    private WebElement txtCity;

    @FindBy(id = "select2-billing_state-container")
    private WebElement cboState;

    @FindBy(xpath = "//ul/li[@class='select2-results__option']")
    private List<WebElement> stateList;

    @FindBy(id = "billing_postcode")
    private WebElement txtPostCode;

    @FindBy(id = "billing_phone")
    private WebElement txtPhone;

    @FindBy(id = "billing_email")
    private WebElement txtEmailAddress;

    @FindBy(id = "terms")
    private WebElement chkAccept;

    @FindBy(id = "place_order")
    private WebElement btnPlaceOrder;



    public void setFirstName(String name){
        txtFirstName.sendKeys(name);
    }

    public void setLastName(String name){
        txtLastName.sendKeys(name);
    }

    public void setCompanyName(String name){
        txtCompanyName.sendKeys(name);
    }

    public void setCountryName(String countryName){
        cboCountry.click();
        for (WebElement country: countryList){
            if (country.getText().equals(countryName)){
                country.click();
                try { Thread.sleep(3000);}
                catch (InterruptedException e) {}
                break;
            }
        }
    }

    public void setStreetAddress(String address){
        txtStreetAddress.sendKeys(address);
    }

    public void setCity(String cityName){
        txtCity.sendKeys(cityName);
    }

    public void setState(String stateName){
        cboState.click();
        for (WebElement state: stateList){
            if (state.getText().equals(stateName)){
                state.click();
                try { Thread.sleep(3000); }
                catch (InterruptedException e){}
                break;
            }
        }
    }

    public void setPostCode(String postCode){
        txtPostCode.sendKeys(postCode);
    }

    public void setPhone(String phoneNumber){
        txtPhone.sendKeys(phoneNumber);
    }

    public void setEmail(String email){
        txtEmailAddress.sendKeys(email);
    }

    public void checkTermAndConditions(){
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){}
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.presenceOfElementLocated(By.id("terms")),
                        ExpectedConditions.visibilityOfElementLocated(By.id("terms")),
                        ExpectedConditions.elementToBeClickable(By.id("terms"))
                )
        );
        chkAccept.click();
    }

    public void clickOnPlaceOrderBtn(){
        btnPlaceOrder.click();
    }


    public void fillPersonalDetails(){
        setFirstName("Thanh");
        setLastName("Nguyen Duc");
        setCompanyName("Fresh Company");
        setCountryName("India");
        setStreetAddress("86/34, Thong Nhat Street");
        setCity("Minto Road");
        setState("Delhi");
        setPostCode("110002");
        setPhone("123456789");
        setEmail("test@gmail.com");
    }




}
