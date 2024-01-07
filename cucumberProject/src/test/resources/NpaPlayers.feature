Feature: Player Stats

  Scenario Outline: Validate player stats for a specific season
    Given User is on NPA players page
    When User filters by season "<Season>"
    Then Verify the top player is "<TopPlayer>"
    And sorts by "<Point>"

    Examples:
      | Season    | TopPlayer        | Point   |
      | 2010-11   | Kevin Durant     | 27.7    |
      | 1999-00   | Shaquille O'Neal | 29.7    |
