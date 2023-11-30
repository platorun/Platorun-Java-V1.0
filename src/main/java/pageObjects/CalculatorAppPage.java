package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalculatorAppPage extends PageBase {

    public CalculatorAppPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    public int mathOperand1 = 0;
    public int mathOperand2 = 0;
    public String mathOperation;
    @AndroidFindBy(id = "digit_9")
    MobileElement addOperand1;

    @AndroidFindBy(id = "digit_8")
    MobileElement addOperand2;

    @AndroidFindBy(id = "op_add")
    MobileElement operatorAdd;

    @AndroidFindBy(id = "op_mul")
    MobileElement operatorMultiply;

    @AndroidFindBy(id = "op_div")
    MobileElement operatorDivide;

    @AndroidFindBy(id = "op_sub")
    MobileElement operatorSubtract;

    @AndroidFindBy(id = "eq")
    MobileElement addEquals;
    public void performOperandClicks(int operand) {
        String strOperand = Integer.toString(operand);
        for (int i=0; i < strOperand.length(); i++) {
            clickByID("digit_" + strOperand.substring(i,i+1));
        }
    }
    public void mathOperatorAdd() {
        performOperandClicks(mathOperand1);
        clickMobile(operatorAdd);
        performOperandClicks(mathOperand2);
        clickMobile(addEquals);
    }
    public void mathOperatorSubtract() {
        performOperandClicks(mathOperand1);
        clickMobile(operatorSubtract);
        performOperandClicks(mathOperand2);
        clickMobile(addEquals);
    }
    public void mathOperatorMultiply() {
        performOperandClicks(mathOperand1);
        clickMobile(operatorMultiply);
        performOperandClicks(mathOperand2);
        clickMobile(addEquals);
    }
    public void mathOperatorDivide() {
        performOperandClicks(mathOperand1);
        clickMobile(operatorDivide);
        performOperandClicks(mathOperand2);
        clickMobile(addEquals);
    }
    public void doMathOperation(String operatorType) {
        switch (operatorType) {
            case "ADD":
                mathOperatorAdd();
                break;
            case "SUB":
                mathOperatorSubtract();
                break;
            case "MUL":
                mathOperatorMultiply();
                break;
            case "DIV":
                mathOperatorDivide();
                break;
        }
    }
    public void executeMathOperation(String operatorType) {

        clickMobile(addOperand1);
        switch (operatorType) {
            case "ADD":
                clickMobile(operatorAdd);
                break;
            case "SUB":
                clickMobile(operatorSubtract);
                break;
            case "MUL":
                clickMobile(operatorMultiply);
                break;
            case "DIV":
                clickMobile(operatorDivide);
                break;
        }
        clickMobile(addOperand2);
        clickMobile(addEquals);
    }

}
