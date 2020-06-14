Feature: Bank Account

        Scenario: Deposit 1000 euros and Print the statement balance
        Given I deposit 1000 euros
        When I print the statement
        Then My balance should be 1000