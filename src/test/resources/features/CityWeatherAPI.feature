Feature: Weather API Testing

  @RestAPITesting @device_Windows @author_Tester1
  Scenario Outline: Weather By City
    Given I need to know the weather of a specific City
    When I enter "<WorldCity>" as the City
    Then The API should provide me the current temperature in Degrees Celcius

    Examples:
    | WorldCity        |
    | Toronto          |
    | Sault Ste. Marie |