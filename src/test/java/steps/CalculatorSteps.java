package steps;

import org.testng.Assert;
import tests.TestBase;
import pageObjects.CalculatorAppPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;
import java.sql.SQLException;

import static org.testng.Assert.assertEquals;

public class CalculatorSteps extends TestBase {
    CalculatorAppPage calculatorAppPage;
    @Given("I have two numbers {int} and {int}")
    public void iHaveTwoNumbersOperator1AndOperator2(int arg0, int arg1) throws MalformedURLException, Throwable {
        androidSetUp("com.google.android.calculator","com.android.calculator2.Calculator","8200","4723","emulator-5554");
        calculatorAppPage = new CalculatorAppPage(TestBase.appiumDriver);
        calculatorAppPage.mathOperand1 = arg0;
        calculatorAppPage.mathOperand2 = arg1;
    }

    @When("I {string} the two numbers")
    public void iPerformMathOperationUsingTheTwoNumbers(String arg0) throws Throwable {
        calculatorAppPage.mathOperation = arg0;
        calculatorAppPage.doMathOperation(arg0);

    }
    @Then("It should give a value of {double}")
    public void itShouldGiveTheCorrectResult(double result) throws InterruptedException, SQLException, Throwable {
        double dResult = 0;
        switch (calculatorAppPage.mathOperation) {
            case "ADD":
                dResult = calculatorAppPage.mathOperand1 + calculatorAppPage.mathOperand2;
                break;
            case "SUB":
                dResult = calculatorAppPage.mathOperand1 - calculatorAppPage.mathOperand2;
                break;
            case "MUL":
                dResult = calculatorAppPage.mathOperand1 * calculatorAppPage.mathOperand2;
                break;
            case "DIV":
                dResult = calculatorAppPage.mathOperand1 / calculatorAppPage.mathOperand2;
                break;
        }
        tearDown();
        //tearDownWithScenario();
        assertEquals(dResult,result);
    }
}
