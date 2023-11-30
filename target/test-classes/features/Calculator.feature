Feature: Android Calculator

  @AppiumAndroidTesting @device_Android @author_AlfredoNatividad
  Scenario Outline: Math Operations
    Given I have two numbers <Operator1> and <Operator2>
    When I "<DoMathOperation>" the two numbers
    Then It should give a value of <Result>

    Examples:
    | Operator1 | Operator2 | DoMathOperation | Result |
    | 75        | 25        | ADD             | 100    |
    | 20        | 10        | MUL             | 200    |
