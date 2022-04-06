Feature: Hello! features

  Background:
    Given the user lands on home page

  @smoke
  Scenario Outline: the user can able to navigate Hello! web pages <linkName>
    When the user scrolls down to the bottom of the webpage
    And the user clicks on "<linkName>" link
    Then the user navigates "<URL>"
    Examples:
      | linkName   |  | URL                                                                              |
      | Trustpilot |  | https://www.trustpilot.com/review/www.backmarket.com                             |
      | Glassdoor  |  | https://www.glassdoor.com/Overview/Working-at-Back-Market-EI_IE1780208.11,22.htm |
      | Medium     |  | https://backmarket.medium.com/                                                   |
      | The Rock   |  | https://backmarket.therock.com/                                                  |


