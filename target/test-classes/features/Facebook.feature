Feature: Android Facebook

  @AppiumAndroidTesting @device_Android @author_AlfredoNatividad
  Scenario Outline: Create New Account
    Given I want to create a new Facebook account
    And I enter "<FirstName>" as First Name
    And I enter "<LastName>" as Last Name
    And I enter "<BirthDate>" as Birthday
    And I enter "<Gender>" as Gender
    And I enter "<MobileNumber>" as Mobile Number
    And I enter "<Password>" as Password
    When I submit all information required
    Then The application should create a Facebook account for me

    Examples:
    | FirstName | LastName | BirthDate  | Gender | MobileNumber | Password   |
    | Johnny    | Bravo    | 1980/01/01 | Male   | 8001234567   | $Johnny123 |