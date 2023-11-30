Feature: MySQL Database

  @MySQLDatabaseTesting @device_Windows @author_JohnDoe
  Scenario Outline: MySQL DB Testing
    Given I need to see all cities in a particular country
    When I enter "<Country>" as parameter
    Then It should return all cities in that country

    Examples:
    | Country     |
    | Canada      |
    | Philippines |
    | India       |
    | Mexico      |