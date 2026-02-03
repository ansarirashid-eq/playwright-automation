Feature: Login functionality
  As a registered user
  I want to login to the application
  So that I can access my dashboard

  Background:
    Given i am on login page

  @Positive
  Scenario: Successfully login with valid credentials
    When i enter valid username and valid password
    And i click the login button
    Then i should be redirected to the dashboard

  @Negative
  Scenario: Trying login with invalid credentials
    When i enter invalid user name or invalid password
    And i click the login button
    Then i should see the error message

  @Edge
  Scenario: Trying login without username and password
    When i click login button without entering username and password
    Then i should see the required error message


















