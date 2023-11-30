Feature: Web UI Testing

  @SeleniumWebTesting @device_Chrome @author_JoonCastro
  Scenario Outline: Chrome Online Shopping
    Given I want to purchase items online using Google Chrome
    And I login with my "<Username>" and "<Password>" credentials
    And I add "<InventoryItem>" to my cart
    And I checkout and fill in my "<FirstName>", "<LastName>", "<PostalCode>" shipping details
    When I continue and click Finish
    Then A confirmation message "<ConfirmMessage>" should be displayed on the screen

    Examples:
      | Username      | Password     | InventoryItem         | FirstName | LastName | PostalCode   | ConfirmMessage           |
      | standard_user | secret_sauce | Sauce Labs Bike Light | Johnny    | Bravo    | 90210        | THANK YOU FOR YOUR ORDER 2|

  #@SeleniumWebTesting @device_Firefox @author_AlfredoNatividad
  #Scenario Outline: Firefox Online Shopping
  #  Given I want to purchase items online using Mozilla Firefox
  #  And I login with my "<Username>" and "<Password>" credentials
  #  And I add "<InventoryItem>" to my cart
  #  And I checkout and fill in my "<FirstName>", "<LastName>", "<PostalCode>" shipping details
  #  When I continue and click Finish
  #  Then A confirmation message "<ConfirmMessage>" should be displayed on the screen

  #  Examples:
  #    | Username      | Password     | InventoryItem         | FirstName | LastName | PostalCode   | ConfirmMessage           |
  #    | standard_user | secret_sauce | Sauce Labs Bike Light | Johnny    | Bravo    | 90210        | THANK YOU FOR YOUR ORDER |