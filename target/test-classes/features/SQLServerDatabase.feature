Feature: SQLServer Database

  @SQLServerDatabaseTesting @device_Windows @author_JohnDoe
  Scenario Outline: SQLServer DB Testing
    Given I need to see all SQLServer cities in a particular country
    When I enter "<Country>" as SQLServer parameter
    Then It should return SQLServer cities in that country

    Examples:
    | Country     |
    | Canada      |
    | Philippines |
    | India       |
    | Mexico      |