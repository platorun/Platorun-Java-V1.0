Feature: API Testing

  @RestAPITesting @device_Windows @author_AlfredoNatividad
  Scenario Outline: Place By Country and Zip Code
    Given I need to know the name of a place by country and zip code
    When I enter "<CountryCode>" as country code
    And I enter "<ZipCode>" as zip code
    Then The API should provide me the exact place as "<PlaceName>"

    Examples:
    | CountryCode | ZipCode | PlaceName                |
    | us          | 90210   | Beverly Hills            |
    | us          | 12345   | Schenectady              |
    | ca          | P6B     | Sault Ste. Marie Central |