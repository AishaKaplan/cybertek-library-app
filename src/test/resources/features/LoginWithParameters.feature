@param
Feature: Login with parameters


  Scenario: Login as librarian 1261
    Given I am on the login page
    When I enter username "librarian1261@library"
    And I enter password 'ICf9pm9S'
    And click the sign in button
    And there should be 818 users
    Then dashboard should be displayed



  Scenario: Login as student 33377
    Given I am on the login page
    When I enter username "student3377@library"
    And I enter password '7ntM5Zzx'
    And click the sign in button
    Then books should be


  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian1261@library" and "ICf9pm9S"
    Then dashboard should be displayed