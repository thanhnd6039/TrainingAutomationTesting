package cucumber.selenium;

import cucumber.managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Wait {
    private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds){
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
        webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        try {
            webDriverWait.until(waitCondition);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition){
        until(driver, waitCondition, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
    }

    public static void untilPageLoadComplete(WebDriver driver){
        until(driver, (d) ->
        {
            Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded)
                System.out.println("Document is loading");
            return isPageLoaded;
        });
    }

    public static void untilJQueryIsDone(WebDriver driver){
        until(driver, (d) ->
        {
            Boolean isJqueryCallDone  = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone )
                System.out.println("Jquery call is in progress");
            return isJqueryCallDone;
        });
    }
}
