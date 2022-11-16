Feature: : As a user, I should be able to update settings.

Scenario Outline: Verify users to see the app storage usage
  Given user use username "<username>" and passcode "<password>"
When the user clicks the "Files" module
And user checks the current storage usage
And user uploads file with the upload file option
And user refresh the page
Then the user should be able to see storage usage is increased

  Examples:
    | username | password    |
    | user13   | Userpass123 |
#    | user43   | Userpass123 |
#    | user73   | Userpass123 |
#    | user103  | Userpass123 |