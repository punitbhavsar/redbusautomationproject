@OnlineBusTickets
Feature: Search buses for return journey
 

  @SearchBusTickets
  Scenario Outline: Verify that user is able to search available buses for a return journey
    Given I am on red bus application home page
    When I input source"<source>" as well as  destination "<destination>" cities
    And I select journey dates from "<From>" to "<To>"and click on search button
    Then I navigated to search results page and see the available buses
    And I click on view seat

    Examples: 
      | source    | destination   	|From					|To						|
      | Mumbai    | Goa       			|10-Dec-2018	|	12-Dec-2018	|

