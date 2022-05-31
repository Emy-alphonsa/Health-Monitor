Feature: to test rest api call

  Scenario: check rest api start call is success
    Given I set start GET request api endpoint
    When I submit the start GET request
    Then I should get 200 Success Status code for start GET request

  Scenario: check rest api stop call is success
    Given I set stop GET request api endpoint
    When I submit the stop GET request
    Then I should get 200 Success Status code for stop GET request

