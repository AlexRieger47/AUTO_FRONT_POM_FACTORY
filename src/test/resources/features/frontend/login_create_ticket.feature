Feature: Login and Create Ticket
  As a registered user
  I want to log in and create a support ticket
  So that I can track and manage my issues

  Background:
    Given the user is on the login page

  Scenario Outline: Successful login with valid credentials
    When the user logs in with username "<username>" and password "<password>"
    Then the user should be redirected to the ticket list page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario: Create a new ticket after login
    Given the user is logged in with username "standard_user" and password "secret_sauce"
    When the user navigates to create a new ticket
    And the user fills in the ticket title "Production bug fix"
    And the user fills in the ticket description "Critical issue affecting production"
    And the user submits the ticket
    Then the ticket "Production bug fix" should be visible in the ticket list
