@HeathCheck
Feature: Confirm the TradeMe website is up
  As a TradeMe user, I can access the TradeMe website, so that I can use TradeMe's services.

  Scenario: Confirm the TradeMe Website is up
    When I navigate to the homepage
    Then the homepage loads successfully
