@UsedCars
Feature: Search for used cars
  As a TradeMe user, I can search for available used cars, so that I can evaluate options for purchasing a used car.

  Scenario: Validate the number of available used car brands
    When I navigate to the available used cars page
    Then there are 4 available used car brands
