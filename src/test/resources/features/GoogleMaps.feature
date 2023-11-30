Feature: Android Google Maps

  @AppiumAndroidTesting @device_Android @author_AlfredoNatividad
  Scenario Outline: Map Navigation
    Given The user search "<Destination>" in Google Maps
    When The user enters "<Start Location>" in the map
    Then Google Maps should start navigating from "<Start Location>" to "<Destination>"

    Examples:
    | Destination        | Start Location |
    | 46.51523,-84.29121 | Your location  |
