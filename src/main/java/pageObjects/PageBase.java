package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PageBase {

    AppiumDriver appiumDriver;
    WebDriver webDriver;
    MobileElement testMobileElement;
    WebElement testWebElement;

    Connection sqlConnection;
    public static final long WAIT = 10;

    public PageBase(AppiumDriver appium_driver){
        PageFactory.initElements(new AppiumFieldDecorator(appium_driver), this);
        appiumDriver = appium_driver;
    }
    public PageBase(WebDriver web_driver){
        webDriver = web_driver;
    }

    public PageBase(Connection connection) {
        sqlConnection = connection;
    }
    public List<String> executeSQLStatement(String statement) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        List<String> result = new ArrayList<>();
        try {
            stmt = sqlConnection.createStatement();
            if (stmt.execute(statement)) {
                rs = stmt.getResultSet();
                while (rs.next()) {
                    result.add(rs.getString(1));
                }
            }
        }
        catch (SQLException ex){
            // handle any errors
            throw new SQLException("Error running SQL statement " + statement);
            //System.out.println("SQLException: " + ex.getMessage());
            //System.out.println("SQLState: " + ex.getSQLState());
            //System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
        return result;
    }
    public boolean waitForVisibility(MobileElement element){
        WebDriverWait wait = new WebDriverWait(appiumDriver, WAIT);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver, WAIT);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean waitForVisibilityMobile(String ByWhat, String elementName){
        try {
            WebDriverWait wait = new WebDriverWait(appiumDriver, WAIT);
            switch (ByWhat) {
                case "XPATH":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
                    testMobileElement = (MobileElement) appiumDriver.findElementByXPath(elementName);
                    break;
                case "ID":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementName)));
                    testMobileElement = (MobileElement) appiumDriver.findElementById(elementName);
                    break;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean waitForVisibilityWeb(String ByWhat, String elementName){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, WAIT);
            switch (ByWhat) {
                case "XPATH":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
                    testWebElement = webDriver.findElement(By.xpath(elementName));
                    break;
                case "ID":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementName)));
                    testWebElement = webDriver.findElement(By.id(elementName));
                    break;
                case "LINKTEXT":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementName)));
                    testWebElement = webDriver.findElement(By.linkText(elementName));
                    break;
                case "CSS":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementName)));
                    testWebElement = webDriver.findElement(By.cssSelector(elementName));
                    break;
            }
            Thread.sleep(500);
            return true;
        } catch (TimeoutException | InterruptedException e) {
            return false;
        }
    }

    public void clear(MobileElement element){
        waitForVisibility(element);
        element.clear();
    }

    public void clickMobile(MobileElement element) {
        if (waitForVisibility(element))
            element.click();
    }
    public void clickWeb(String ByWhat, String ElementName){
        if (waitForVisibilityWeb(ByWhat,ElementName)) {

            Capabilities capabilities = ((RemoteWebDriver)webDriver).getCapabilities();
            switch (capabilities.getBrowserName().toUpperCase()) {
                case "MSEDGE":
                case "CHROME":
                    testWebElement.click();
                    break;
                case "FIREFOX":
                    Actions act = new Actions(webDriver);
                    act.moveToElement(testWebElement);
                    WebDriverWait wait = new WebDriverWait(webDriver, 10);
                    wait.until(ExpectedConditions.elementToBeClickable(testWebElement));
                    JavascriptExecutor executor  = (JavascriptExecutor)webDriver;
                    executor.executeScript("arguments[0].scrollIntoView();",testWebElement);
                    act.click().perform();
                    break;
            }
        }
        else
            throw new TimeoutException("Timeout locating " + ByWhat + " element " + ElementName);
    }
    public void clickByXPath(String strXPATH){
        if (waitForVisibilityMobile("XPATH", strXPATH))
            testMobileElement.click();
    }
    public void clickByID(String strID){
        if (waitForVisibilityMobile("ID", strID))
            testMobileElement.click();
    }
    public void sendText(MobileElement element, String text){
        if (waitForVisibility(element))
            element.sendKeys(text);
    }
    public void sendTextWeb(String ByWhat, String ElementName, String TextToSend){
        if (waitForVisibilityWeb(ByWhat, ElementName)) {
            testWebElement.sendKeys(TextToSend);
        } else
            throw new TimeoutException("Timeout locating " + ByWhat + " element " + ElementName);
    }
    public void sendTextByXPath(String elementName, String textToSend){
        if (waitForVisibilityMobile("XPATH", elementName))
            testMobileElement.sendKeys(textToSend);
    }
    public void sendTextDTPickerByXPath(String elementName, String textToSend){
        if (waitForVisibilityMobile("XPATH", elementName))
            clickMobile(testMobileElement);
        testMobileElement.clear();
        sendText(testMobileElement, textToSend);
    }
    public String getAttribute(MobileElement element, String attribute){
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }
    public String getAttributeWeb(String byWhat, String elementName){
        if (waitForVisibilityWeb(byWhat, elementName))
            return testWebElement.getText();
        else
            return "";
    }
}
