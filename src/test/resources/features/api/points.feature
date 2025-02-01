Feature: Points

  Scenario Outline: Search for a Parcel Lockers
    Given I have a city "<city>"
    When I search for Parcel Lockers in that city
    Then the response should not be empty
    And the response should have a status code 200
    When I search for all Parcel Lockers across all pages in that city
    And I save the results to a JSON file
    Then the number of results should be equal to the size of the result list

    Examples:
      | city     |
      | Panki    |
      | Warszawa |
      | Poznań   |
      | Kraków   |
      | Wrocław  |