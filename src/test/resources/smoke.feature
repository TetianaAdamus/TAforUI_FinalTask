Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check language changing
    Given User opens Home page
    When User chooses the Russian language
    Then User checks the first paragraph contains '<word>'
    Examples:
      | word |
      | рыба |


  Scenario Outline: Check start
    Given User opens Home page
    When User puts text generation button
    Then User checks the generated text starts with '<startPhrase>'

    Examples:
      | startPhrase                                               |
      | Lorem ipsum dolor sit amet, consectetur adipiscing elit   |


  Scenario Outline: Check radio buttons
    Given User opens Home page
    When User chooses radiobutton '<value>'
    And User puts <number> in the number field
    And User puts text generation button
    Then User checks the generated text contains <number> '<value>'

    Examples:
      | value | number |
      | words | 10     |
      | words | -1     |
      | words | 0      |
      | words | 5      |
      | words | 20     |
      | bytes | 10     |
      | bytes | 0      |
      | bytes | 5      |
      | bytes | 20     |

  Scenario Outline: Check checkbox
    Given User opens Home page
    When User clears the checkbox
    And User puts text generation button
    Then User checks the generated text does not start with '<startPhrase>'

    Examples:
      | startPhrase |
      | Lorem ipsum |

    Scenario Outline: check generated text
      Given User opens Home page
      When User puts text generation button
      And User calculates number of '<word>' in the text
      And User repeats the same action <number> times for the same '<word>'
      Then User checks the result divided into <number> is more than <checkedNumber>

      Examples:
        | word      | number | checkedNumber |
        | lorem     | 10     | 2             |










