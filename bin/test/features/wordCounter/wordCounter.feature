Feature: Check word counter
Check: 
    Word counter
    Characters counter
    Keyword density

Scenario Outline: Check word, character counter
    Given Lumu is an user who wants to know words and characters quantity
    When He fills out <text>
    Then He should see words and characters quantity
    And He should see keyword density
Examples:
    |text|
    |Hola mundo|
    |lumu lumu lumu lumu lumu illuminates illuminates attacks and adversaries lumu illuminates all attacks and adversaries|

Scenario: Check empty field
Scenario: Check text with numbers and special characters
