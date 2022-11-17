Feature: : As a user, I should be able to update settings.


Scenario Outline: Verify users update settings
  Given user use username "<username>" and passcode "<password>"
When the user clicks the "Files" module
And user clicks Settings on the left bottom corner
Then the user should be able to click any buttons

  Examples:
    | username | password    |
    | user13   | Userpass123 |
#    | user43   | Userpass123 |
#    | user73   | Userpass123 |
#    | user103  | Userpass123 |


