@us4
Feature: As a user, I should be able to access to Files module.


  Scenario Outline: verify users can access to Files module
    Given user use username "<username>" and passcode "<password>"
    When the user clicks the "Files" module and on files
    Then verify page title is "Files - Trycloud"

  Examples:
    | username | password    |
    | User13   | Userpass123 |
#    | User43   | Userpass123 |
#    | User73   | Userpass123 |
#    | User103  | Userpass123 |

  Scenario Outline: verify users can select all the uploaded files from the page
    Given user use username "<username>" and passcode "<password>"
    When the user clicks the "Files" module
    And user click the top-left checkbox of the table
    Then verify all the files are selected

    Examples:
      | username | password    |
      | User13   | Userpass123 |
#      | User43   | Userpass123 |
#      | User73   | Userpass123 |
#      | User103  | Userpass123 |
