Feature: Team Stats

  Scenario Outline: Validate team stats for a specific season
    Given User is on the leaders teams page
    When Filter list by season "<Season>"
    Then Verify the top team is "<TopTeam>"

    Examples:
      | Season     | TopTeam            |
      | 2010-11    | Chicago Bulls      |
      | 1999-00    | Los Angeles Lakers |
