@Feature_File_Login @login
Feature: Login

  Scenario Outline: Login with valid credentials
    Given the user open the SwagLabs app
    When the user enter a valid username "<username>" and password "<password>"
    And the user click on the login button with username "<username>" and password "<password>"
    Then the app navigates to the home screen
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |