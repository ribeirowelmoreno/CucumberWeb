Feature: Login into automation practice website

  Scenario: Login with username and password correctly into automation practice website

    Given user in main page
    When insert the correct usermane
    When insert the correct password
    Then user page should be showed
    Then close browser

