package tests;

import pageObjects.CalculatorAppPage;
import utils.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class AndroidCalculator extends TestBase {

    CalculatorAppPage calculatorAppPage;

    @DataProvider(name = "Calculator Script")
    public Object[][] passScript() throws IOException, ParseException {
        Object[][] objJSON = JsonReader.getJSONScript
                (System.getProperty("user.dir") + "/data/CalculatorData.json",
                        "Calculator Script", 3);
        return (String[][]) objJSON;
    }

    @Test(dataProvider = "Calculator Script")
    public void testCalculatorApp1(String operatorType, String Operand1, String Operand2) throws IOException, InterruptedException, SQLException, ParseException {
        //testJSON();
        androidSetUp("com.google.android.calculator","com.android.calculator2.Calculator","8200","4723","emulator-5554");
        calculatorAppPage = new CalculatorAppPage(appiumDriver);
        calculatorAppPage.executeMathOperation(operatorType);
        tearDown();
    }
/*
    public void testJSON() throws IOException, ParseException {
        String[][] xxx = (String[][]) passScript();
        System.out.println(xxx[0][0]);
    }
*/
/*
    @Test(dataProvider = "Calculator Script")
    public void testCalculatorApp2(String operatorType) throws MalformedURLException, InterruptedException {
        androidSetUp("com.google.android.calculator","com.android.calculator2.Calculator","8201","4724","emulator-5556");
        calculatorAppPage = new CalculatorAppPage(driver);
        calculatorAppPage.executeMathOperation(operatorType);
        tearDown();
    }
 */
}
