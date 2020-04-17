Feature: EstimatedDispatchDate

  Scenario: Single supplier
    Given I have Order
    And Order date is 13/04/2020
    And Order consists of products
      | ProductId   | SupplierId   |
      | Nails       | Lenta        |
    And Order is collected
    When Supplier "Lenta" has lead time 1 day
    Then Order dispatched date is 14/04/2020