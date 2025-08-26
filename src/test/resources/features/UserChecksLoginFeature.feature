Feature: User checks how login feature works

  Scenario Outline: User wants to login with invalid credentials
    Given User clicks My account on header bar
    When User provided credentials <usernameOrEmail> and <password>
    Then Clicks on Log in button
    Then User couldn`t log in

    Examples:
    | usernameOrEmail   | password |
    | cookieCrisp       | haslo    |
    | lol               | ""       |
    | invalid@gmail.com | PAK      |