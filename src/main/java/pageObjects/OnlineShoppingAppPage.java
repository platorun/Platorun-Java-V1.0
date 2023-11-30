package pageObjects;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OnlineShoppingAppPage extends PageBase {

    public OnlineShoppingAppPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "user-name")
    WebElement UserName;
    @FindBy(id = "password")
    WebElement Password;
    @FindBy(id ="login-button")
    WebElement BtnLogin;
    public void performLogin(String _username, String _password) {
        sendTextWeb("ID","user-name", _username);
        sendTextWeb("ID","password", _password);
        clickWeb("CSS","*[data-test='login-button']");
    }
    public void addItemsToCart(String inventoryItem) {
        clickWeb("LINKTEXT",inventoryItem);
        //clickWeb("XPATH","//button[contains(text(),'Add to cart')]");
        clickWeb("CSS","*[data-test='add-to-cart-sauce-labs-bike-light']");
    }

    public void checkOutAndFillShippingInformation(String firstName, String lastName, String postalCode) {
        clickWeb("XPATH","//*[@id='shopping_cart_container']/a");
        clickWeb("XPATH","//button[contains(text(),'Checkout')]");
        sendTextWeb("XPATH","//*[@id='first-name']",firstName);
        sendTextWeb("XPATH","//*[@id='last-name']",lastName);
        sendTextWeb("XPATH","//*[@id='postal-code']",postalCode);
        clickWeb("XPATH","//*[@id='continue']");
    }
    public void completeTransaction() {
        clickWeb("XPATH","//*[@id='finish']");
    }
    public void verifyConfirmationMessage(String msgConfirm) {
        String txtResult = getAttributeWeb("XPATH", "//h2");
        Assert.assertEquals(txtResult,msgConfirm);
    }
}
