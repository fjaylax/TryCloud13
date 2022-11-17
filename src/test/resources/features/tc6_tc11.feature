Feature: As a user, I should be able to remove files from favorites and upload a file directly

  Background:
#    Given user on the dashboard page


  Scenario Outline: verify users to remove files to Favorites
    Given user use username "<username>" and passcode "<password>" and login
    When  the user clicks the "Files" module
    When  the users click action-icon from any file on the page to remove
    And   user choose the "Remove from favorites" option
    And   user click the "Favorites" sub-module on the left side
    Then  Verify that the file is removed from the Favorites sub-module’s table

    Examples:
      | username | password    |
      | user13   | Userpass123 |
#      | user43   | Userpass123 |
#      | user73   | Userpass123 |
#      | user103  | Userpass123 |



  Scenario Outline: verify users to upload a file from Files
    Given user use username "<username>" and passcode "<password>" and login
    When  the user clicks the "Files" module
    When  the user clicks the add icon on the top
    And   users uploads file with the “upload file” option
    Then  verify the file is displayed on the page

    Examples:
      | username | password    |
      | user13   | Userpass123 |
#      | user43   | Userpass123 |
#      | user73   | Userpass123 |
#      | user103  | Userpass123 |



  Scenario Outline: verify users to access to Talks module
    Given user use username "<username>" and passcode "<password>" and login
    When the user clicks the "Talk" module
    Then verify the page title is "Talk - Trycloud QA"

    Examples:
      | username | password    |
      | user13   | Userpass123 |
#      | user43   | Userpass123 |
#      | user73   | Userpass123 |
#      | user103  | Userpass123 |


  @wip
  Scenario Outline: verify users to send a message
    Given user use username "<username>" and passcode "<password>" and login
    When the user clicks the "Talk" module
    And user search user from the search box
    And user write a message
    And user clicks to submit button
    Then the user should be able to see the message is displayed on the conversation log

    Examples:
      | username | password    |
      | user13   | Userpass123 |
#      | user43   | Userpass123 |
#      | user73   | Userpass123 |
#      | user103  | Userpass123 |