@smoke
Feature: User account tests
  As a user, I should be able to login with different users using their correct emails and passwords. When I login, I should be able to see username in the account username section.


  Scenario Outline: Verify user information <email>
    Given I am on the login page
    When I login using "<email>" and "<password>"
    Then account holder name should be "<name>"

    Examples:
      | email                   | password | name
      | student3366@library     | MU0rEdlK | Test Student 3366
      | student3367@library     | GbZeYc7z | Test Student 3367
      | 3368student3368@library | NOgZ81Bn | Test Student 3368
      | student3369@library     | ANPknP6Q | Test Student 3369


